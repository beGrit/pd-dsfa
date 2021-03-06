package com.dsfa.nc.web.pd.course.api;

import com.dsfa.nc.web.pd.course.domain.lesson.aggregate.Course;
import com.dsfa.nc.web.pd.course.domain.lesson.dto.CourseDetailInfoDto;
import com.dsfa.nc.web.pd.course.domain.lesson.repository.ICourseRepository;
import com.dsfa.platform.sdk.common.Result;
import com.dsfa.platform.starter.web.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName CourseDetailInfoController 课程详情API
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/28
 **/
@RestController
@RequestMapping(value = "/pc/nc/course/detail")
public class CourseDetailInfoController extends BaseController {
    @Autowired
    ICourseRepository courseRepository;

    @GetMapping(value = "one")
    public Result findOneById(@RequestParam("id") String courseId) {
        // 从仓库中检索课程
        Course course = courseRepository.findByID(courseId);

        // 课程转化为前端需要的详细dto
        CourseDetailInfoDto data = course.toCourseDetailInfoDto();

        return success(data);
    }
}
