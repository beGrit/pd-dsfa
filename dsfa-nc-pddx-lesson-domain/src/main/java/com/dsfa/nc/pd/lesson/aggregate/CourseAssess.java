package com.dsfa.nc.pd.lesson.aggregate;

import com.dsfa.nc.pd.domain.Entity;
import com.dsfa.nc.pd.lesson.entity.appraise.CourseAssessItem;
import com.dsfa.nc.pd.lesson.types.AssessType;
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
public class CourseAssess implements Entity<PK> {
    private PK id;

    private String courseId;

    private Double score;

    private List<CourseAssessItem> items;

    public int getNumberOfPeople() {
        return this.items.size();
    }

    public CourseAssess(String courseId, List<CourseAssessItem> items) {
        this.id = new PK(courseId);
        this.courseId = courseId;
        this.items = items;
        double sum = 0;
        if (items != null) {
            for (int i = 0; i < items.size(); i++) {
                sum += items.get(i).getType().getScore();
            }
            this.score = sum / (items.size() * 1.0);
        }
    }

    /**
     * 课程被某人评价
     *
     * @param accountId
     * @param assessType
     * @return
     */
    public boolean beAppraise(String accountId, AssessType assessType) {
        if (this.items != null) {
            boolean flag1 = true;
            for (CourseAssessItem item : items) {
                String accountId2 = item.getAccountId();
                if (StrKit.equals(accountId, accountId2)) {
                    // 修改请求
                    flag1 = false;
                    item.setAccountId(accountId);
                    item.setType(assessType);
                    return true;
                }
            }
            if (flag1) {
                // 新增请求
                CourseAssessItem courseAssessItem = new CourseAssessItem();
                courseAssessItem.setId(new PK(StrKit.uuid()));
                courseAssessItem.setCourseId(this.courseId);
                courseAssessItem.setAccountId(accountId);
                courseAssessItem.setType(assessType);
                items.add(courseAssessItem);
                return true;
            }
        }
        return false;
    }
}
