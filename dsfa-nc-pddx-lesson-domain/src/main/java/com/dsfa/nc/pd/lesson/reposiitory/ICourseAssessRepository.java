package com.dsfa.nc.pd.lesson.reposiitory;

import com.dsfa.nc.pd.lesson.aggregate.CourseAssess;

/**
 * @ClassName ICourseAppraiseRepository
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/28
 **/
public interface ICourseAssessRepository {
    /**
     * 根据课程的id,获取到课程的评价
     * @param courseId
     * @return
     */
    CourseAssess findByCourseId(String courseId);
}
