package com.dsfa.nc.web.pd.course.domain.lesson.converter;

import com.dsfa.nc.web.pd.course.domain.lesson.entity.courseware.Courseware;
import com.dsfa.nc.web.pd.course.persistence.lesson.CoursewareDO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-28T17:28:35+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_281 (Oracle Corporation)"
)
public class CoursewareConverterImpl implements CoursewareConverter {

    @Override
    public Courseware toEntity(CoursewareDO coursewareDO) {
        if ( coursewareDO == null ) {
            return null;
        }

        Courseware courseware = new Courseware();

        courseware.setId( coursewareDO.getNcCoursesCoursewareId() );
        courseware.setRCode( coursewareDO.getRCode() );
        courseware.setTitle( coursewareDO.getTitle() );
        courseware.setRemark( coursewareDO.getRemark() );

        return courseware;
    }

    @Override
    public CoursewareDO toDO(Courseware courseware) {
        if ( courseware == null ) {
            return null;
        }

        CoursewareDO coursewareDO = new CoursewareDO();

        coursewareDO.setNcCoursesCoursewareId( courseware.getId() );
        coursewareDO.setRemark( courseware.getRemark() );
        coursewareDO.setTitle( courseware.getTitle() );
        coursewareDO.setRCode( courseware.getRCode() );

        return coursewareDO;
    }
}
