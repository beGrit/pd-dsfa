package com.dsfa.nc.pd.lesson;

import com.dsfa.nc.common.session.UserSession;
import com.dsfa.nc.courses.exception.CourseException;
import com.dsfa.nc.pd.lesson.aggregate.UserCourseRecord;
import com.dsfa.nc.pd.lesson.dto.LearnCoursewareRequestDto;
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

    /**
     * 更新单个学习课件记录
     * @param dto
     * @return
     */
    @PostMapping("one")
    public Result learnCourseware(@RequestBody LearnCoursewareRequestDto dto) {
        UserCourseRecord userCourseRecord = repository.findByCourseIdAndUserId(new PK(dto.getCourseId()), new PK("4bc6fb2bf1e84d7a9993bcd69917bcd0"));
        if (userCourseRecord != null) {
            boolean b = userCourseRecord.changeCoursewareWatchPoint(new PK(dto.getCoursewareId()), dto.getNewTimePoint());
            return success();
        } else {
            throw new CourseException("未找到相应的学习记录");
        }
    }
}
