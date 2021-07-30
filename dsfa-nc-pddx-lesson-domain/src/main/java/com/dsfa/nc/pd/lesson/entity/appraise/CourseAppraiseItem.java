package com.dsfa.nc.pd.lesson.entity.appraise;

import com.dsfa.nc.pd.domain.Entity;
import com.dsfa.nc.pd.lesson.types.AppraiseItemType;
import com.dsfa.nc.pd.types.PK;
import lombok.Data;

/**
 * @ClassName CourseAppraiseItem 某用户对课程的评价 (one-to-one)
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/27
 **/
@Data
public class CourseAppraiseItem implements Entity<PK> {
    private PK id;

    private String courseId;

    private String accountId;

    private AppraiseItemType type;

    public void changeType(AppraiseItemType newAppraiseType) {
        this.type = newAppraiseType;
    }
}
