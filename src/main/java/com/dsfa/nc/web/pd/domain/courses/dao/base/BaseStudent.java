package com.dsfa.nc.web.pd.domain.courses.dao.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseStudent<M extends BaseStudent<M>> extends Model<M> implements IBean {

	public M setNcClassStudentId(java.lang.String ncClassStudentId) {
		set("nc_class_student_id", ncClassStudentId);
		return (M)this;
	}
	
	public java.lang.String getNcClassStudentId() {
		return getStr("nc_class_student_id");
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
	
	public M setClassId(java.lang.String classId) {
		set("class_id", classId);
		return (M)this;
	}
	
	public java.lang.String getClassId() {
		return getStr("class_id");
	}
	
	public M setGraduateValue(java.lang.String graduateValue) {
		set("graduate_value", graduateValue);
		return (M)this;
	}
	
	public java.lang.String getGraduateValue() {
		return getStr("graduate_value");
	}
	
	public M setGraduateText(java.lang.String graduateText) {
		set("graduate_text", graduateText);
		return (M)this;
	}
	
	public java.lang.String getGraduateText() {
		return getStr("graduate_text");
	}
	
	public M setDsfaOuaUserId(java.lang.String dsfaOuaUserId) {
		set("dsfa_oua_user_id", dsfaOuaUserId);
		return (M)this;
	}
	
	public java.lang.String getDsfaOuaUserId() {
		return getStr("dsfa_oua_user_id");
	}
	
	public M setCheckStatusValue(java.lang.String checkStatusValue) {
		set("check_status_value", checkStatusValue);
		return (M)this;
	}
	
	public java.lang.String getCheckStatusValue() {
		return getStr("check_status_value");
	}
	
	public M setCheckStatusText(java.lang.String checkStatusText) {
		set("check_status_text", checkStatusText);
		return (M)this;
	}
	
	public java.lang.String getCheckStatusText() {
		return getStr("check_status_text");
	}
	
	public M setTypeValue(java.lang.String typeValue) {
		set("type_value", typeValue);
		return (M)this;
	}
	
	public java.lang.String getTypeValue() {
		return getStr("type_value");
	}
	
	public M setTypeText(java.lang.String typeText) {
		set("type_text", typeText);
		return (M)this;
	}
	
	public java.lang.String getTypeText() {
		return getStr("type_text");
	}
	
	public M setGroupValue(java.lang.String groupValue) {
		set("group_value", groupValue);
		return (M)this;
	}
	
	public java.lang.String getGroupValue() {
		return getStr("group_value");
	}
	
	public M setGroupText(java.lang.String groupText) {
		set("group_text", groupText);
		return (M)this;
	}
	
	public java.lang.String getGroupText() {
		return getStr("group_text");
	}
	
}

