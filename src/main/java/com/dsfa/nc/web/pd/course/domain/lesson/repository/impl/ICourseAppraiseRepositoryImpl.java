package com.dsfa.nc.web.pd.course.domain.lesson.repository.impl;

import com.dsfa.nc.web.pd.course.domain.lesson.aggregate.CourseAppraise;
import com.dsfa.nc.web.pd.course.domain.lesson.entity.appraise.CourseAppraiseItem;
import com.dsfa.nc.web.pd.course.domain.lesson.repository.ICourseAppraiseItemRepository;
import com.dsfa.nc.web.pd.course.domain.lesson.repository.ICourseAppraiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName ICourseAppraiseRepositoryImpl
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/28
 **/
@Repository
public class ICourseAppraiseRepositoryImpl implements ICourseAppraiseRepository {
    @Autowired
    ICourseAppraiseItemRepository itemRepository;

    @Override
    public CourseAppraise findByCourseId(String courseId) {
        List<CourseAppraiseItem> items = itemRepository.findListByCourseId(courseId);
        CourseAppraise courseAppraise = new CourseAppraise(courseId, items);
        return courseAppraise;
    }
}
