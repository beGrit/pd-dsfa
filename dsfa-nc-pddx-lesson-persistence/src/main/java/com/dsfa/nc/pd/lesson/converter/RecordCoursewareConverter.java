package com.dsfa.nc.pd.lesson.converter;

import com.dsfa.nc.courses.api.record.courseware.pojo.po.NcRecordCourseware;
import com.dsfa.nc.pd.lesson.entity.courseware.UserCoursewareRecordItem;
import com.dsfa.nc.pd.types.PK;
import com.dsfa.nc.pd.types.Rate;
import com.dsfa.nc.pd.types.TimePoint;
import com.dsfa.platform.sdk.common.kit.StrKit;

import java.math.BigDecimal;
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
    public static UserCoursewareRecordItem toEntity(NcRecordCourseware rcDO) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        UserCoursewareRecordItem res = null;
        try {
            Date finishedTime = null;
            if (rcDO.getFinishedTime() != null) {
                finishedTime = sdf.parse(rcDO.getFinishedTime());
            }
            res = UserCoursewareRecordItem.builder()
                    .id(new PK(rcDO.getNcRecordCoursewareId()))
                    .coursewareId(new PK(rcDO.getRelationId()))
                    .userId(new PK(rcDO.getDsfaOuaUserId()))
                    .sumWatchTime(new BigDecimal( Double.parseDouble(rcDO.get("sum_watch_time")) ))
                    .lastWatchPoint(new TimePoint(rcDO.getLastWatchPoint()))
                    .sumDurationLong(Long.parseLong(rcDO.get("sum_duration_long")))
                    .isFinished(StrKit.equals(rcDO.getIsFinishedValue(), "1"))
                    .finishedRate(new Rate(Integer.parseInt(rcDO.getFinishedRate())))
                    .finishedTime(finishedTime)
                    .upTime(new Date(Long.parseLong(rcDO.get("up_time"))))
                    .build();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static NcRecordCourseware toDO(UserCoursewareRecordItem userCoursewareRecordItem) {
        return null;
    }
}
