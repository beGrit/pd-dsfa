package com.dsfa.nc.web.pd.course.domain.lesson.repository;

import com.dsfa.nc.web.pd.course.domain.lesson.entity.appraise.CourseAppraiseItem;

import java.util.List;

/**
 * @ClassName ICourseAppraiseRepository
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/28
 **/
public interface ICourseAppraiseItemRepository {
    CourseAppraiseItem findByCourseIdAndAccountId(String courseId, String accountId);

    List<CourseAppraiseItem> findListByCourseId(String courseId);

    int save(CourseAppraiseItem courseAppraiseItem);
}
