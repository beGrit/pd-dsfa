package com.dsfa.nc.pd.learn.converter;

import com.dsfa.nc.courses.api.record.courseware.pojo.po.NcRecordCourseware;
import com.dsfa.nc.pd.learn.entity.RecordCourseware;
import com.dsfa.nc.pd.learn.types.Rate;
import com.dsfa.nc.pd.learn.types.TimePoint;
import com.dsfa.nc.pd.types.PK;
import com.dsfa.platform.sdk.common.kit.StrKit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName RecordCourseConverter
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/29
 **/

public class RecordCoursewareConverter { // 单例模式
    public static final RecordCoursewareConverter INSTANCE = new RecordCoursewareConverter();

    private RecordCoursewareConverter() {

    }

    /*   @Mappings({
               @Mapping(target = "id", expression = "java( new com.dsfa.nc.pd.types.PK(NcRecordCourseId) )"),
               @Mapping(target = "coursewareId", expression = "java( new com.dsfa.nc.pd.types.PK(RelationId) )"),
               @Mapping(target = "userId", expression = "java( new com.dsfa.nc.pd.types.PK(DsfaOuaUserId) )"),
               @Mapping(target = "sumWatchTime", dateFormat = "")
       })
    */
    public static RecordCourseware toEntity(NcRecordCourseware rcDO) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        RecordCourseware res = null;
        try {
            res = RecordCourseware.builder()
                    .id(new PK(rcDO.getNcRecordCoursewareId()))
                    .coursewareId(new PK(rcDO.getRelationId()))
                    .userId(new PK(rcDO.getDsfaOuaUserId()))
                    .sumWatchTime(rcDO.getSumWatchTime())
                    .lastWatchPoint(new TimePoint(rcDO.getLastWatchPoint()))
                    .sumDurationLong(rcDO.getSumDurationLong())
                    .isFinished(StrKit.equals(rcDO.getIsFinishedValue(), "1"))
                    .finishedRate(new Rate(Double.parseDouble(rcDO.getFinishedRate())))
                    .finishedTime(sdf.parse(rcDO.getFinishedTime()))
                    .upTime(new Date(rcDO.getUpTime()))
                    .build();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static NcRecordCourseware toDO(RecordCourseware recordCourseware) {
        return null;
    }
}