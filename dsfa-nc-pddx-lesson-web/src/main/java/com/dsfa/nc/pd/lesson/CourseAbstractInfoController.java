package com.dsfa.nc.pd.lesson;

import com.dsfa.nc.pd.lesson.dto.CourseAbstractInfoDto;
import com.dsfa.nc.pd.lesson.aggregate.Course;
import com.dsfa.nc.pd.lesson.reposiitory.ICourseRepository;
import com.dsfa.platform.sdk.common.Result;
import com.dsfa.platform.starter.web.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName CourseAbstractInfoController 课程简介API
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/27
 **/
@RestController
@RequestMapping(value = "/pc/nc/course/abstract")
public class CourseAbstractInfoController extends BaseController {
    @Autowired
    ICourseRepository courseRepository;

    /**
     * 根据courseId获取课程简介
     * @param courseId 课程id
     * @return
     */
    @GetMapping(value = "one")
    public Result findOneById(@RequestParam("id") String courseId) {
        // 从仓库中检索课程
        Course course = courseRepository.findByID(courseId);

        // 课程转化为前端需要的简介dto
        CourseAbstractInfoDto courseAbstractInfoDto = course.toCourseAbstractInfoDto();

        return success(courseAbstractInfoDto);
    }
}
