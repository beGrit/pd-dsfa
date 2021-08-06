package com.dsfa.nc.pd.lesson.converter;

import com.dsfa.nc.pd.lesson.Do.CourseAssessItemDO;
import com.dsfa.nc.pd.lesson.entity.appraise.CourseAssessItem;
import com.dsfa.nc.pd.lesson.types.AssessType;
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
@Mapper(componentModel = "spring", imports = {AssessType.class, PK.class})
public interface CourseAssessItemConverter {
    CourseAssessItemConverter INSTANCE = Mappers.getMapper(CourseAssessItemConverter.class);

    @Mapping(target = "id", expression = "java( new PK(courseAssessItemDO.getCsmlLsfAssessId()) )")
    @Mapping(target = "type", expression = "java( new AssessType(courseAssessItemDO.getType()) )")
    CourseAssessItem toEntity(CourseAssessItemDO courseAssessItemDO);

    @InheritInverseConfiguration
    @Mapping(target = "type", expression = "java(courseAssessItem.getType().getName())")
    @Mapping(target = "csmlLsfAssessId", expression = "java(courseAssessItem.getId().getVal())")
    CourseAssessItemDO toDO(CourseAssessItem courseAssessItem);
}
