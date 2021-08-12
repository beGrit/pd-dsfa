package com.dsfa.nc.pd.temp.model.base;

import com.dsfa.platform.starter.db.jfinal.plugin.activerecord.IBean;
import com.dsfa.platform.starter.db.jfinal.plugin.activerecord.Model;
import com.dsfa.platform.starter.db.jfinal.kit.Kv;
import com.dsfa.platform.starter.db.jfinal.plugin.activerecord.Db;
import com.dsfa.platform.starter.db.jfinal.plugin.activerecord.SqlPara;

import java.util.List;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseNcRecordCourse<M extends BaseNcRecordCourse<M>> extends Model<M> implements IBean {

    public M setNcRecordCourseId(java.lang.String ncRecordCourseId) {
        set("nc_record_course_id", ncRecordCourseId);
        return (M)this;
    }

    public java.lang.String getNcRecordCourseId() {
        return getStr("nc_record_course_id");
    }
    public M setDsUpdateUserId(java.lang.String dsUpdateUserId) {
        set("ds_update_user_id", dsUpdateUserId);
        return (M)this;
    }

    public java.lang.String getDsUpdateUserId() {
        return getStr("ds_update_user_id");
    }
    public M setDsDeptId(java.lang.String dsDeptId) {
        set("ds_dept_id", dsDeptId);
        return (M)this;
    }

    public java.lang.String getDsDeptId() {
        return getStr("ds_dept_id");
    }
    public M setDsCreateUserName(java.lang.String dsCreateUserName) {
        set("ds_create_user_name", dsCreateUserName);
        return (M)this;
    }

    public java.lang.String getDsCreateUserName() {
        return getStr("ds_create_user_name");
    }
    public M setDsCreateUserId(java.lang.String dsCreateUserId) {
        set("ds_create_user_id", dsCreateUserId);
        return (M)this;
    }

    public java.lang.String getDsCreateUserId() {
        return getStr("ds_create_user_id");
    }
    public M setDsUpdateUserName(java.lang.String dsUpdateUserName) {
        set("ds_update_user_name", dsUpdateUserName);
        return (M)this;
    }

    public java.lang.String getDsUpdateUserName() {
        return getStr("ds_update_user_name");
    }
    public M setDsDeleted(java.lang.String dsDeleted) {
        set("ds_deleted", dsDeleted);
        return (M)this;
    }

    public java.lang.String getDsDeleted() {
        return getStr("ds_deleted");
    }
    public M setDsOrder(java.lang.Integer dsOrder) {
        set("ds_order", dsOrder);
        return (M)this;
    }

    public java.lang.Integer getDsOrder() {
        return getInt("ds_order");
    }
    public M setDsUnitId(java.lang.String dsUnitId) {
        set("ds_unit_id", dsUnitId);
        return (M)this;
    }

    public java.lang.String getDsUnitId() {
        return getStr("ds_unit_id");
    }
    public M setDsCreateTime(java.util.Date dsCreateTime) {
        set("ds_create_time", dsCreateTime);
        return (M)this;
    }

    public java.util.Date getDsCreateTime() {
        return getDate("ds_create_time");
    }
    public M setDsUpdateTime(java.util.Date dsUpdateTime) {
        set("ds_update_time", dsUpdateTime);
        return (M)this;
    }

    public java.util.Date getDsUpdateTime() {
        return getDate("ds_update_time");
    }
    public M setRelationId(java.lang.String relationId) {
        set("relation_id", relationId);
        return (M)this;
    }

    public java.lang.String getRelationId() {
        return getStr("relation_id");
    }
    public M setWinPeriod(java.lang.String winPeriod) {
        set("win_period", winPeriod);
        return (M)this;
    }

    public java.lang.String getWinPeriod() {
        return getStr("win_period");
    }
    public M setFinishedTime(java.util.Date finishedTime) {
        set("finished_time", finishedTime);
        return (M)this;
    }

    public java.util.Date getFinishedTime() {
        return getDate("finished_time");
    }
    public M setDsfaOuaUserId(java.lang.String dsfaOuaUserId) {
        set("dsfa_oua_user_id", dsfaOuaUserId);
        return (M)this;
    }

    public java.lang.String getDsfaOuaUserId() {
        return getStr("dsfa_oua_user_id");
    }
    public M setIsFinishedValue(java.lang.String isFinishedValue) {
        set("is_finished_value", isFinishedValue);
        return (M)this;
    }

    public java.lang.String getIsFinishedValue() {
        return getStr("is_finished_value");
    }
    public M setIsFinishedText(java.lang.String isFinishedText) {
        set("is_finished_text", isFinishedText);
        return (M)this;
    }

    public java.lang.String getIsFinishedText() {
        return getStr("is_finished_text");
    }
    public M setFinishedRate(java.lang.String finishedRate) {
        set("finished_rate", finishedRate);
        return (M)this;
    }

    public java.lang.String getFinishedRate() {
        return getStr("finished_rate");
    }
    public M setUpTime(java.lang.String upTime) {
        set("up_time", upTime);
        return (M)this;
    }

    public java.lang.String getUpTime() {
        return getStr("up_time");
    }
    public M setYearId(java.lang.String yearId) {
        set("year_id", yearId);
        return (M)this;
    }

    public java.lang.String getYearId() {
        return getStr("year_id");
    }

    public List<M> findLoadColumns(String... columns) {
        Kv kv = Kv.create()
            .set("columnNames", columns)
            .set("tableName", "nc_record_course");
        SqlPara sqlPara = Db.getSqlPara("base.sql." + "findLoadColumns", kv);
        List<M> res = find(sqlPara);
        return res;
    }
}