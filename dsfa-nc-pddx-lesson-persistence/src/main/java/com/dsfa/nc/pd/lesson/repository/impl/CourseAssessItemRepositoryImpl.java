package com.dsfa.nc.pd.lesson.repository.impl;

import com.dsfa.nc.pd.lesson.Do.CourseAssessItemDO;
import com.dsfa.nc.pd.lesson.converter.CourseAssessItemConverter;
import com.dsfa.nc.pd.lesson.entity.appraise.CourseAssessItem;
import com.dsfa.nc.pd.lesson.reposiitory.ICourseAssessItemRepository;
import com.dsfa.nc.pd.types.PK;
import com.dsfa.platform.sdk.common.kit.StrKit;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName ICourseAppraiseRepositoryImpl
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/28
 **/
@Repository
public class CourseAssessItemRepositoryImpl implements ICourseAssessItemRepository {
    private final CourseAssessItemDO assessItemDao = new CourseAssessItemDO().dao();
    private final String TABLE_NAME = "csml_lsf_assess";

    @Override
    public CourseAssessItem findByCourseIdAndAccountId(String courseId, String accountId) {
        List<CourseAssessItemDO> courseAssessItemDOList = assessItemDao.find("select * from " + TABLE_NAME);
        for (CourseAssessItemDO courseAssessItemDO : courseAssessItemDOList) {
            String delFlag = courseAssessItemDO.getDeleted();
            if (StrKit.equals(delFlag, "0")) {
                String str1 = courseAssessItemDO.getCourseId();
                String str2 = courseAssessItemDO.getAccountId();
                if (StrKit.equals(courseId, str1) && StrKit.equals(accountId, str2)) {
                    // 做转化 do -> entity
                    CourseAssessItem res = CourseAssessItemConverter.INSTANCE.toEntity(courseAssessItemDO);
                    return res;
                }
            }
        }
        return null;
    }

    @Override
    public List<CourseAssessItem> findListByCourseId(String courseId) {
        List<CourseAssessItem> res = null;
        List<CourseAssessItemDO> list = assessItemDao.find("select * from " + TABLE_NAME);
        for (CourseAssessItemDO courseAssessItemDO : list) {
            String delFlag = courseAssessItemDO.getDeleted();
            if (StrKit.equals(delFlag, "0")) {
                if (res == null) {
                    res = new LinkedList<>();
                }
                String str1 = courseAssessItemDO.getCourseId();
                if (StrKit.equals(courseId, str1)) {
                    // 做转化 do -> entity
                    CourseAssessItem item = CourseAssessItemConverter.INSTANCE.toEntity(courseAssessItemDO);
                    res.add(item);
                }
            }
        }
        return res;
    }

    public int save(CourseAssessItem item) {
        boolean res;
        if (item.getId() == null) {
            item.setId( new PK(StrKit.uuid()) );
            CourseAssessItemDO courseAssessItemDO = CourseAssessItemConverter.INSTANCE.toDO(item);
            courseAssessItemDO.setDsCreateTime(new Date());
            courseAssessItemDO.setDsUpdateTime(new Date());
            res = courseAssessItemDO.save();
        } else {
            CourseAssessItemDO courseAssessItemDO = CourseAssessItemConverter.INSTANCE.toDO(item);
            courseAssessItemDO.setDsUpdateTime(new Date());
            res = courseAssessItemDO.update();
        }
        return res ? 1 : 0;
    }
}
