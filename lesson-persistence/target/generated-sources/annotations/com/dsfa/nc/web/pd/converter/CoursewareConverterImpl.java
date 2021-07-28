package com.dsfa.nc.web.pd.converter;

import com.dsfa.nc.web.pd.Do.CoursewareDO;
import com.dsfa.nc.web.pd.entity.courseware.Courseware;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-28T22:22:20+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_292 (Oracle Corporation)"
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
