package com.dsfa.nc.web.nctest.lsf.demo.courses.assembler;

import com.dsfa.nc.web.nctest.lsf.demo.courses.dto.CourseDTO;
import com.dsfa.nc.web.nctest.lsf.demo.courses.entity.course.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @ClassName CourseAssember
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/23
 **/
@Mapper
public interface CourseDtoAssembler {
    CourseDtoAssembler INSTANCE = Mappers.getMapper( CourseDtoAssembler.class );

    @Mapping(target = "courseName", source = "name")
    CourseDTO toDTO(Course course);
}
