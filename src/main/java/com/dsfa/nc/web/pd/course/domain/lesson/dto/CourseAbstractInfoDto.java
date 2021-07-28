package com.dsfa.nc.web.pd.course.domain.lesson.dto;

import lombok.Data;

/**
 * @ClassName CourseAbstractInfo 课程简介
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/27
 **/
@Data
public class CourseAbstractInfoDto {
    private String id;
    private String title;
    private String cover;
    private String duration;
    private String viewTotle;
    private TeacherAbstractInfoDto teacher;

    public CourseAbstractInfoDto() {
    }
}
