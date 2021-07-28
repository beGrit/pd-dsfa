package com.dsfa.nc.web.pd.entity.appraise;

import com.dsfa.nc.web.pd.types.AppraiseItemType;
import lombok.Data;

/**
 * @ClassName CourseAppraiseItem 某用户对课程的评价
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/27
 **/
@Data
public class CourseAppraiseItem {
    private String id;

    private String courseId;

    private String accountId;

    private AppraiseItemType type;
}
