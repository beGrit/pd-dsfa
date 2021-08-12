package com.dsfa.nc.pd.lesson.aggregate;

import com.dsfa.nc.pd.domain.Aggregate;
import com.dsfa.nc.pd.lesson.dto.RecordCoursewareCommand;
import com.dsfa.nc.pd.lesson.entity.courseware.UserCoursewareRecordItem;
import com.dsfa.nc.pd.types.PK;
import com.dsfa.nc.pd.types.Rate;
import com.dsfa.nc.pd.types.TimePoint;
import com.dsfa.platform.sdk.common.kit.StrKit;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.List;

/**
 * @ClassName UserCourseRecord 用户课程学习记录
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/30
 **/
@Getter
@Builder
public class UserCourseRecordItem implements Aggregate<PK> { // 用户学习课程的记录
    private PK id;

    /**
     * 用户id
     */
    private PK userId;

    /**
     * 课程id
     */
    private PK courseId;

    /**
     * 可获得的学时
     */
    private String winPeriod;

    /**
     * 完成度
     */
    private Rate finishedRate;

    /**
     * 是否完成
     */
    private boolean isFinished;

    /**
     * 记录最新更新的日期
     */
    private Date upTime;

    /**
     * 完成时的日期
     */
    private Date finishedTime;

    /**
     * 课程下的子课件的学习记录
     */
    private List<UserCoursewareRecordItem> userCoursewareRecordItemList;

    @Override
    public PK getId() {
        return this.id;
    }

    public boolean changeCoursewareWatchPoint(RecordCoursewareCommand cmd) {
        PK coursewareId = cmd.getCoursewareId();
        TimePoint newWatchPoint = cmd.getNewWatchPoint();
        boolean res = false;
        for (UserCoursewareRecordItem courseware : userCoursewareRecordItemList) {
            boolean b = StrKit.equals(courseware.getCoursewareId().getVal(), coursewareId.getVal());
            if (b) {
                int rtn = courseware.changeWatchPoint(newWatchPoint);
                if (rtn == 2) {
                    finishedRate = calRate();
                    if (finishedRate.equals(new Rate(1))) {
                        this.isFinished = true;
                        this.finishedTime = new Date();
                    }
                }
                upTime = new Date();
                res = true;
                break;
            }
        }
        return res;
    }

    /**
     * 计算完成度
     * @return
     */
    private Rate calRate() {
        long sum = 0;
        long watchedSum = 0;
        for (UserCoursewareRecordItem userCoursewareRecordItem : userCoursewareRecordItemList) {
            long itemSum = userCoursewareRecordItem.getSumDurationLong();
            long itemFinishedTime = userCoursewareRecordItem.getLastWatchPoint().getSeconds();
            sum += itemSum;
            watchedSum += itemFinishedTime;
        }
        this.finishedRate = new Rate(watchedSum * 1.0 / sum);
        return finishedRate;
    }
}
