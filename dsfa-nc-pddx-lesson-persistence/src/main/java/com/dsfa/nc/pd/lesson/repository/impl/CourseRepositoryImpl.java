package com.dsfa.nc.pd.lesson.repository.impl;

import com.dsfa.nc.pd.lesson.aggregate.Course;
import com.dsfa.nc.pd.lesson.entity.course.CourseInfo;
import com.dsfa.nc.pd.lesson.entity.courseware.Courseware;
import com.dsfa.nc.pd.lesson.entity.teacher.TeacherInfo;
import com.dsfa.nc.pd.lesson.reposiitory.ICourseInfoRepository;
import com.dsfa.nc.pd.lesson.reposiitory.ICourseRepository;
import com.dsfa.nc.pd.lesson.reposiitory.ICoursewareRepository;
import com.dsfa.nc.pd.lesson.reposiitory.ITeacherInfoRepository;
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
public class CourseRepositoryImpl implements ICourseRepository {
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
