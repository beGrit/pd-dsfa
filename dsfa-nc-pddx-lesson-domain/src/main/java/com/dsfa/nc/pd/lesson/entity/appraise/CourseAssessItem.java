package com.dsfa.nc.pd.lesson.entity.appraise;

import com.dsfa.nc.pd.domain.Entity;
import com.dsfa.nc.pd.types.AssessType;
import com.dsfa.nc.pd.types.PK;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName CourseAppraiseItem 某用户对课程的评价 (one-to-one)
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/27
 **/
@Data
public class CourseAssessItem implements Entity<PK>, Serializable {
    private PK id;

    private String courseId;

    private String accountId;

    private AssessType type;

    public void changeType(AssessType newAssessType) {
        this.type = newAssessType;
    }
}
