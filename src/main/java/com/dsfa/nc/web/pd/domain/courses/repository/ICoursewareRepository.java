package com.dsfa.nc.web.pd.domain.courses.repository;

import com.dsfa.nc.web.pd.domain.courses.entity.courseware.Courseware;

import java.util.List;

/**
 * @ClassName CourseRepository
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/27
 **/
public interface ICoursewareRepository {
    Courseware findByID(String id);

    List<Courseware> findByCourseID(String courseId);

    boolean save(Courseware courseware);

    boolean batchSave(List<Courseware> coursewareList);
}
