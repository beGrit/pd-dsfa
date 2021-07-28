package com.dsfa.nc.web.pd.course.domain.lesson.repository;

import com.dsfa.nc.web.pd.course.domain.lesson.aggregate.CourseAppraise;

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
