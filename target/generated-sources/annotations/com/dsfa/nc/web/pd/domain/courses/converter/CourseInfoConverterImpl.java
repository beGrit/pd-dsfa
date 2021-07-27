package com.dsfa.nc.web.pd.domain.courses.converter;

import com.dsfa.nc.web.pd.domain.courses.Do.CourseInfoDO;
import com.dsfa.nc.web.pd.domain.courses.entity.course.CourseInfo;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-27T17:20:21+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_281 (Oracle Corporation)"
)
public class CourseInfoConverterImpl implements CourseInfoConverter {

    @Override
    public CourseInfo toEntity(CourseInfoDO courseInfoDO) {
        if ( courseInfoDO == null ) {
            return null;
        }

        CourseInfo courseInfo = new CourseInfo();

        courseInfo.setPk( courseInfoDO.getNcCoursesInfoId() );
        courseInfo.setRCode( courseInfoDO.getRCode() );
        courseInfo.setTitle( courseInfoDO.getTitle() );
        courseInfo.setCover( courseInfoDO.getCover() );
        if ( courseInfoDO.getPeriod() != null ) {
            courseInfo.setPeriod( Double.parseDouble( courseInfoDO.getPeriod() ) );
        }
        courseInfo.setContent( courseInfoDO.getContent() );
        courseInfo.setRemark( courseInfoDO.getRemark() );
        courseInfo.setDuration( courseInfoDO.getDuration() );
        courseInfo.setViewTotle( courseInfoDO.getViewTotle() );

        return courseInfo;
    }

    @Override
    public CourseInfoDO toDO(CourseInfo courseInfo) {
        if ( courseInfo == null ) {
            return null;
        }

        CourseInfoDO courseInfoDO = new CourseInfoDO();

        courseInfoDO.setNcCoursesInfoId( courseInfo.getPk() );
        courseInfoDO.setCover( courseInfo.getCover() );
        courseInfoDO.setTitle( courseInfo.getTitle() );
        courseInfoDO.setContent( courseInfo.getContent() );
        courseInfoDO.setRemark( courseInfo.getRemark() );
        courseInfoDO.setDuration( courseInfo.getDuration() );
        if ( courseInfo.getPeriod() != null ) {
            courseInfoDO.setPeriod( String.valueOf( courseInfo.getPeriod() ) );
        }
        courseInfoDO.setRCode( courseInfo.getRCode() );
        courseInfoDO.setViewTotle( courseInfo.getViewTotle() );

        return courseInfoDO;
    }
}
