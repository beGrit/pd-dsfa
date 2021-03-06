package com.dsfa.nc.web.pd.course.domain.lesson.repository;

import com.dsfa.nc.web.pd.course.domain.lesson.entity.courseware.Courseware;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @ClassName CourseRepository
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/27
 **/
public interface ICoursewareRepository {
    Courseware findByID(@NotNull String id);

    List<Courseware> findByCourseID(@NotNull String courseId);

    boolean save(Courseware courseware);

    boolean batchSave(List<Courseware> coursewareList);
}
