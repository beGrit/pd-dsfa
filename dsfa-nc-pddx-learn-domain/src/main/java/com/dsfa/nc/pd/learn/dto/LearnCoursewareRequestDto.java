package com.dsfa.nc.pd.learn.dto;

import com.dsfa.nc.pd.learn.serializer.TimePointDeserializer;
import com.dsfa.nc.pd.learn.serializer.TimePointSerializer;
import com.dsfa.nc.pd.learn.types.TimePoint;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

/**
 * @ClassName LearnCoursewareRequestDto
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/29
 **/
public class LearnCoursewareRequestDto {
    private String coursewareId;

    private TimePoint newTimePoint;

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
