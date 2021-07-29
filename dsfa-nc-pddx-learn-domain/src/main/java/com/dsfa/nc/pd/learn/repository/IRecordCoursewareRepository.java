package com.dsfa.nc.pd.learn.repository;

import com.dsfa.nc.pd.domain.Repository;
import com.dsfa.nc.pd.learn.entity.RecordCourseware;
import com.dsfa.nc.pd.types.PK;

/**
 * @ClassName RecordCoursewareRepository
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/29
 **/
public interface IRecordCoursewareRepository extends Repository<RecordCourseware,PK> {
    @Override
    public void attach(RecordCourseware aggregate);

    @Override
    public void detach(RecordCourseware aggregate);

    @Override
    public RecordCourseware find(PK pk);

    @Override
    public void remove(RecordCourseware aggregate);

    @Override
    public void save(RecordCourseware aggregate);
}
