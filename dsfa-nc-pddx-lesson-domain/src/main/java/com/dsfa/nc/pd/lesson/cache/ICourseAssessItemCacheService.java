package com.dsfa.nc.pd.lesson.cache;

import com.dsfa.nc.pd.lesson.entity.appraise.CourseAssessItem;
import com.dsfa.nc.pd.lesson.reposiitory.ICourseAssessItemRepository;
import com.dsfa.platform.starter.redis.RedisExecute;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "CourseAssessItem")
public class ICourseAssessItemCacheService { // 课程评价的缓存服务
    @Autowired
    RedisExecute redisExecute;

    @Autowired
    ICourseAssessItemRepository courseAssessItemRepository;

    private static String cacheName = "cache:CourseAssessItem:";

    @Autowired
    ObjectMapper om;

    public CourseAssessItem cacheSync(CourseAssessItem courseAssessItem) {
        String courseId = courseAssessItem.getCourseId();
        String accountId = courseAssessItem.getAccountId();
        return null;
    }

    public CourseAssessItem cacheUpdate(CourseAssessItem courseAssessItem) {
        redisExecute.set(cacheName + courseAssessItem.getId().getVal(), courseAssessItem);
        return courseAssessItem;
    }

    public CourseAssessItem cacheFind(String courseId, String accountId) { // 第一次存储
        String key = courseId + "&" + accountId;
        boolean b = redisExecute.hasKey(cacheName + key);
        if (b) { // redis中有数据
            return (CourseAssessItem) redisExecute.get(cacheName + key);
        } else { // 从关系db中拿
            return courseAssessItemRepository.find(courseId, accountId);
        }
    }
}
