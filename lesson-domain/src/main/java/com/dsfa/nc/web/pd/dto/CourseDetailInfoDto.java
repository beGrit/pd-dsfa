package com.dsfa.nc.web.pd.dto;

import com.dsfa.nc.web.pd.entity.course.CourseInfo;
import com.dsfa.nc.web.pd.entity.courseware.Courseware;
import com.dsfa.nc.web.pd.entity.teacher.TeacherInfo;
import lombok.Data;

import java.util.List;

/**
 * @ClassName CourseDetailInfoDto 课程详情(DTO)
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/28
 **/
@Data
public class CourseDetailInfoDto {
    private CourseInfo courseInfo;

    private List<TeacherInfo> teacherInfoList;

    private List<Courseware> coursewareList;
}
