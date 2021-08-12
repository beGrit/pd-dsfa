package com.dsfa.nc.pd.lesson.dto;

import com.dsfa.nc.pd.serializer.PKDeserializer;
import com.dsfa.nc.pd.serializer.TimePointDeserializer;
import com.dsfa.nc.pd.types.PK;
import com.dsfa.nc.pd.types.TimePoint;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

@Data
public class RecordCoursewareCommand { // 记录 学习课件 指令
    /**
     * 课程id
     */
    private PK courseId;

    /**
     * 课件的id
     */
    @JsonDeserialize(using = PKDeserializer.class)
    private PK coursewareId;

    /**
     * 更新时间点
     */
    @JsonDeserialize(using = TimePointDeserializer.class)
    private TimePoint newWatchPoint;
}
