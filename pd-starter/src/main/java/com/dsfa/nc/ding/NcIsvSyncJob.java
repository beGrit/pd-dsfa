package com.dsfa.nc.ding;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.dsfa.platform.api.ding.provider.publics.sync.service.IDsfaOuaUserService;
import com.dsfa.platform.api.ding.provider.publics.sync.service.impl.DsfaOuaUnitServiceImpl;
import com.dsfa.platform.api.ding.publics.DingExecute;
import com.dsfa.platform.api.ding.publics.configuration.DingConfiguration;
import com.dsfa.platform.api.ding.publics.pojo.bo.ExecuteParamExpand;
import com.dsfa.platform.sdk.common.ExpandPojo;
import com.dsfa.platform.sdk.json.JSONObject;
import com.dsfa.platform.starter.db.jfinal.plugin.activerecord.Db;
import com.dsfa.platform.starter.db.jfinal.plugin.activerecord.Record;
import com.dsfa.platform.starter.db.jfinal.plugin.activerecord.builder.i.IRecordBuilder;
import com.dsfa.platform.starter.job.core.annotation.JobHandler;
import com.dsfa.platform.starter.job.core.kit.JobKit;
import com.dsfa.platform.starter.meta.api.oua2.pojo.po.DsfaOuaUnit;
import com.dsfa.platform.starter.meta.api.oua2.pojo.po.DsfaOuaUser;
import com.dsfa.platform.starter.meta.part.oua2.pojo.CommonResult;
import com.dsfa.platform.starter.meta.part.oua2.service.IApiUnitService;
import com.dsfa.platform.starter.meta.part.oua2.service.IApiUserService;
import com.dsfa.platform.starter.redis.lock.RedisLock;
import com.xxl.job.core.handler.IJobHandler;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author 中曾
 * @Date 2021/7/6 9:39
 * @Version 1.0.0
 * @Description TODO
 **/
@JobHandler("ncIsvDingJob")
public class NcIsvSyncJob extends IJobHandler {

    static final String DING_ISV_RDS = "ding_isv_rds";

    /**
     * 开通应用，全量同步
     */
    static final String RDS_SUITE_SQL = "SELECT suite.id, suite.corp_id, suite.biz_type, suite.status, suite.gmt_modified, suite.biz_data, ticket.biz_data suite_ticket\n" +
            "FROM open_sync_biz_data suite\n" +
            "left join open_sync_biz_data ticket\n" +
            "on suite.subscribe_id = ticket.subscribe_id\n" +
            "where suite.biz_type = 4 and suite.status = 0\n" +
            "and ticket.biz_type = 2\n" +
            "and suite.subscribe_id = '%s_0'";

    /**
     * 增量同步
     */
    static final String RDS_INCREMENT_SQL = "SELECT\n" +
            "    m.id, m.corp_id, m.biz_type, m.status, m.gmt_modified, m.biz_data, d.biz_data suite_ticket\n" +
            "FROM\n" +
            "    open_sync_biz_data_medium m\n" +
            "    left join open_sync_biz_data d\n" +
            "    on m.subscribe_id = d.subscribe_id\n" +
            "WHERE\n" +
            "    m.subscribe_id = '%s_0'\n" +
            "    and m.biz_type in (13, 14)\n" +
            "    and m.status = 0\n" +
            "    and d.biz_type = 2\n" +
            "order by biz_type desc, gmt_modified asc";

    DingConfiguration configuration;
    IApiUserService apiUserService;
    IApiUnitService apiUnitService;
    IDsfaOuaUserService ouaUserService;

    @Override
    public void init() throws Exception {
        super.init();
        // 获取spring容器对象示例（不能使用自动注入的方式）：
        configuration = JobKit.getBean(DingConfiguration.class);
        ouaUserService = JobKit.getBean(IDsfaOuaUserService.class);
        apiUserService = JobKit.getBean(IApiUserService.class);
        apiUnitService = JobKit.getBean(IApiUnitService.class);
    }

    @Override
    public void execute() throws Exception {
        RedisLock lock = RedisLock.create(configuration.getAppKey()).expireTime(10000);
        boolean flag = true;
        try {
            // 去重操作
            if (lock.lock()) {
                // 全量
                suiteSync(configuration);
                // 增量
                incrementSync(configuration);
            }
        } finally {
            lock.unLock();
        }
        // 日志输出
        JobKit.log("执行成功！！！！！！！！！！！！！！！！！！！");
    }

