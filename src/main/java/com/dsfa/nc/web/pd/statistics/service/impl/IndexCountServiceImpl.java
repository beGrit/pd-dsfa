package com.dsfa.nc.web.pd.statistics.service.impl;

import com.dsfa.nc.web.pd.statistics.dto.CountDto;
import com.dsfa.nc.web.pd.statistics.service.IndexCountService;
import com.dsfa.platform.starter.db.jfinal.plugin.activerecord.Db;
import com.dsfa.platform.starter.db.jfinal.plugin.activerecord.Record;
import com.dsfa.platform.starter.db.jfinal.plugin.activerecord.SqlPara;
import com.dsfa.platform.starter.redis.RedisExecute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName IndexCountServiceImplV2
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/27
 **/
@Service("indexCountService")
public class IndexCountServiceImpl implements IndexCountService {
    private static final String SQL_KEY = "page.index.sql.";

    private static final String redisKey = "indexCount";

    /**
     * Key过期时间(单位 秒)
     */
    private static final Long timeout = (long) (60 * 60 * 24);

    @Autowired
    RedisExecute redisExecute;

    @Override
    public long countClass() {
        String itemKey = "class"; // redisKey
        long res = 0;
        Integer count = (Integer) redisExecute.getHash(redisKey, itemKey);
        if (count == null) { // redis无缓存,需要查库
            SqlPara sqlPara = Db.getSqlPara(SQL_KEY + "countClasses");
            Record record = Db.findFirst(sqlPara);
            res = record.get("count(*)");
            // 操作redis
            redisExecute.putHash(redisKey, itemKey, res, timeout);
            return res;
        } else {
            res = count;
            return res;
        }
    }

    @Override
    public long countStudent() {
        String itemKey = "student"; // redisKey
        long res = 0;
        Integer count = (Integer) redisExecute.getHash(redisKey, itemKey);
        if (count == null) { // redis无缓存,需要查库
            SqlPara sqlPara = Db.getSqlPara(SQL_KEY + "countStudents");
            Record record = Db.findFirst(sqlPara);
            res = record.get("count(*)");
            redisExecute.putHash(redisKey, itemKey, res, timeout);
            return res;
        } else {
            res = count;
            return res;
        }
    }

    @Override
    public long countTeacher() {
        String itemKey = "teacher"; // redisKey
        long res = 0;
        Integer count = (Integer) redisExecute.getHash(redisKey, itemKey);
        if (count == null) { // redis无缓存,需要查库
            SqlPara sqlPara = Db.getSqlPara(SQL_KEY + "countTeachers");
            Record record = Db.findFirst(sqlPara);
            res = record.get("count(*)");
            redisExecute.putHash(redisKey, itemKey, res, timeout);
            return res;
        } else {
            res = count;
            return res;
        }
    }

    @Override
    public CountDto getCounts() {
        long c1 = this.countClass();
        long c2 = this.countStudent();
        long c3 = this.countTeacher();
        CountDto countDto = new CountDto();
        countDto.setClassCount(c1);
        countDto.setStudentCount(c2);
        countDto.setTeacherCount(c3);
        return countDto;
    }
}
