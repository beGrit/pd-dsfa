package com.dsfa.nc.web.pd;

import com.dsfa.nc.courses.exception.CourseException;
import com.dsfa.nc.web.pd.service.ICollectService;
import com.dsfa.platform.sdk.common.Result;
import com.dsfa.platform.starter.web.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @ClassName CollectController
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/28
 **/
@RestController
@RequestMapping(value = "/collect")
public class CollectController extends BaseController {

    @Autowired
    @Qualifier(value = "lsf_collection_service")
    ICollectService collectService;

    @PostMapping(value = "course")
    public Result appraise(@RequestParam("id") String courseId, @RequestParam("type") String type) {
        String accountId = session().getId();
        boolean rtn = collectService.collectCourse(courseId, accountId, type);
        if (rtn) {
            return success();
        } else {
            throw new CourseException("收藏失败");
        }
    }
}
