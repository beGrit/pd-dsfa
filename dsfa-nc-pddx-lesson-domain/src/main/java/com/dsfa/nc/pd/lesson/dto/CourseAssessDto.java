package com.dsfa.nc.pd.lesson.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName CourseAppraiseDto 课程下的评价(DTO)
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/28
 **/
@Data
public class CourseAssessDto {
    private String courseId;

    private Double score;

    private int numberOfPeople;

    public Double getScore() {
        BigDecimal b = new BigDecimal(this.score);
        return b.setScale(1, BigDecimal.ROUND_DOWN).doubleValue();
    }
}
