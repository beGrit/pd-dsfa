package com.dsfa.nc.pd.learn.api;

import com.dsfa.nc.courses.exception.CourseException;
import com.dsfa.nc.pd.learn.dto.LearnCoursewareRequestDto;
import com.dsfa.nc.pd.learn.entity.RecordCourseware;
import com.dsfa.nc.pd.learn.repository.IRecordCoursewareRepository;
import com.dsfa.nc.pd.types.PK;
import com.dsfa.platform.sdk.common.Result;
import com.dsfa.platform.starter.web.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RecordCoursewareController 课件学习接口
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/29
 **/
@RestController
@RequestMapping("/learn/courseware")
public class LearnCoursewareController extends BaseController {

/*
    @Autowired
    IRecordCoursewareRepository coursewareRepository;

    @PostMapping("one")
    public Result learn(@RequestBody LearnCoursewareRequestDto dto) {
        RecordCourseware recordCourseware = coursewareRepository.find(new PK(dto.getCoursewareId()));
        boolean b = recordCourseware.changeWatchPoint(dto.getNewTimePoint());
        if (!b) {
            throw new CourseException("更新学习时间失败");
        } else {
            coursewareRepository.save(recordCourseware);
            return success();
        }
    }
*/
}
