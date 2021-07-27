package com.dsfa.nc.web.pd.domain.courses.repository.impl;

import com.dsfa.nc.web.pd.domain.courses.aggregate.Course;
import com.dsfa.nc.web.pd.domain.courses.entity.course.CourseInfo;
import com.dsfa.nc.web.pd.domain.courses.entity.courseware.Courseware;
import com.dsfa.nc.web.pd.domain.courses.repository.ICourseInfoRepository;
import com.dsfa.nc.web.pd.domain.courses.repository.ICourseRepository;
import com.dsfa.nc.web.pd.domain.courses.repository.ICoursewareRepository;
import com.dsfa.nc.web.pd.domain.teacher.repository.ITeacherInfoRepository;
import com.dsfa.nc.web.pd.domain.teacher.entity.TeacherInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName ICourseRepositoryImpl
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/27
 **/
@Repository
public class ICourseRepositoryImpl implements ICourseRepository {
    @Autowired
    ICourseInfoRepository courseInfoRepository;

    @Autowired
    ICoursewareRepository coursewareRepository;

    @Autowired
    ITeacherInfoRepository teacherRepository;

    @Override
    public Course findByID(String courseId) {
        List<Courseware> coursewareList = coursewareRepository.findByCourseID(courseId);
        CourseInfo courseInfo = courseInfoRepository.findById(courseId);
        List<TeacherInfo> teacherInfoList = teacherRepository.findAllByCourseId(courseId);
        TeacherInfo showedTeacher = teacherRepository.findShowedByCourseId(courseId);

        Course res = new Course(courseInfo, showedTeacher, coursewareList, teacherInfoList);
        return res;
    }

    @Override
    @Transactional
    public boolean save(Course course) {
        CourseInfo courseInfo = course.getCourseInfo();
        List<Courseware> coursewareList = course.getCoursewareList();
        List<TeacherInfo> teacherInfoList = course.getTeacherInfoList();

        boolean b1 = courseInfoRepository.save(courseInfo);
        boolean b2 = coursewareRepository.batchSave(coursewareList);
        boolean b3 = teacherRepository.batchSave(teacherInfoList);

        if (b1 && b2 && b3) {
            return true;
        } else {
            return false;
        }
    }
}
