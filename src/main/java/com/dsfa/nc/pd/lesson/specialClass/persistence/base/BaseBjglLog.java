package com.dsfa.nc.pd.lesson.specialClass.persistence.base;

import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseBjglLog<M extends BaseBjglLog<M>> extends Model<M> implements IBean {

	public M setTeasJwglBjglLogId(String teasJwglBjglLogId) {
		set("teas_jwgl_bjgl_log_id", teasJwglBjglLogId);
		return (M)this;
	}

	public String getTeasJwglBjglLogId() {
		return getStr("teas_jwgl_bjgl_log_id");
	}

	public M setDsUpdateUserId(String dsUpdateUserId) {
		set("ds_update_user_id", dsUpdateUserId);
		return (M)this;
	}

	public String getDsUpdateUserId() {
		return getStr("ds_update_user_id");
	}

	public M setDsDeptId(String dsDeptId) {
		set("ds_dept_id", dsDeptId);
		return (M)this;
	}

	public String getDsDeptId() {
		return getStr("ds_dept_id");
	}

	public M setDsCreateUserName(String dsCreateUserName) {
		set("ds_create_user_name", dsCreateUserName);
		return (M)this;
	}

	public String getDsCreateUserName() {
		return getStr("ds_create_user_name");
	}

	public M setDsCreateUserId(String dsCreateUserId) {
		set("ds_create_user_id", dsCreateUserId);
		return (M)this;
	}

	public String getDsCreateUserId() {
		return getStr("ds_create_user_id");
	}

	public M setDsUpdateUserName(String dsUpdateUserName) {
		set("ds_update_user_name", dsUpdateUserName);
		return (M)this;
	}

	public String getDsUpdateUserName() {
		return getStr("ds_update_user_name");
	}

	public M setDsDeleted(String dsDeleted) {
		set("ds_deleted", dsDeleted);
		return (M)this;
	}

	public String getDsDeleted() {
		return getStr("ds_deleted");
	}

	public M setDsOrder(Integer dsOrder) {
		set("ds_order", dsOrder);
		return (M)this;
	}

	public Integer getDsOrder() {
		return getInt("ds_order");
	}

	public M setDsUnitId(String dsUnitId) {
		set("ds_unit_id", dsUnitId);
		return (M)this;
	}

	public String getDsUnitId() {
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

	public M setOldId(String oldId) {
		set("oldId", oldId);
		return (M)this;
	}

	public String getOldId() {
		return getStr("oldId");
	}

	public M setNewId(String newId) {
		set("newId", newId);
		return (M)this;
	}

	public String getNewId() {
		return getStr("newId");
	}

	public M setClassId(String classId) {
		set("classId", classId);
		return (M)this;
	}

	public String getClassId() {
		return getStr("classId");
	}
	
}

