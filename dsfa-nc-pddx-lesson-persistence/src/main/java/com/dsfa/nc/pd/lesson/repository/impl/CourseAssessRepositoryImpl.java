package com.dsfa.nc.pd.lesson.repository.impl;

import com.dsfa.nc.pd.lesson.aggregate.CourseAssess;
import com.dsfa.nc.pd.lesson.entity.appraise.CourseAssessItem;
import com.dsfa.nc.pd.lesson.reposiitory.ICourseAssessItemRepository;
import com.dsfa.nc.pd.lesson.reposiitory.ICourseAssessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName ICourseAppraiseRepositoryImpl
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/28
 **/
@Repository
@CacheConfig(cacheNames = "CourseAssess")
public class CourseAssessRepositoryImpl implements ICourseAssessRepository {
    @Autowired
    ICourseAssessItemRepository itemRepository;

    @Cacheable(cacheNames = "oneByCourseId", key = "#courseId")
    public CourseAssess findByCourseId(String courseId) {
        List<CourseAssessItem> items = itemRepository.findListByCourseId(courseId);
        CourseAssess courseAssess = new CourseAssess(courseId, items);
        return courseAssess;
    }
}