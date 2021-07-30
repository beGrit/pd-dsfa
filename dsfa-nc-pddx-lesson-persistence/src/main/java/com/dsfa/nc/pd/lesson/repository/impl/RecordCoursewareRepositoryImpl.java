package com.dsfa.nc.pd.lesson.repository.impl;

import com.dsfa.nc.courses.api.record.courseware.pojo.po.NcRecordCourseware;
import com.dsfa.nc.pd.lesson.converter.RecordCoursewareConverter;
import com.dsfa.nc.pd.lesson.entity.courseware.RecordCourseware;
import com.dsfa.nc.pd.lesson.reposiitory.IRecordCoursewareRepository;
import com.dsfa.nc.pd.types.PK;
import com.dsfa.platform.sdk.common.kit.StrKit;
import org.springframework.stereotype.Repository;

/**
 * @ClassName RecordCoursewareRepositoryImpl
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/29
 **/
@Repository
public class RecordCoursewareRepositoryImpl implements IRecordCoursewareRepository {
    private final NcRecordCourseware recordCoursewareDao = NcRecordCourseware.dao;
    @Override
    public void attach(RecordCourseware aggregate) {

    }

    @Override
    public void detach(RecordCourseware aggregate) {

    }

    @Override
    public RecordCourseware find(PK pk) {
        RecordCourseware res = null;
        String id = pk.getVal();
        NcRecordCourseware recordCoursewareDO = recordCoursewareDao.findById(id);
        Integer delFlag = recordCoursewareDO.getDsDeleted();
        if (delFlag == 0) { // 没有被删除
            res = RecordCoursewareConverter.toEntity(recordCoursewareDO);
        }
        return res;
    }

    @Override
    public void remove(RecordCourseware aggregate) {

    }

    @Override
    public void save(RecordCourseware entity) {
        NcRecordCourseware rcDO = RecordCoursewareConverter.toDO(entity);
        if (StrKit.isNotBlank(rcDO.getNcRecordCoursewareId())) {
            rcDO.update();
        }
    }
}
