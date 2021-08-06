package com.dsfa.nc.pd.lesson.assembler;

import com.dsfa.nc.pd.lesson.aggregate.CourseAssess;
import com.dsfa.nc.pd.lesson.dto.CourseAssessDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @ClassName CourseAppraiseBasicAssembler
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/28
 **/
@Mapper
public interface CourseAssessAssembler {
    CourseAssessAssembler INSTANCE = Mappers.getMapper(CourseAssessAssembler.class);

    CourseAssessDto entityToDto(CourseAssess courseAssess);
}
