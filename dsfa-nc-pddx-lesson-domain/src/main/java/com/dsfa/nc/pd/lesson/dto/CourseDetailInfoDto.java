package com.dsfa.nc.pd.lesson.dto;

import com.dsfa.nc.pd.lesson.entity.course.CourseInfo;
import com.dsfa.nc.pd.lesson.entity.courseware.Courseware;
import com.dsfa.nc.pd.lesson.entity.teacher.TeacherInfo;
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
