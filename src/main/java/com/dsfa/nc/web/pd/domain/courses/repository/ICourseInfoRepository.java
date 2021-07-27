package com.dsfa.nc.web.pd.domain.courses.repository;

import com.dsfa.nc.web.pd.domain.courses.entity.course.CourseInfo;

/**
 * @InterfaceName ICourseInfoRepository
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/27
 **/
public interface ICourseInfoRepository {
    CourseInfo findById(String courseId);

    boolean save(CourseInfo courseInfo);
}
