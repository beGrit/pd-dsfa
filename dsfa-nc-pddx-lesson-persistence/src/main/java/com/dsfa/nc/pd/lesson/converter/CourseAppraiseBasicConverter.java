package com.dsfa.nc.pd.lesson.converter;

import com.dsfa.nc.pd.lesson.Do.CourseAppraiseItemDO;
import com.dsfa.nc.pd.lesson.entity.appraise.CourseAppraiseItem;
import com.dsfa.nc.pd.lesson.types.AppraiseItemType;
import com.dsfa.nc.pd.types.PK;
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
@Mapper(componentModel = "spring", imports = {AppraiseItemType.class, PK.class})
public interface CourseAppraiseBasicConverter {
    CourseAppraiseBasicConverter INSTANCE = Mappers.getMapper(CourseAppraiseBasicConverter.class);

    @Mapping(target = "id", expression = "java( new PK(courseAppraiseItemDO.getCsmlLsfAppraiseId()) )")
    @Mapping(target = "type", expression = "java( new AppraiseItemType(courseAppraiseItemDO.getType()) )")
    CourseAppraiseItem toEntity(CourseAppraiseItemDO courseAppraiseItemDO);

    @InheritInverseConfiguration
    @Mapping(target = "type", expression = "java(courseAppraiseItem.getType().getName())")
    @Mapping(target = "csmlLsfAppraiseId", expression = "java(courseAppraiseItem.getId().getVal())")
    CourseAppraiseItemDO toDO(CourseAppraiseItem courseAppraiseItem);
}
