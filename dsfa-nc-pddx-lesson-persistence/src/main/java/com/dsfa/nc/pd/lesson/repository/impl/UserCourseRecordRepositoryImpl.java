package com.dsfa.nc.pd.lesson.repository.impl;

import com.dsfa.nc.courses.api.record.course.pojo.po.NcRecordCourse;
import com.dsfa.nc.courses.api.record.courseware.pojo.po.NcRecordCourseware;
import com.dsfa.nc.pd.lesson.Do.CourseInfoSubDO;
import com.dsfa.nc.pd.lesson.aggregate.UserCourseRecord;
import com.dsfa.nc.pd.lesson.converter.UserCourseRecordConverter;
import com.dsfa.nc.pd.lesson.reposiitory.IUserCourseRecordRepository;
import com.dsfa.nc.pd.types.PK;
import com.dsfa.platform.sdk.common.kit.StrKit;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @ClassName UserCourseRecordRepositoryImpl
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/30
 **/
@Repository
public class UserCourseRecordRepositoryImpl implements IUserCourseRecordRepository {

    private static final NcRecordCourse recordCourseDao = NcRecordCourse.dao;
    private static final NcRecordCourseware recordCoursewareDao = NcRecordCourseware.dao;
    private static final CourseInfoSubDO relationDao = new CourseInfoSubDO().dao();

    @Override
    public void attach(UserCourseRecord aggregate) {

    }

    @Override
    public void detach(UserCourseRecord aggregate) {

    }

    @Override
    public UserCourseRecord find(PK pk) {
        return null;
    }

    @Override
    public void remove(UserCourseRecord aggregate) {

    }

    @Override
    public void save(UserCourseRecord aggregate) {

    }

    @Override
    public UserCourseRecord findByCourseIdAndUserId(PK courseId, PK userId) {
        NcRecordCourse recordCourseDO = null;
        List<NcRecordCourse> ncRecordCourseList = recordCourseDao.find("select * from nc_record_course");
        for (NcRecordCourse item : ncRecordCourseList) {
            Integer delFlag = Integer.parseInt(item.get("ds_deleted"));
            String userId2 = item.getDsfaOuaUserId();
            if (delFlag == 0) {
                if (StrKit.equals(item.getRelationId(), courseId.getVal()) && StrKit.equals(userId.getVal(), userId2)) {
                    recordCourseDO = item;
                }
            }
        }
        if (recordCourseDO == null) {
            return null;
        }
        String courseId1 = recordCourseDO.getRelationId();
        Set<String> pkSet1 = new HashSet<>();
        List<CourseInfoSubDO> relationList = relationDao.find("select * from nc_courses_info_sub");
        for (CourseInfoSubDO relation: relationList) {
            boolean b1 = StrKit.equals(relation.getDsDeleted(), "0");
            if (b1) {
                String courseId2 = relation.getNcCoursesInfoId();
                if (StrKit.equals(courseId1, courseId2)) {
                    pkSet1.add(relation.getRelationId());
                }
            } else {
                continue;
            }
        }

        List<NcRecordCourseware> list = new LinkedList<>();
        List<NcRecordCourseware> recordCoursewareList = recordCoursewareDao.find("select * from nc_record_courseware");
        for (NcRecordCourseware item : recordCoursewareList) {
            String delFlag = item.get("ds_deleted");
            if (StrKit.equals(delFlag,"0")) {
                String coursewareId = item.getRelationId();
                String courseId2 = item.getAddtionId();
                String userId2 = item.getDsfaOuaUserId();
                if (pkSet1.contains(coursewareId) && StrKit.equals(courseId1, courseId2) && StrKit.equals(userId.getVal(), userId2)) {
                    list.add(item);
                }
            }
        }

        UserCourseRecord userCourseRecord = UserCourseRecordConverter.toEntity(recordCourseDO, list);
        return userCourseRecord;
    }
}
