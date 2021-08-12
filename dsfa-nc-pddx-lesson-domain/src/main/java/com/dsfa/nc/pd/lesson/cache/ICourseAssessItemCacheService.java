package com.dsfa.nc.pd.lesson.cache;

import com.dsfa.nc.pd.lesson.entity.appraise.CourseAssessItem;
import com.dsfa.nc.pd.lesson.reposiitory.ICourseAssessItemRepository;
import com.dsfa.platform.starter.redis.RedisExecute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "CourseAssessItem")
public class ICourseAssessItemCacheService { // 课程评价的缓存服务
    @Autowired
    RedisExecute redisExecute;

    @Autowired
    ICourseAssessItemRepository courseAssessItemRepository;

    private static String cacheName = "cache:CourseAssessItem:";

    @Cacheable(key = "#courseAssessItem.id.val")
    public CourseAssessItem cacheSync(CourseAssessItem courseAssessItem) {
        int save = courseAssessItemRepository.save(courseAssessItem);
        if (save == 1) {
            return courseAssessItem;
        }
        return null;
    }

    @CachePut(key = "#courseAssessItem.id.val")
    public CourseAssessItem cacheUpdate(CourseAssessItem courseAssessItem) {
        redisExecute.set(cacheName + courseAssessItem.getId().getVal(), courseAssessItem);
        return courseAssessItem;
    }

    @Cacheable(key = "#pk")
    public CourseAssessItem cacheFind(String pk, String courseId, String accountId) {
        CourseAssessItem item = courseAssessItemRepository.find(courseId, accountId);
        return item;
    }
}
