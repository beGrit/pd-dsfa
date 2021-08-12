package com.dsfa.nc.pd.lesson.service.impl;

import com.dsfa.nc.courses.api.info.pojo.po.NcCoursesInfo;
import com.dsfa.nc.courses.api.info.service.INcCourseInfoService;
import com.dsfa.nc.pd.lesson.cache.ICourseAssessItemCacheService;
import com.dsfa.nc.pd.lesson.entity.appraise.CourseAssessItem;
import com.dsfa.nc.pd.lesson.reposiitory.ICourseAssessItemRepository;
import com.dsfa.nc.pd.lesson.service.IAssessService;
import com.dsfa.nc.pd.types.AssessType;
import com.dsfa.platform.sdk.common.kit.StrKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName AppraiseServiceImpl
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/28
 **/
@Service("pd5.0_course_assess")
public class AssessServiceImpl implements IAssessService {
    @Autowired
    ICourseAssessItemRepository courseAssessRepository;

    @Autowired
    INcCourseInfoService iNcCourseInfoService;

    @Autowired
    ICourseAssessItemCacheService courseAssessItemCacheService;

    @Override
    public boolean assessCourse(String courseId, String accountId, String type) {
        int rtn = 1;
        CourseAssessItem item = courseAssessItemCacheService.cacheFind("7012d80a9d86434e848b6fcc8ab1b422",courseId, accountId);
        if (item == null) {
            NcCoursesInfo courseInfoDo = iNcCourseInfoService.queryCourseInfoModelById(courseId);
            if (courseInfoDo == null || StrKit.equals(courseInfoDo.getDsDeleted(), "1")) {
                // 课程id参数有误,不存在这么课
                rtn = 0;
            } else {
                item = new CourseAssessItem();
                item.setCourseId(courseId);
                item.setAccountId(accountId);
                item.setType(new AssessType(type));
            }
        } else {
            item.changeType(new AssessType(type));
        }
        courseAssessItemCacheService.cacheSync(item);
        courseAssessItemCacheService.cacheUpdate(item);
        return rtn == 1;
    }
}
