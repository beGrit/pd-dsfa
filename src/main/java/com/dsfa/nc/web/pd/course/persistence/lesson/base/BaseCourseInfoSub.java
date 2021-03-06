package com.dsfa.nc.web.pd.course.persistence.lesson.base;

import com.dsfa.platform.starter.meta.base.DsfaBaseModel;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseCourseInfoSub<M extends BaseCourseInfoSub<M>> extends DsfaBaseModel<M> implements IBean {

	public M setNcCoursesInfoSubId(java.lang.String ncCoursesInfoSubId) {
		set("nc_courses_info_sub_id", ncCoursesInfoSubId);
		return (M)this;
	}
	
	public java.lang.String getNcCoursesInfoSubId() {
		return getStr("nc_courses_info_sub_id");
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
	
	public M setNcCoursesInfoId(java.lang.String ncCoursesInfoId) {
		set("nc_courses_info_id", ncCoursesInfoId);
		return (M)this;
	}
	
	public java.lang.String getNcCoursesInfoId() {
		return getStr("nc_courses_info_id");
	}
	
	public M setType(java.lang.String type) {
		set("type", type);
		return (M)this;
	}
	
	public java.lang.String getType() {
		return getStr("type");
	}
	
	public M setDuration(java.lang.String duration) {
		set("duration", duration);
		return (M)this;
	}
	
	public java.lang.String getDuration() {
		return getStr("duration");
	}
	
	public M setMeasurement(java.lang.String measurement) {
		set("measurement", measurement);
		return (M)this;
	}
	
	public java.lang.String getMeasurement() {
		return getStr("measurement");
	}
	
	public M setTitle(java.lang.String title) {
		set("title", title);
		return (M)this;
	}
	
	public java.lang.String getTitle() {
		return getStr("title");
	}
	
	public M setRType(java.lang.String rType) {
		set("r_type", rType);
		return (M)this;
	}
	
	public java.lang.String getRType() {
		return getStr("r_type");
	}
	
	public M setRSize(java.lang.String rSize) {
		set("r_size", rSize);
		return (M)this;
	}
	
	public java.lang.String getRSize() {
		return getStr("r_size");
	}
	
	public M setRCode(java.lang.String rCode) {
		set("r_code", rCode);
		return (M)this;
	}
	
	public java.lang.String getRCode() {
		return getStr("r_code");
	}
	
	public M setRTypeValue(java.lang.String rTypeValue) {
		set("r_type_value", rTypeValue);
		return (M)this;
	}
	
	public java.lang.String getRTypeValue() {
		return getStr("r_type_value");
	}
	
	public M setRTypeText(java.lang.String rTypeText) {
		set("r_type_text", rTypeText);
		return (M)this;
	}
	
	public java.lang.String getRTypeText() {
		return getStr("r_type_text");
	}
	
	public M setRelationId(java.lang.String relationId) {
		set("relation_id", relationId);
		return (M)this;
	}
	
	public java.lang.String getRelationId() {
		return getStr("relation_id");
	}
	
}

