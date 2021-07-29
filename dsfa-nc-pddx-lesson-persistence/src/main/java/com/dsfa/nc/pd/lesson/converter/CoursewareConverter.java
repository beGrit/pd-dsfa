package com.dsfa.nc.pd.lesson.converter;

import com.dsfa.nc.pd.lesson.Do.CoursewareDO;
import com.dsfa.nc.pd.lesson.entity.courseware.Courseware;
import com.dsfa.nc.pd.types.State;
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
@Mapper(imports = {State.class})
public interface CoursewareConverter {
    CoursewareConverter INSTANCE = Mappers.getMapper(CoursewareConverter.class);

    @Mappings({
            @Mapping(target = "id", source = "ncCoursesCoursewareId"),
            @Mapping(target = "state", expression = "java( new State(coursewareDO.getStateValue(), coursewareDO.getStateText()) )")
    })
    Courseware toEntity(CoursewareDO coursewareDO);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "stateValue", expression = "java( courseware.getState().getValue() )"),
            @Mapping(target = "stateText", expression = "java( courseware.getState().getText() )")
    })
    CoursewareDO toDO(Courseware courseware);
}
