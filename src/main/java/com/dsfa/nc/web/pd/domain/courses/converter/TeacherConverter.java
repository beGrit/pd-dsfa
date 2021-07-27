package com.dsfa.nc.web.pd.domain.courses.converter;

import com.dsfa.nc.web.pd.domain.teacher.Do.TeacherDO;
import com.dsfa.nc.web.pd.domain.teacher.entity.TeacherInfo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @ClassName TeacherConverter
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/27
 **/
@Mapper
public interface TeacherConverter {
    TeacherConverter INSTANCE = Mappers.getMapper(TeacherConverter.class);

    TeacherInfo toEntity(TeacherDO teacherDO);

    @InheritInverseConfiguration
    TeacherDO toDo(TeacherInfo teacherInfo);
}
