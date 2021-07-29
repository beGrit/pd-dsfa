package com.dsfa.nc.pd.lesson.repository.impl;

import com.dsfa.nc.pd.lesson.Do.CourseInfoDO;
import com.dsfa.nc.pd.lesson.entity.course.CourseInfo;
import com.dsfa.nc.pd.lesson.converter.CourseInfoConverter;
import com.dsfa.nc.pd.lesson.reposiitory.ICourseInfoRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName ICourseInfoRepositoryImpl
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/27
 **/
@Repository
public class CourseInfoRepositoryImpl implements ICourseInfoRepository {
    private static final CourseInfoDO dao = new CourseInfoDO().dao();

    @Override
    public CourseInfo findById(String courseId) {
        CourseInfoDO courseInfoDO = dao.findById(courseId);
        CourseInfo courseInfo = CourseInfoConverter.INSTANCE.toEntity(courseInfoDO);
        return courseInfo;
    }

    @Override
    public boolean save(CourseInfo courseInfo) {
        return false;
    }
}
