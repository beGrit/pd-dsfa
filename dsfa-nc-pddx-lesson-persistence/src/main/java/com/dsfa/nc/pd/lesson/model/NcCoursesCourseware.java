package com.dsfa.nc.pd.lesson.model;

import com.dsfa.nc.pd.lesson.model.base.BaseNcCoursesCourseware;
import com.dsfa.platform.starter.db.jfinal.tablebind.TableBind;

/**
 * Generated by JFinal.
 */
@TableBind(
    tableName = "nc_courses_courseware",
    pkName = "nc_courses_courseware_id"
)
public class NcCoursesCourseware extends BaseNcCoursesCourseware<NcCoursesCourseware> {
	public static final NcCoursesCourseware dao = new NcCoursesCourseware().dao();
}