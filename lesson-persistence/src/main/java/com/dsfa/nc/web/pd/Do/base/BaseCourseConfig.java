package com.dsfa.nc.web.pd.Do.base;

import com.dsfa.platform.starter.meta.base.DsfaBaseModel;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseCourseConfig<M extends BaseCourseConfig<M>> extends DsfaBaseModel<M> implements IBean {

	public M setNcCoursesConfigId(String ncCoursesConfigId) {
		set("nc_courses_config_id", ncCoursesConfigId);
		return (M)this;
	}
	
	public String getNcCoursesConfigId() {
		return getStr("nc_courses_config_id");
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
	
	public M setIsOrderValue(String isOrderValue) {
		set("is_order_value", isOrderValue);
		return (M)this;
	}
	
	public String getIsOrderValue() {
		return getStr("is_order_value");
	}
	
	public M setIsOrderText(String isOrderText) {
		set("is_order_text", isOrderText);
		return (M)this;
	}
	
	public String getIsOrderText() {
		return getStr("is_order_text");
	}
	
	public M setIsSpeedValue(String isSpeedValue) {
		set("is_speed_value", isSpeedValue);
		return (M)this;
	}
	
	public String getIsSpeedValue() {
		return getStr("is_speed_value");
	}
	
	public M setIsSpeedText(String isSpeedText) {
		set("is_speed_text", isSpeedText);
		return (M)this;
	}
	
	public String getIsSpeedText() {
		return getStr("is_speed_text");
	}
	
	public M setIsAutoValue(String isAutoValue) {
		set("is_auto_value", isAutoValue);
		return (M)this;
	}
	
	public String getIsAutoValue() {
		return getStr("is_auto_value");
	}
	
	public M setIsAutoText(String isAutoText) {
		set("is_auto_text", isAutoText);
		return (M)this;
	}
	
	public String getIsAutoText() {
		return getStr("is_auto_text");
	}
	
	public M setRemindTime(String remindTime) {
		set("remind_time", remindTime);
		return (M)this;
	}
	
	public String getRemindTime() {
		return getStr("remind_time");
	}
	
	public M setIsCircleValue(String isCircleValue) {
		set("is_circle_value", isCircleValue);
		return (M)this;
	}
	
	public String getIsCircleValue() {
		return getStr("is_circle_value");
	}
	
	public M setIsCircleText(String isCircleText) {
		set("is_circle_text", isCircleText);
		return (M)this;
	}
	
	public String getIsCircleText() {
		return getStr("is_circle_text");
	}
	
	public M setIsDragValue(String isDragValue) {
		set("is_drag_value", isDragValue);
		return (M)this;
	}
	
	public String getIsDragValue() {
		return getStr("is_drag_value");
	}
	
	public M setIsDragText(String isDragText) {
		set("is_drag_text", isDragText);
		return (M)this;
	}
	
	public String getIsDragText() {
		return getStr("is_drag_text");
	}
	
}

