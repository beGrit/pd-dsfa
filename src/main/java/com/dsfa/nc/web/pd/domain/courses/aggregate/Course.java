package com.dsfa.nc.web.pd.domain.courses.aggregate;

import com.dsfa.nc.web.pd.domain.courses.dto.CourseAbstractInfoDto;
import com.dsfa.nc.web.pd.domain.courses.dto.TeacherAbstractInfoDto;
import com.dsfa.nc.web.pd.domain.courses.entity.course.CourseInfo;
import com.dsfa.nc.web.pd.domain.courses.entity.courseware.Courseware;
import com.dsfa.nc.web.pd.domain.teacher.entity.TeacherInfo;
import com.dsfa.platform.sdk.common.kit.StrKit;
import lombok.Builder;
import lombok.Getter;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @ClassName Course 课程(包含基本信息, )
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/27
 **/
@Getter
public class Course {
    private CourseInfo courseInfo;
    private TeacherInfo showedTeacher;
    private List<Courseware> coursewareList;
    private List<TeacherInfo> teacherInfoList;

    public Course() {
    }

    public Course(CourseInfo courseInfo, TeacherInfo showedTeacher, List<Courseware> coursewareList, List<TeacherInfo> teacherInfoList) {
        this.courseInfo = courseInfo;
        this.showedTeacher = showedTeacher;
        this.coursewareList = coursewareList;
        this.teacherInfoList = teacherInfoList;
    }

    /**
     * 移除课程下的课件
     * @param id1 想要移出的课件的id
     * @return true表示移除成功, false表示移除失败
     */
    public boolean removeCourseware(String id1) {
        for (Courseware courseware : coursewareList) {
            String id2 = courseware.getId();
            if (StrKit.equals(id1, id2)) {
                this.coursewareList.remove(courseware);
                return true;
            }
        }
        return false;
    }

    /**
     * 根据当前对象 输出 CourseAbstractInfoDto
     * @return 课程简介
     */
    public CourseAbstractInfoDto toCourseAbstractInfoDto() {
        CourseAbstractInfoDto res = new CourseAbstractInfoDto();

        // 基础字段
        BeanUtils.copyProperties(courseInfo, res);

        // 外实体
        TeacherAbstractInfoDto teacher = showedTeacher.toTeacherAbstractInfoDto();
        res.setTeacher(teacher);

        return res;
    }
}
