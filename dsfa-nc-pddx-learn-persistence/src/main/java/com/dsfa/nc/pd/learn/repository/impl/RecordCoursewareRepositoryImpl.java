package com.dsfa.nc.pd.learn.repository.impl;

import com.dsfa.nc.pd.learn.Do.RecordCoursewareDO;
import com.dsfa.nc.pd.learn.converter.RecordCoursewareConverter;
import com.dsfa.nc.pd.learn.entity.RecordCourseware;
import com.dsfa.nc.pd.learn.repository.IRecordCoursewareRepository;
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
    private static final RecordCoursewareDO recordCoursewareDao = new RecordCoursewareDO().dao();
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
        RecordCoursewareDO recordCoursewareDO = recordCoursewareDao.findById(id);
        String delFlag = recordCoursewareDO.getDeleted();
        if (StrKit.equals(delFlag, "0")) { // 没有被删除
            res = RecordCoursewareConverter.INSTANCE.toEntity(recordCoursewareDO);
        }
        return res;
    }

    @Override
    public void remove(RecordCourseware aggregate) {

    }

    @Override
    public void save(RecordCourseware aggregate) {

    }
}
