package com.dsfa.nc.pd.lesson.repository.impl;

import com.dsfa.nc.courses.api.record.course.pojo.po.NcRecordCourse;
import com.dsfa.nc.courses.api.record.courseware.pojo.po.NcRecordCourseware;
import com.dsfa.nc.pd.lesson.aggregate.UserCourseRecordItem;
import com.dsfa.nc.pd.lesson.converter.UserCourseRecordConverter;
import com.dsfa.nc.pd.lesson.reposiitory.IUserCourseRecordRepository;
import com.dsfa.nc.pd.types.PK;
import com.dsfa.platform.sdk.common.kit.StrKit;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName UserCourseRecordRepositoryImpl
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/30
 **/
@Repository
@CacheConfig(cacheNames = "dsfa:nc:UserCourseRecordItem")
public class UserCourseRecordItemRepositoryImpl implements IUserCourseRecordRepository {

    private static final NcRecordCourse recordCourseDao = NcRecordCourse.dao;
    private static final NcRecordCourseware recordCoursewareDao = NcRecordCourseware.dao;

    @Override
    public void attach(UserCourseRecordItem aggregate) {

    }

    @Override
    public void detach(UserCourseRecordItem aggregate) {

    }

    @Override
    public UserCourseRecordItem find(PK pk) {
        return null;
    }

    @Override
    public void remove(UserCourseRecordItem aggregate) {

    }

    @Override
    public void save(UserCourseRecordItem aggregate) {

    }

    @Override
    @Cacheable(key = "'uc'.#courseId.#userId")
    public UserCourseRecordItem find(PK courseId, PK userId) {
        // 检索课程记录
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

        // 检索课件记录
        List<NcRecordCourseware> ncRecordCoursewareList = new LinkedList<>();
        List<NcRecordCourseware> temp = recordCoursewareDao.find("select * from nc_record_courseware where ds_deleted = '0'");
        for (NcRecordCourseware item : temp) {
            String addtionId = item.getAddtionId();
            if (StrKit.equals(addtionId, recordCourseDO.getRelationId())) {
                ncRecordCoursewareList.add(item);
            }
        }

        UserCourseRecordItem userCourseRecordItem = UserCourseRecordConverter.toEntity(recordCourseDO, ncRecordCoursewareList);
        return userCourseRecordItem;
    }
}
