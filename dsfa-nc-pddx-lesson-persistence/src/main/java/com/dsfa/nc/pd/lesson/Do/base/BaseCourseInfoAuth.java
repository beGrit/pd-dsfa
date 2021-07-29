package com.dsfa.nc.pd.lesson.Do.base;

import com.dsfa.platform.starter.meta.base.DsfaBaseModel;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseCourseInfoAuth<M extends BaseCourseInfoAuth<M>> extends DsfaBaseModel<M> implements IBean {

	public M setNcCoursesInfoAuthId(String ncCoursesInfoAuthId) {
		set("nc_courses_info_auth_id", ncCoursesInfoAuthId);
		return (M)this;
	}
	
	public String getNcCoursesInfoAuthId() {
		return getStr("nc_courses_info_auth_id");
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
	
	public M setTitle(String title) {
		set("title", title);
		return (M)this;
	}
	
	public String getTitle() {
		return getStr("title");
	}
	
	public M setStateValue(String stateValue) {
		set("state_value", stateValue);
		return (M)this;
	}
	
	public String getStateValue() {
		return getStr("state_value");
	}
	
	public M setStateText(String stateText) {
		set("state_text", stateText);
		return (M)this;
	}
	
	public String getStateText() {
		return getStr("state_text");
	}
	
	public M setClassificationValue(String classificationValue) {
		set("classification_value", classificationValue);
		return (M)this;
	}
	
	public String getClassificationValue() {
		return getStr("classification_value");
	}
	
	public M setClassificationText(String classificationText) {
		set("classification_text", classificationText);
		return (M)this;
	}
	
	public String getClassificationText() {
		return getStr("classification_text");
	}
	
	public M setIsPublishValue(String isPublishValue) {
		set("is_publish_value", isPublishValue);
		return (M)this;
	}
	
	public String getIsPublishValue() {
		return getStr("is_publish_value");
	}
	
	public M setIsPublishText(String isPublishText) {
		set("is_publish_text", isPublishText);
		return (M)this;
	}
	
	public String getIsPublishText() {
		return getStr("is_publish_text");
	}
	
	public M setViewTotle(String viewTotle) {
		set("view_totle", viewTotle);
		return (M)this;
	}
	
	public String getViewTotle() {
		return getStr("view_totle");
	}
	
	public M setPeriod(String period) {
		set("period", period);
		return (M)this;
	}
	
	public String getPeriod() {
		return getStr("period");
	}
	
	public M setRTypeValue(String rTypeValue) {
		set("r_type_value", rTypeValue);
		return (M)this;
	}
	
	public String getRTypeValue() {
		return getStr("r_type_value");
	}
	
	public M setRTypeText(String rTypeText) {
		set("r_type_text", rTypeText);
		return (M)this;
	}
	
	public String getRTypeText() {
		return getStr("r_type_text");
	}
	
	public M setTeacherShow(String teacherShow) {
		set("teacher_show", teacherShow);
		return (M)this;
	}
	
	public String getTeacherShow() {
		return getStr("teacher_show");
	}
	
	public M setRLabelValue(String rLabelValue) {
		set("r_label_value", rLabelValue);
		return (M)this;
	}
	
	public String getRLabelValue() {
		return getStr("r_label_value");
	}
	
	public M setRLabelText(String rLabelText) {
		set("r_label_text", rLabelText);
		return (M)this;
	}
	
	public String getRLabelText() {
		return getStr("r_label_text");
	}
	
	public M setCover(String cover) {
		set("cover", cover);
		return (M)this;
	}
	
	public String getCover() {
		return getStr("cover");
	}
	
	public M setTeacherShowUnitJob(String teacherShowUnitJob) {
		set("teacher_show_unit_job", teacherShowUnitJob);
		return (M)this;
	}
	
	public String getTeacherShowUnitJob() {
		return getStr("teacher_show_unit_job");
	}
	
	public M setContent(String content) {
		set("content", content);
		return (M)this;
	}
	
	public String getContent() {
		return getStr("content");
	}
	
	public M setDuration(String duration) {
		set("duration", duration);
		return (M)this;
	}
	
	public String getDuration() {
		return getStr("duration");
	}
	
	public M setIsTopValue(String isTopValue) {
		set("is_top_value", isTopValue);
		return (M)this;
	}
	
	public String getIsTopValue() {
		return getStr("is_top_value");
	}
	
	public M setIsTopText(String isTopText) {
		set("is_top_text", isTopText);
		return (M)this;
	}
	
	public String getIsTopText() {
		return getStr("is_top_text");
	}
	
	public M setRCode(String rCode) {
		set("r_code", rCode);
		return (M)this;
	}
	
	public String getRCode() {
		return getStr("r_code");
	}
	
	public M setTeacherValue(String teacherValue) {
		set("teacher_value", teacherValue);
		return (M)this;
	}
	
	public String getTeacherValue() {
		return getStr("teacher_value");
	}
	
	public M setTeacherText(String teacherText) {
		set("teacher_text", teacherText);
		return (M)this;
	}
	
	public String getTeacherText() {
		return getStr("teacher_text");
	}
	
}

