package com.dsfa.nc.web.pd.reposiitory;

import com.dsfa.nc.web.pd.aggregate.CourseAppraise;

/**
 * @ClassName ICourseAppraiseRepository
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/28
 **/
public interface ICourseAppraiseRepository {
    /**
     * 根据课程的id,获取到课程的评价
     * @param courseId
     * @return
     */
    CourseAppraise findByCourseId(String courseId);
}
