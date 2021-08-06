package com.dsfa.nc.pd.lesson.service.impl;

import com.dsfa.nc.courses.api.info.pojo.po.NcCoursesInfo;
import com.dsfa.nc.courses.api.info.service.INcCourseInfoService;
import com.dsfa.nc.pd.lesson.entity.appraise.CourseAssessItem;
import com.dsfa.nc.pd.lesson.service.IAssessService;
import com.dsfa.nc.pd.lesson.types.AssessType;
import com.dsfa.nc.pd.lesson.reposiitory.ICourseAssessItemRepository;
import com.dsfa.platform.sdk.common.kit.StrKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public boolean assessCourse(String courseId, String accountId, String type) {
        int rtn;
        CourseAssessItem item = courseAssessRepository.findByCourseIdAndAccountId(courseId, accountId);
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
                rtn = courseAssessRepository.save(item);
            }
        } else {
            item.changeType(new AssessType(type));
            rtn = courseAssessRepository.save(item);
        }
        return rtn == 1;
    }
}
