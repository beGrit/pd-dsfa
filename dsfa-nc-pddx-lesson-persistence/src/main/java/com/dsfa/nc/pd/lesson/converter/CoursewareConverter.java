package com.dsfa.nc.pd.lesson.converter;

import com.dsfa.nc.pd.lesson.Do.CoursewareDO;
import com.dsfa.nc.pd.lesson.entity.courseware.Courseware;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @InterfaceName CoursewareConverter
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/27
 **/
@Mapper
public interface CoursewareConverter {
    CoursewareConverter INSTANCE = Mappers.getMapper(CoursewareConverter.class);

    @Mappings({
            @Mapping(target = "id", source = "ncCoursesCoursewareId")
    })
    Courseware toEntity(CoursewareDO coursewareDO);

    @InheritInverseConfiguration
    CoursewareDO toDO(Courseware courseware);
}
