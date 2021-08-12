package com.dsfa.nc.pd.lesson.reposiitory;

import com.dsfa.nc.pd.lesson.entity.appraise.CourseAssessItem;

import java.util.List;

/**
 * @ClassName ICourseAppraiseRepository
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/28
 **/
public interface ICourseAssessItemRepository {
    CourseAssessItem find(String courseId, String accountId);

    List<CourseAssessItem> findListByCourseId(String courseId);

    /**
     * 保存
     * @param courseAssessItem
     * @return 影响的记录数
     */
    int save(CourseAssessItem courseAssessItem);
}
