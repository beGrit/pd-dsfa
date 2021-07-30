package com.dsfa.nc.pd.lesson.converter;

import com.dsfa.nc.courses.api.record.course.pojo.po.NcRecordCourse;
import com.dsfa.nc.courses.api.record.courseware.pojo.po.NcRecordCourseware;
import com.dsfa.nc.pd.lesson.aggregate.UserCourseRecord;
import com.dsfa.nc.pd.lesson.entity.courseware.RecordCourseware;
import com.dsfa.nc.pd.lesson.types.Rate;
import com.dsfa.nc.pd.types.PK;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName UserCourseRecordConverter
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/30
 **/
public class UserCourseRecordConverter {
    public static final UserCourseRecord toEntity(NcRecordCourse recordCourse, List<NcRecordCourseware> ncRecordCoursewareList) {

        String id = recordCourse.getNcRecordCourseId();
        String courseId = recordCourse.getRelationId();
        String userId = recordCourse.getDsfaOuaUserId();
        String winPeriod = recordCourse.getWinPeriod();
        Integer rate = Integer.parseInt(recordCourse.get("finished_rate"));
        Integer isFinishedValue = Integer.parseInt(recordCourse.get("is_finished_value"));
        String upTime = recordCourse.getUpTime();
        Date finishedTime = recordCourse.getFinishedTime();

        List<RecordCourseware> list = new LinkedList<>();
        for (NcRecordCourseware item : ncRecordCoursewareList) {
            RecordCourseware recordCourseware = RecordCoursewareConverter.toEntity(item);
            list.add(recordCourseware);
        }

        UserCourseRecord res = UserCourseRecord.builder()
                .id(new PK(id))
                .courseId(new PK(courseId))
                .userId(new PK(userId))
                .winPeriod(winPeriod)
                .finishedRate(new Rate(rate))
                .isFinished(isFinishedValue == 1)
                .upTime(new Date(Long.parseLong(upTime)))
                .finishedTime(finishedTime)
                // 组装课件学习记录
                .recordCoursewareList(list)
                .build();
        return res;
    }
}
