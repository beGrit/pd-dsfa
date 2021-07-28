package com.dsfa.nc.web.pd.converter;

import com.dsfa.nc.web.pd.Do.CourseAppraiseItemDO;
import com.dsfa.nc.web.pd.entity.appraise.CourseAppraiseItem;
import com.dsfa.nc.web.pd.types.AppraiseItemType;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @ClassName CourseAppraiseBasicConverter
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/28
 **/
@Mapper(componentModel = "spring", imports = AppraiseItemType.class)
public interface CourseAppraiseBasicConverter {
    CourseAppraiseBasicConverter INSTANCE = Mappers.getMapper(CourseAppraiseBasicConverter.class);

    @Mapping(target = "id", source = "csmlLsfAppraiseId")
    @Mapping(target = "type", expression = "java(new AppraiseItemType(courseAppraiseItemDO.getType()))")
    CourseAppraiseItem toEntity(CourseAppraiseItemDO courseAppraiseItemDO);

    @InheritInverseConfiguration
    @Mapping(target = "type", expression = "java(courseAppraiseItem.getType().getName())")
    CourseAppraiseItemDO toDO(CourseAppraiseItem courseAppraiseItem);
}
