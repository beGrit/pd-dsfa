package com.dsfa.nc.web.pd.course.domain.teacher.repository;

import com.dsfa.nc.web.pd.course.domain.teacher.entity.TeacherInfo;

import java.util.List;

/**
 * @ClassName ITeacherRepository
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/27
 **/
public interface ITeacherInfoRepository {
    TeacherInfo findById(String teacherId);

    List<TeacherInfo> findAllByCourseId(String courseId);

    TeacherInfo findShowedByCourseId(String courseId);

    boolean save(TeacherInfo teacherInfo);

    boolean batchSave(List<TeacherInfo> teacherInfoList);
}
