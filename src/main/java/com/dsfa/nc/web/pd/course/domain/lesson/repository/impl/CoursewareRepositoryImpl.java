package com.dsfa.nc.web.pd.course.domain.lesson.repository.impl;

import com.dsfa.nc.web.pd.course.persistence.lesson.CourseInfoSubDO;
import com.dsfa.nc.web.pd.course.persistence.lesson.CoursewareDO;
import com.dsfa.nc.web.pd.course.domain.lesson.converter.CoursewareConverter;
import com.dsfa.nc.web.pd.course.domain.lesson.entity.courseware.Courseware;
import com.dsfa.nc.web.pd.course.domain.lesson.repository.ICoursewareRepository;
import com.dsfa.platform.sdk.common.kit.StrKit;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * @ClassName CoursewareRepository
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/27
 **/
@Repository
public class CoursewareRepositoryImpl implements ICoursewareRepository {
    private static final CourseInfoSubDO courseInfoSubDO = new CourseInfoSubDO().dao();
    private static final CoursewareDO coursewareDO = new CoursewareDO().dao();

    public Courseware findByID(String id) {
        CoursewareDO coursewareDO = CoursewareRepositoryImpl.coursewareDO.findById(id);
        Courseware courseware;
        courseware = CoursewareConverter.INSTANCE.toEntity(coursewareDO);
        return courseware;
    }

    @Override
    public List<Courseware> findByCourseID(String coursesInfoId) {
        List<Courseware> res = new LinkedList<>();
        List<CourseInfoSubDO> courseInfoSubDOList = courseInfoSubDO.find("select * from nc_courses_info_sub");

        Set<String> set = new HashSet<>();

        // 搜索关系(课程-课件)表
        for (CourseInfoSubDO courseInfoSubDO : courseInfoSubDOList) {
            String delTag = courseInfoSubDO.getDeleted();
            if (StrKit.equals(delTag, "0")) {
                String coursesInfoId2 = courseInfoSubDO.getNcCoursesInfoId();
                if (StrKit.equals(coursesInfoId, coursesInfoId2)) {
                    String coursewareId = courseInfoSubDO.getRelationId();
                    set.add(coursewareId);
                }
            }
        }

        // 搜索课件表
        List<CoursewareDO> coursewareDOList = coursewareDO.find("select * from nc_courses_courseware");
        for (CoursewareDO coursewareDO : coursewareDOList) {
            String delTag = coursewareDO.getDeleted();
            if (StrKit.equals(delTag, "0")) {
                String coursewareId = coursewareDO.getNcCoursesCoursewareId();
                if (set.contains(coursewareId)) {
                    Courseware courseware = CoursewareConverter.INSTANCE.toEntity(coursewareDO);
                    res.add(courseware);
                }
            }
        }

        return res;
    }

    @Override
    public boolean save(Courseware courseware) {
        return false;
    }

    @Override
    public boolean batchSave(List<Courseware> coursewareList) {
        return false;
    }
}
