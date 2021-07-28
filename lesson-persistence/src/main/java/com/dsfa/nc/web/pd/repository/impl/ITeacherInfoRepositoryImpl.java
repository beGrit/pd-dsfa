package com.dsfa.nc.web.pd.repository.impl;

import com.dsfa.nc.web.pd.Do.CourseInfoDO;
import com.dsfa.nc.web.pd.Do.TeacherDO;
import com.dsfa.nc.web.pd.converter.TeacherConverter;
import com.dsfa.nc.web.pd.entity.teacher.TeacherInfo;
import com.dsfa.nc.web.pd.reposiitory.ITeacherInfoRepository;
import com.dsfa.platform.sdk.common.kit.StrKit;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * @ClassName ITeacherRepositoryImpl
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/27
 **/
@Repository
public class ITeacherInfoRepositoryImpl implements ITeacherInfoRepository {

    private static final CourseInfoDO courseInfoDao = new CourseInfoDO().dao();
    private static final TeacherDO teacherDao = new TeacherDO().dao();

    @Override
    public TeacherInfo findById(String teacherId1) {
        TeacherInfo res = null;
        List<TeacherDO> teacherDOList = teacherDao.find("select * from nc_teacher");
        for (TeacherDO teacherDO : teacherDOList) {
            String delTag = teacherDO.getDeleted();
            if (StrKit.equals(delTag, "0")) {
                String teacherId2 = teacherDO.getNcTeacherId();
                if (StrKit.equals(teacherId1, teacherId2)) {
                    res = TeacherConverter.INSTANCE.toEntity(teacherDO);
                    break;
                }
            }
        }
        return res;
    }

    @Override
    public List<TeacherInfo> findAllByCourseId(String courseId) {
        List<TeacherInfo> res = new LinkedList<>();

        CourseInfoDO courseInfoDO = courseInfoDao.findById(courseId);
        Set<String> set1 = new HashSet<>();
        if (courseInfoDO.getTeacherValue() != null) {
            String[] strs = courseInfoDO.getTeacherValue().split("^");
            set1.addAll(Arrays.asList(strs));
        }


        List<TeacherDO> teacherDOList = teacherDao.find("select * from nc_teacher");
        for (TeacherDO teacherDO : teacherDOList) {
            String delTag = teacherDO.getDeleted();
            if (StrKit.equals(delTag, "0")) {
                String teacherId = teacherDO.getNcTeacherId();
                if (set1.contains(teacherId)) {
                    TeacherInfo teacherInfo = TeacherConverter.INSTANCE.toEntity(teacherDO);
                    res.add(teacherInfo);
                }
            }
        }

        return res;
    }

    @Override
    public TeacherInfo findShowedByCourseId(String courseId) {
        TeacherInfo res = null;
        CourseInfoDO courseInfoDO = ITeacherInfoRepositoryImpl.courseInfoDao.findById(courseId);
        String teacherId = courseInfoDO.getTeacherShowValue();
        res = this.findById(teacherId);
        return res;
    }

    @Override
    public boolean save(TeacherInfo teacherInfo) {
        return false;
    }

    @Override
    public boolean batchSave(List<TeacherInfo> teacherInfoList) {
        return false;
    }
}
