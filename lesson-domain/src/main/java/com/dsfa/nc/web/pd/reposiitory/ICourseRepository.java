package com.dsfa.nc.web.pd.reposiitory;

import com.dsfa.nc.web.pd.aggregate.Course;

import javax.validation.constraints.NotNull;

/**
 * @ClassName ICourseRepository
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/27
 **/
public interface ICourseRepository {
    Course findByID(@NotNull String id);

    boolean save(Course course);
}
