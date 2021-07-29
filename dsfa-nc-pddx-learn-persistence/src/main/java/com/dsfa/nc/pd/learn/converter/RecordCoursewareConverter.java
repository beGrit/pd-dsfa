package com.dsfa.nc.pd.learn.converter;

import com.dsfa.nc.pd.learn.Do.RecordCoursewareDO;
import com.dsfa.nc.pd.learn.entity.RecordCourseware;
import com.dsfa.nc.pd.learn.types.TimePoint;
import com.dsfa.nc.pd.types.PK;
import org.springframework.beans.BeanUtils;

/**
 * @ClassName RecordCourseConverter
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/29
 **/

public class RecordCoursewareConverter {
    public static final RecordCoursewareConverter INSTANCE = new RecordCoursewareConverter();

    /*   @Mappings({
               @Mapping(target = "id", expression = "java( new com.dsfa.nc.pd.types.PK(NcRecordCourseId) )"),
               @Mapping(target = "coursewareId", expression = "java( new com.dsfa.nc.pd.types.PK(RelationId) )"),
               @Mapping(target = "userId", expression = "java( new com.dsfa.nc.pd.types.PK(DsfaOuaUserId) )"),
               @Mapping(target = "sumWatchTime", dateFormat = "")
       })
    */
    public static RecordCourseware toEntity(RecordCoursewareDO recordCoursewareDO) {
        RecordCourseware res = new RecordCourseware();

        BeanUtils.copyProperties(recordCoursewareDO, res);
        res.setId( new PK(recordCoursewareDO.getNcRecordCoursewareId()) );
        res.setCoursewareId( new PK(recordCoursewareDO.getRelationId()) );
        res.setUserId( new PK(recordCoursewareDO.getDsfaOuaUserId()) );
        res.setLastWatchPoint( new TimePoint(recordCoursewareDO.getLastWatchPoint()) );
        res.setSumDurationLong( Long.parseLong(recordCoursewareDO.getSumDurationLong()) );

        return res;
    }
}
