package com.dsfa.nc.pd.lesson.reposiitory;

import com.dsfa.nc.pd.domain.Repository;
import com.dsfa.nc.pd.lesson.aggregate.UserCourseRecordItem;
import com.dsfa.nc.pd.types.PK;

/**
 * @InterfaceName IUserCourseRecord
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/30
 **/
public interface IUserCourseRecordRepository extends Repository<UserCourseRecordItem, PK> {
    UserCourseRecordItem find(PK courseId, PK userId);
}
