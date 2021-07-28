package com.dsfa.nc.web.pd.converter;

import com.dsfa.nc.web.pd.Do.CourseInfoDO;
import com.dsfa.nc.web.pd.entity.course.CourseInfo;
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
            @Mapping(target = "id", source = "ncCoursesInfoId"),
            @Mapping(target = "RLabel", source = "RLabelValue"),
            @Mapping(target = "classification", source = "classificationValue")
    })
    CourseInfo toEntity(CourseInfoDO courseInfoDO);

    @InheritInverseConfiguration
    CourseInfoDO toDO(CourseInfo courseInfo);
}
