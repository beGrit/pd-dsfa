package com.dsfa.nc.web.pd.domain.courses.converter;

import com.dsfa.nc.web.pd.domain.courses.Do.CourseInfoDO;
import com.dsfa.nc.web.pd.domain.courses.entity.course.CourseInfo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @ClassName CourseInfoConverter
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/27
 **/
@Mapper
public interface CourseInfoConverter {
    CourseInfoConverter INSTANCE = Mappers.getMapper(CourseInfoConverter.class);

    @Mappings({
            @Mapping(target = "pk", source = "ncCoursesInfoId")
    })
    CourseInfo toEntity(CourseInfoDO courseInfoDO);

    @InheritInverseConfiguration
    CourseInfoDO toDO(CourseInfo courseInfo);
}
