package com.dsfa.nc.pd.lesson.aggregate;

import com.dsfa.nc.pd.domain.Aggregate;
import com.dsfa.nc.pd.domain.Entity;
import com.dsfa.nc.pd.lesson.entity.appraise.CourseAppraiseItem;
import com.dsfa.nc.pd.lesson.types.AppraiseItemType;
import com.dsfa.nc.pd.types.PK;
import com.dsfa.platform.sdk.common.kit.StrKit;
import lombok.Getter;

import java.util.List;

/**
 * @ClassName CourseAppraise 课程评价 (包含基本信息, 课程id, 所有评价)
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/28
 **/
@Getter
public class CourseAppraise implements Aggregate<PK> {
    private PK id;

    private String courseId;

    private Double score;

    private List<CourseAppraiseItem> items;

    public Long getNums() {
        return (long) this.items.size();
    }

    public CourseAppraise(String courseId, List<CourseAppraiseItem> items) {
        this.courseId = courseId;
        this.items = items;
        int count = 0;
        if (items != null) {
            for (int i = 0; i < items.size(); i++) {
                count += items.get(i).getType().getScore();
            }
            this.score = count / (items.size() * 1.0);
        }
    }

    /**
     * 课程被某人评价
     *
     * @param accountId
     * @param appraiseItemType
     * @return
     */
    public boolean beAppraise(String accountId, AppraiseItemType appraiseItemType) {
        if (this.items != null) {
            boolean flag1 = true;
            for (CourseAppraiseItem item : items) {
                String accountId2 = item.getAccountId();
                if (StrKit.equals(accountId, accountId2)) {
                    // 修改请求
                    flag1 = false;
                    item.setAccountId(accountId);
                    item.setType(appraiseItemType);
                    return true;
                }
            }
            if (flag1) {
                // 新增请求
                CourseAppraiseItem courseAppraiseItem = new CourseAppraiseItem();
                courseAppraiseItem.setId(new PK(StrKit.uuid()));
                courseAppraiseItem.setCourseId(this.courseId);
                courseAppraiseItem.setAccountId(accountId);
                courseAppraiseItem.setType(appraiseItemType);
                items.add(courseAppraiseItem);
                return true;
            }
        }
        return false;
    }
}
