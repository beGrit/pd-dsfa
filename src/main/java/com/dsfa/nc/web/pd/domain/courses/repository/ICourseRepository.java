package com.dsfa.nc.web.pd.domain.courses.repository;

import com.dsfa.nc.web.pd.domain.courses.aggregate.Course;

/**
 * @ClassName ICourseRepository
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/27
 **/
public interface ICourseRepository {
    Course findByID(String id);

    boolean save(Course course);
}
