package com.dsfa.nc.pd.lesson;

import com.dsfa.nc.pd.lesson.aggregate.CourseAppraise;
import com.dsfa.nc.pd.lesson.reposiitory.ICourseAppraiseRepository;
import com.dsfa.platform.sdk.common.Result;
import com.dsfa.platform.starter.web.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName CourseAppraiseController
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/28
 **/
@RestController
@RequestMapping("/courseAppraise")
public class CourseAppraiseController extends BaseController {
    @Autowired
    ICourseAppraiseRepository courseAppraiseRepository;

    @RequestMapping(value = "one")
    public Result one(@RequestParam("courseId") String courseId) {
        CourseAppraise data = courseAppraiseRepository.findByCourseId(courseId);
        return success().setData(data);
    }
}
