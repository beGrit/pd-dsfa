package com.dsfa.nc.web.pd.course.domain.lesson.aggregate;

import com.dsfa.nc.web.pd.course.domain.lesson.dto.CourseAbstractInfoDto;
import com.dsfa.nc.web.pd.course.domain.lesson.dto.CourseDetailInfoDto;
import com.dsfa.nc.web.pd.course.domain.lesson.dto.TeacherAbstractInfoDto;
import com.dsfa.nc.web.pd.course.domain.lesson.entity.course.CourseInfo;
import com.dsfa.nc.web.pd.course.domain.lesson.entity.courseware.Courseware;
import com.dsfa.nc.web.pd.course.domain.teacher.entity.TeacherInfo;
import com.dsfa.platform.sdk.common.kit.StrKit;
import lombok.Getter;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @ClassName Course 课程(包含基本信息, 课件信息, 教师信息)
 * @Description TODO 课程聚合对象
 * @Author pocky
 * @Date 2021/7/27
 **/
@Getter
public class Course {
    /**
     * 课程基本信息
     */
    private CourseInfo courseInfo;
    /**
     * 课程展现在简介页的教师
     */
    private TeacherInfo showedTeacher;
    /**
     * 课程下的所有课件
     */
    private List<Courseware> coursewareList;
    /**
     * 课程下的所有教师
     */
    private List<TeacherInfo> teacherInfoList;

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
     * 根据当前对象 提取出简介DTO
     * @return 课程简介
     */
    public CourseAbstractInfoDto toCourseAbstractInfoDto() {
        CourseAbstractInfoDto res = new CourseAbstractInfoDto();

        // 基础字段
        BeanUtils.copyProperties(courseInfo, res);

        // 外实体
        if (showedTeacher != null) {
            TeacherAbstractInfoDto teacher = showedTeacher.toTeacherAbstractInfoDto();
            res.setTeacher(teacher);
        }

        return res;
    }

    /**
     * 根据当前对象 提取出详情DTO
     * @return 课程详情
     */
    public CourseDetailInfoDto toCourseDetailInfoDto() {
        CourseDetailInfoDto res = new CourseDetailInfoDto();
        BeanUtils.copyProperties(this, res);
        return res;
    }
}
