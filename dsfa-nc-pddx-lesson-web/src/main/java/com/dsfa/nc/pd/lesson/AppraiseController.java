package com.dsfa.nc.pd.lesson;

import com.dsfa.nc.common.session.UserSession;
import com.dsfa.nc.courses.exception.CourseException;
import com.dsfa.nc.pd.lesson.service.IAppraiseService;
import com.dsfa.platform.sdk.common.Result;
import com.dsfa.platform.starter.meta.session.UserInfoHolder;
import com.dsfa.platform.starter.web.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @ClassName AppraiseController 评价controller
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/28
 **/
@RestController
@RequestMapping(value = "/collect")
public class AppraiseController extends BaseController {

    @Autowired
    @Qualifier(value = "lsf_collection_service")
    IAppraiseService collectService;

    @Autowired
    UserSession userSession;

    @PostMapping(value = "course", produces = "application/json")
    public Result appraise(@RequestParam("id") String courseId, @RequestParam("type") String type) {
        String userId = userSession.getUnitId();
        boolean rtn = collectService.appraiseCourse(courseId, userId, type);
        if (rtn) {
            return success();
        } else {
            throw new CourseException("评价失败");
        }
    }
}
