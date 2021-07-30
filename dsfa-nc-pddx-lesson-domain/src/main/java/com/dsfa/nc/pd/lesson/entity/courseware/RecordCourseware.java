package com.dsfa.nc.pd.lesson.entity.courseware;

import com.dsfa.nc.pd.domain.Entity;
import com.dsfa.nc.pd.lesson.types.Rate;
import com.dsfa.nc.pd.lesson.types.TimePoint;
import com.dsfa.nc.pd.types.PK;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName RecordCourseware 课件学习记录
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/29
 **/
@Getter
@Setter
@Builder
public class RecordCourseware implements Entity<PK> {
    /**
     * 主键唯一标识
     */
    private PK id;

    /**
     * 课件id
     */
    private PK coursewareId;

    /**
     * 用户id
     */
    private PK userId;

    /**
     * 观看的总时长 (秒为单位)
     */
    private BigDecimal sumWatchTime;

    /**
     * 最后观看的时间点
     */
    private TimePoint lastWatchPoint;

    /**
     * 是否学完了
     */
    private boolean isFinished;

    /**
     * 完成度
     */
    private Rate finishedRate;

    /**
     * 完成时间点
     */
    private Date finishedTime;

    /**
     * 总时长_秒
     */
    private long sumDurationLong;

    /**
     * 记录更新时间
     */
    private Date upTime;

    /**
     * 修改学习记录断点
     * @param newWatchPoint 新断点时间
     * @return
     */
    public int changeWatchPoint(TimePoint newWatchPoint) {
        int rtn = 0;
        if (newWatchPoint.getSeconds() <= sumDurationLong || newWatchPoint.getSeconds() >= 0) {
            if (!isFinished && !newWatchPoint.before(lastWatchPoint)) { // 未完成且需要往后移动,需要更新 finishedRate
                if (lastWatchPoint.getSeconds() == this.sumDurationLong) { // 需要修改为完成状态
                    this.isFinished = true;
                    this.finishedTime = new Date();
                    return 2;
                }
                long l1 = newWatchPoint.getSeconds() - this.lastWatchPoint.getSeconds();
                double rateVal = l1 / (sumDurationLong * 1.0);
                finishedRate = new Rate(rateVal);
                this.sumDurationLong += l1;
                return 1;
            } else if (isFinished && !newWatchPoint.before(lastWatchPoint)) { // 已完成且需要往后移动
                long l1 = newWatchPoint.getSeconds() - this.lastWatchPoint.getSeconds();
                this.sumDurationLong += l1;
            }
            this.lastWatchPoint = newWatchPoint;
            this.upTime = new Date();
            return 0;
        } else { // 更新的断点时间大于总时间或者小于0,非法状态迁移
            return -1;
        }
    }
}
