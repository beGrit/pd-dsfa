package com.dsfa.nc.web.pd.course.domain.lesson.repository;

import com.dsfa.nc.web.pd.course.domain.lesson.entity.course.CourseInfo;

import javax.validation.constraints.NotNull;

/**
 * @InterfaceName ICourseInfoRepository
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/27
 **/
public interface ICourseInfoRepository {
    CourseInfo findById(@NotNull String courseId);

    boolean save(CourseInfo courseInfo);
}
