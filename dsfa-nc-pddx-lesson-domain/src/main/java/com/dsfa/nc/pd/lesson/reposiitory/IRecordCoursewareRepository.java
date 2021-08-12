package com.dsfa.nc.pd.lesson.reposiitory;

import com.dsfa.nc.pd.domain.Repository;
import com.dsfa.nc.pd.lesson.entity.courseware.UserCoursewareRecordItem;
import com.dsfa.nc.pd.types.PK;

/**
 * @ClassName RecordCoursewareRepository
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/29
 **/
public interface IRecordCoursewareRepository extends Repository<UserCoursewareRecordItem,PK> {
    @Override
    public void attach(UserCoursewareRecordItem aggregate);

    @Override
    public void detach(UserCoursewareRecordItem aggregate);

    @Override
    public UserCoursewareRecordItem find(PK pk);

    @Override
    public void remove(UserCoursewareRecordItem aggregate);

    @Override
    public void save(UserCoursewareRecordItem aggregate);
}
