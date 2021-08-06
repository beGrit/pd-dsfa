package com.dsfa.nc.pd.lesson;

import com.dsfa.nc.pd.lesson.aggregate.CourseAssess;
import com.dsfa.nc.pd.lesson.reposiitory.ICourseAssessRepository;
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
    ICourseAssessRepository courseAppraiseRepository;

    @RequestMapping(value = "one")
    public Result one(@RequestParam("courseId") String courseId) {
        CourseAssess data = courseAppraiseRepository.findByCourseId(courseId);
        return success().setData(data);
    }
}
