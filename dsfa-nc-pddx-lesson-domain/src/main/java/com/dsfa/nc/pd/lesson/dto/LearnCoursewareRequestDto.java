package com.dsfa.nc.pd.lesson.dto;

import com.dsfa.nc.pd.serializer.TimePointDeserializer;
import com.dsfa.nc.pd.serializer.TimePointSerializer;
import com.dsfa.nc.pd.types.TimePoint;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @ClassName LearnCoursewareRequestDto
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/29
 **/
public class LearnCoursewareRequestDto {
    private String courseId;

    private String coursewareId;

    private TimePoint newTimePoint;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCoursewareId() {
        return coursewareId;
    }

    public void setCoursewareId(String coursewareId) {
        this.coursewareId = coursewareId;
    }

    @JsonSerialize(using = TimePointSerializer.class)
    public TimePoint getNewTimePoint() {
        return newTimePoint;
    }

    @JsonDeserialize(using = TimePointDeserializer.class)
    public void setNewTimePoint(TimePoint newTimePoint) {
        this.newTimePoint = newTimePoint;
    }
}
