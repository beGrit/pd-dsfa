package com.dsfa.nc.web.pd.converter;

import com.dsfa.nc.web.pd.Do.TeacherDO;
import com.dsfa.nc.web.pd.entity.teacher.TeacherInfo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
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

    @Mappings(
            @Mapping(source = "ncTeacherId", target = "id")
    )
    TeacherInfo toEntity(TeacherDO teacherDO);

    @InheritInverseConfiguration
    TeacherDO toDo(TeacherInfo teacherInfo);
}
