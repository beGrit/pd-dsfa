package com.dsfa.nc.pd.lesson;

import com.dsfa.nc.common.session.UserSession;
import com.dsfa.nc.courses.exception.CourseException;
import com.dsfa.nc.pd.lesson.aggregate.UserCourseRecordItem;
import com.dsfa.nc.pd.lesson.dto.RecordCoursewareCommand;
import com.dsfa.nc.pd.lesson.reposiitory.IUserCourseRecordRepository;
import com.dsfa.nc.pd.types.PK;
import com.dsfa.platform.sdk.common.Result;
import com.dsfa.platform.starter.web.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RecordCourseController
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/30
 **/
@RestController
@RequestMapping("/api/nc/pd/course/courseware/record")
public class RecordCourseController extends BaseController {

    @Autowired
    IUserCourseRecordRepository repository;

    @Autowired
    UserSession userSession;

    @PostMapping("one")
    public Result learnCourseware(@RequestBody RecordCoursewareCommand cmd) {
        UserCourseRecordItem userCourseRecordItem = repository.find(cmd.getCourseId(), new PK(session().getId()));
        if (userCourseRecordItem != null) {
            boolean b = userCourseRecordItem.changeCoursewareWatchPoint(cmd);
            return success();
        } else {
            throw new CourseException("未找到相应的学习记录");
        }
    }
}
