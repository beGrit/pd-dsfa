package com.dsfa.nc.web.pd.entity.teacher;

import com.dsfa.nc.web.pd.dto.TeacherAbstractInfoDto;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @ClassName Teacher
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/27
 **/
@Data
public class TeacherInfo {
    /**
     * 主键唯一标识
     */
    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 职位
     */
    private String position;
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 照片
     */
    private String photo;
    /**
     * 简介
     */
    private String abstractInfo;
    /**
     * 生日
     */
    private String birth;
    /**
     * 民族
     */
    private String nation;
    /**
     * 性别
     */
    private String gender;
    /**
     * 籍贯
     */
    private String nativePlace;
    /**
     * 获奖情况
     */
    private String awards;

    public TeacherInfo() {
    }

    public TeacherAbstractInfoDto toTeacherAbstractInfoDto() {
        TeacherAbstractInfoDto res = new TeacherAbstractInfoDto();
        BeanUtils.copyProperties(this, res);
        return res;
    }
}
