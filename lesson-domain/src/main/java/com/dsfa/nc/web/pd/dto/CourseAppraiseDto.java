package com.dsfa.nc.web.pd.dto;

import lombok.Data;

import java.util.List;

/**
 * @ClassName CourseAppraiseDto 课程下的评价(DTO)
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/28
 **/
@Data
public class CourseAppraiseDto {
    private String courseId;

    private Double score;

    private List<CourseAppraiseItemDto> items;
}