    private void suiteSync(DingConfiguration configuration) {
        List<Record> updateDate = new ArrayList<>();
        Db.use(DING_ISV_RDS).find(String.format(RDS_SUITE_SQL, configuration.getAgentId()), new IRecordBuilder() {
            @Override
            public <R> R buildRecord(Record record) {
                RdsData rdsData = new RdsData().set(record.getColumns());
                JSONObject bizData = JSONObject.parseObject(rdsData.getBizData());
                if (bizData.getIntValue("errcode") == 0) {
                    switch (bizData.getString("syncAction")) {
                        case "org_suite_auth":
                        case "org_suite_change":
                            HttpResponse response = null;
                            String result = null;
                            try {
                                response = HttpRequest.get("http://127.0.0.1:" + JobKit.getProp("${server.port}") + "/api/ding/publics/sync/sync")
                                        .form("corpId", rdsData.getCorpId())
                                        .form("suiteTicket", rdsData.getSuiteTicket())
                                        .timeout(10000)
                                        .execute()
                                ;
                                if (response.getStatus() == HttpURLConnection.HTTP_OK && JSONObject.parseObject(result = response.body()).getBooleanValue("success")) {
                                    updateDate.add(new Record().set("id", rdsData.getId()).set("status", 1));
                                    JobKit.log(result);
                                } else {
                                    JobKit.log("请求失败：" + result);
                                }
                            } catch (Exception e) {
                                JobKit.log(e);
                            } finally {
                                if (response != null) {
                                    response.close();
                                }
                            }
                            break;
                        case "org_suite_relieve":
                            updateDate.add(new Record().set("id", rdsData.getId()).set("status", 1));
                            break;
                    }
                }
                return null;
            }
        });
        Db.use(DING_ISV_RDS).batchUpdate("open_sync_biz_data", "id", updateDate, 100);
    }

    private void incrementSync(DingConfiguration configuration) {
        List<Record> updateDate = new ArrayList<>();
        List<DsfaOuaUser> users = new ArrayList<>();
        List<DsfaOuaUnit> depts = new ArrayList<>();
        Db.use(DING_ISV_RDS).find(String.format(RDS_INCREMENT_SQL, configuration.getAgentId()), new IRecordBuilder() {
            @Override
            public <R> R buildRecord(Record record) {
                RdsData rdsData = new RdsData().set(record.getColumns());
                DingExecute.setExecuteParam(new ExecuteParamExpand().setCorpId(rdsData.getCorpId()).setSuiteTicket(rdsData.getSuiteTicket()));
                try {
                    JSONObject bizData = JSONObject.parseObject(rdsData.getBizData());
                    if (bizData.getIntValue("errcode") == 0) {
                        switch (bizData.getString("syncAction")) {
                            case "org_dept_create":
                            case "org_dept_modify":
                            updateDate.add(new Record().set("id", rdsData.getId()).set("status", 1));
                                depts.add(DsfaOuaUnitServiceImpl.toDsfaOuaUnit(configuration, null, bizData));
                                break;
                            case "user_add_org":
                            case "user_modify_org":
                            case "user_dept_change":
//                    case "user_role_change":
                            case "user_active_org":
                                DsfaOuaUser user = ouaUserService.getUserV2(null, bizData.getString("userid"));
                                if (user != null) {
                                    users.add(user);
                                }
                                updateDate.add(new Record().set("id", rdsData.getId()).set("status", 1));
                                break;
                        }
                    }
                } finally {
                    DingExecute.removeExecuteParam();
                }
                return null;
            }
        });


        //TODO 部门保存
        if (!depts.isEmpty()) {
            List<CommonResult<DsfaOuaUnit>> deptResult = apiUnitService.update(depts, 0);
            for (CommonResult<DsfaOuaUnit> r : deptResult) {
                JobKit.log("部门同步失败：" + r.getData().getName() + r.getData().getDeptId() + r.getMessage());
            }
        }
        // TODO 保存用户
        if (!users.isEmpty()) {
            List<CommonResult<DsfaOuaUser>> userResult = apiUserService.update(users, false);
            for (CommonResult<DsfaOuaUser> r : userResult) {
                JobKit.log("用户同步失败：" + r.getData().getName() + r.getData().getDsfaOuaUserId() + r.getMessage());
            }
        }
        Db.use(DING_ISV_RDS).batchUpdate("open_sync_biz_data_medium", "id", updateDate, 100);
    }

    public class RdsData extends ExpandPojo {
        Long id;
        String corpId;
        int bizType;
        int status;
        Date gmtModified;
        String bizData;
        String suiteTicket;

        @Override
        public Boolean hasTran() {
            return super.hasTran();
        }

        public String getSuiteTicket() {
            return suiteTicket != null ? JSONObject.parseObject(suiteTicket).getString("suiteTicket") : null;
        }

        public Long getId() {
            return id;
        }

        public RdsData setId(Long id) {
            this.id = id;
            return this;
        }

        public String getCorpId() {
            return corpId;
        }

        public RdsData setCorpId(String corpId) {
            this.corpId = corpId;
            return this;
        }

        public int getBizType() {
            return bizType;
        }

        public RdsData setBizType(int bizType) {
            this.bizType = bizType;
            return this;
        }

        public int getStatus() {
            return status;
        }

        public RdsData setStatus(int status) {
            this.status = status;
            return this;
        }

        public Date getGmtModified() {
            return gmtModified;
        }

        public RdsData setGmtModified(Date gmtModified) {
            this.gmtModified = gmtModified;
            return this;
        }

        public String getBizData() {
            return bizData;
        }

        public RdsData setBizData(String bizData) {
            this.bizData = bizData;
            return this;
        }

        public RdsData setSuiteTicket(String suiteTicket) {
            this.suiteTicket = suiteTicket;
            return this;
        }
    }
}