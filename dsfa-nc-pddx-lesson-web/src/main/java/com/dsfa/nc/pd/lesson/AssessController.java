package com.dsfa.nc.pd.lesson;

import com.dsfa.nc.common.session.UserSession;
import com.dsfa.nc.courses.exception.CourseException;
import com.dsfa.nc.pd.lesson.aggregate.CourseAssess;
import com.dsfa.nc.pd.lesson.assembler.CourseAssessAssembler;
import com.dsfa.nc.pd.lesson.dto.CourseAssessDto;
import com.dsfa.nc.pd.lesson.reposiitory.ICourseAssessRepository;
import com.dsfa.nc.pd.lesson.service.IAssessService;
import com.dsfa.platform.sdk.common.Result;
import com.dsfa.platform.starter.web.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;


/**
 * @ClassName AppraiseController 评价controller
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/28
 **/
@RestController
@RequestMapping(value = "/course/assess")
public class AssessController extends BaseController {

    @Autowired
    @Qualifier(value = "pd5.0_course_assess")
    IAssessService assessService;

    @Autowired
    ICourseAssessRepository courseAssessRepository;

    @Autowired
    UserSession userSession;

    @PostMapping(value = "one")
    public Result assess(@RequestParam("id") String courseId, @RequestParam("type") String type) {
        String userId = userSession.getUnitId();
        boolean rtn = assessService.assessCourse(courseId, userId, type);
        if (rtn) {
            return success();
        } else {
            throw new CourseException("评价失败");
        }
    }

    @GetMapping(value = "one")
    public Result getAssess(@RequestParam("id") String courseId) {
        CourseAssess courseAssess = courseAssessRepository.findByCourseId(courseId);
        CourseAssessDto dto = CourseAssessAssembler.INSTANCE.entityToDto(courseAssess);
        return success(dto);
    }
}
