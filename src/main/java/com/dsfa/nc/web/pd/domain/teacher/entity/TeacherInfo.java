package com.dsfa.nc.web.pd.domain.teacher.entity;

import com.dsfa.nc.web.pd.domain.courses.dto.TeacherAbstractInfoDto;
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
    private String name;
    private String position;
    private String phone;
    private String photo;
    private String abstractInfo;
    private String birth;
    private String nation;
    private String gender;
    private String nativePlace;
    private String awards;
    private String pinyin;

    public TeacherInfo() {
    }

    public TeacherAbstractInfoDto toTeacherAbstractInfoDto() {
        TeacherAbstractInfoDto res = new TeacherAbstractInfoDto();
        BeanUtils.copyProperties(this, res);
        return res;
    }
}
