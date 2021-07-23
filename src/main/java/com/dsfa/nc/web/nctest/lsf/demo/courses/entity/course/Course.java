package com.dsfa.nc.web.nctest.lsf.demo.courses.entity.course;

import lombok.Data;

import java.util.List;

/**
 * @ClassName Course
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/23
 **/
@Data
public class Course {
    /**
     * 编号
     */
    private String rCode;

    /**
     * 课程名
     */
    private String title;

    /**
     * 课程分类
     */
    private List<String> classification;

    /**
     * 课程标签
     */
    private List<String> rLabel;

    /**
     * 课程封面
     */
    private String cover;

    /**
     * 课程学时
     */
    private Double period;

    /**
     * 课程简介
     */
    private String content;

    /**
     * 是否公开
     */
    private boolean isPublic;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态(是否启用)
     */
    private boolean state;

    /**
     * 是否发布
     */
    private boolean isPublish;

    /**
     * 是否置顶
     */
    private boolean isTop;

    /**
     * 课程总时长
     */
    private String duration;

    /**
     * 课程的查看量
     */
    private String viewTotle;
}
