package com.dsfa.nc.web.pd.domain.courses.repository.impl;

import com.dsfa.nc.web.pd.domain.courses.Do.CourseInfoDO;
import com.dsfa.nc.web.pd.domain.courses.converter.CourseInfoConverter;
import com.dsfa.nc.web.pd.domain.courses.entity.course.CourseInfo;
import com.dsfa.nc.web.pd.domain.courses.repository.ICourseInfoRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName ICourseInfoRepositoryImpl
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/27
 **/
@Repository
public class ICourseInfoRepositoryImpl implements ICourseInfoRepository {
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
