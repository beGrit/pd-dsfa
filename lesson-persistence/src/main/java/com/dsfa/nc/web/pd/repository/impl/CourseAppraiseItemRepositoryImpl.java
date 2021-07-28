package com.dsfa.nc.web.pd.repository.impl;

import com.dsfa.nc.web.pd.Do.CourseAppraiseItemDO;
import com.dsfa.nc.web.pd.converter.CourseAppraiseBasicConverter;
import com.dsfa.nc.web.pd.entity.appraise.CourseAppraiseItem;
import com.dsfa.nc.web.pd.reposiitory.ICourseAppraiseItemRepository;
import com.dsfa.platform.sdk.common.kit.StrKit;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName ICourseAppraiseRepositoryImpl
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/28
 **/
@Repository
public class CourseAppraiseItemRepositoryImpl implements ICourseAppraiseItemRepository {
    private final CourseAppraiseItemDO appraiseItemDao = new CourseAppraiseItemDO().dao();
    private final String TABLE_NAME = "csml_lsf_appraise";

    @Override
    public CourseAppraiseItem findByCourseIdAndAccountId(String courseId, String accountId) {
        List<CourseAppraiseItemDO> courseAppraiseItemDOList = appraiseItemDao.find("select * from " + TABLE_NAME);
        for (CourseAppraiseItemDO courseAppraiseItemDO : courseAppraiseItemDOList) {
            String delFlag = courseAppraiseItemDO.getDeleted();
            if (StrKit.equals(delFlag, "0")) {
                String str1 = courseAppraiseItemDO.getCourseId();
                String str2 = courseAppraiseItemDO.getAccountId();
                if (StrKit.equals(courseId, str1) && StrKit.equals(accountId, str2)) {
                    // 做转化 do -> entity
                    CourseAppraiseItem res = CourseAppraiseBasicConverter.INSTANCE.toEntity(courseAppraiseItemDO);
                    return res;
                }
            }
        }
        return null;
    }

    @Override
    public List<CourseAppraiseItem> findListByCourseId(String courseId) {
        List<CourseAppraiseItem> res = null;
        List<CourseAppraiseItemDO> list = appraiseItemDao.find("select * from " + TABLE_NAME);
        for (CourseAppraiseItemDO courseAppraiseItemDO : list) {
            String delFlag = courseAppraiseItemDO.getDeleted();
            if (StrKit.equals(delFlag, "0")) {
                if (res == null) {
                    res = new LinkedList<>();
                }
                String str1 = courseAppraiseItemDO.getCourseId();
                if (StrKit.equals(courseId, str1)) {
                    // 做转化 do -> entity
                    CourseAppraiseItem item = CourseAppraiseBasicConverter.INSTANCE.toEntity(courseAppraiseItemDO);
                    res.add(item);
                }
            }
        }
        return res;
    }

    public int save(CourseAppraiseItem item) {
        boolean res;
        if (item.getId() == null) {
            item.setId(StrKit.uuid());
            CourseAppraiseItemDO courseAppraiseItemDO = CourseAppraiseBasicConverter.INSTANCE.toDO(item);
            res = courseAppraiseItemDO.save();
        } else {
            CourseAppraiseItemDO courseAppraiseItemDO = CourseAppraiseBasicConverter.INSTANCE.toDO(item);
            res = courseAppraiseItemDO.update();
        }
        return res ? 1 : 0;
    }
}
