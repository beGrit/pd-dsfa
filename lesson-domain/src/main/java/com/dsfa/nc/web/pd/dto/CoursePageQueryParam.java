package com.dsfa.nc.web.pd.dto;

import lombok.Data;

import java.util.List;

/**
 * @ClassName CourseQueryParam
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/28
 **/
@Data
public class CoursePageQueryParam {
    private Integer pageIndex;
    private Integer pageSize;
    private List<String> levelOneTagList;
    private List<String> levelTwoTagList;
}
