package com.dsfa.nc.web.pd.course.persistence.lesson.base;

import com.dsfa.platform.starter.meta.base.DsfaBaseModel;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseCourseware<M extends BaseCourseware<M>> extends DsfaBaseModel<M> implements IBean {

	public M setNcCoursesCoursewareId(java.lang.String ncCoursesCoursewareId) {
		set("nc_courses_courseware_id", ncCoursesCoursewareId);
		return (M)this;
	}
	
	public java.lang.String getNcCoursesCoursewareId() {
		return getStr("nc_courses_courseware_id");
	}

	public M setFileUrl(java.lang.String fileUrl) {
		set("file_url", fileUrl);
		return (M)this;
	}
	
	public java.lang.String getFileUrl() {
		return getStr("file_url");
	}
	
	public M setLinkPcUrl(java.lang.String linkPcUrl) {
		set("link_pc_url", linkPcUrl);
		return (M)this;
	}
	
	public java.lang.String getLinkPcUrl() {
		return getStr("link_pc_url");
	}
	
	public M setFileAdditionUrl(java.lang.String fileAdditionUrl) {
		set("file_addition_url", fileAdditionUrl);
		return (M)this;
	}
	
	public java.lang.String getFileAdditionUrl() {
		return getStr("file_addition_url");
	}
	
	public M setLinkMobileUrl(java.lang.String linkMobileUrl) {
		set("link_mobile_url", linkMobileUrl);
		return (M)this;
	}
	
	public java.lang.String getLinkMobileUrl() {
		return getStr("link_mobile_url");
	}
	
	public M setRemark(java.lang.String remark) {
		set("remark", remark);
		return (M)this;
	}
	
	public java.lang.String getRemark() {
		return getStr("remark");
	}
	
	public M setDuration(java.lang.String duration) {
		set("duration", duration);
		return (M)this;
	}
	
	public java.lang.String getDuration() {
		return getStr("duration");
	}
	
	public M setTitle(java.lang.String title) {
		set("title", title);
		return (M)this;
	}
	
	public java.lang.String getTitle() {
		return getStr("title");
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
	
	public M setStateValue(java.lang.String stateValue) {
		set("state_value", stateValue);
		return (M)this;
	}
	
	public java.lang.String getStateValue() {
		return getStr("state_value");
	}
	
	public M setStateText(java.lang.String stateText) {
		set("state_text", stateText);
		return (M)this;
	}
	
	public java.lang.String getStateText() {
		return getStr("state_text");
	}
	
	public M setSumDurationLong(java.lang.String sumDurationLong) {
		set("sum_duration_long", sumDurationLong);
		return (M)this;
	}
	
	public java.lang.String getSumDurationLong() {
		return getStr("sum_duration_long");
	}
	
	public M setIsSlicedValue(java.lang.String isSlicedValue) {
		set("is_sliced_value", isSlicedValue);
		return (M)this;
	}
	
	public java.lang.String getIsSlicedValue() {
		return getStr("is_sliced_value");
	}
	
	public M setIsSlicedText(java.lang.String isSlicedText) {
		set("is_sliced_text", isSlicedText);
		return (M)this;
	}
	
	public java.lang.String getIsSlicedText() {
		return getStr("is_sliced_text");
	}
	
}
