package com.dsfa.nc.web.pd.course.domain.lesson.converter;

import com.dsfa.nc.web.pd.course.domain.lesson.entity.course.CourseInfo;
import com.dsfa.nc.web.pd.course.persistence.lesson.CourseInfoDO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-28T17:28:35+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_281 (Oracle Corporation)"
)
public class CourseInfoConverterImpl implements CourseInfoConverter {

    @Override
    public CourseInfo toEntity(CourseInfoDO courseInfoDO) {
        if ( courseInfoDO == null ) {
            return null;
        }

        CourseInfo courseInfo = new CourseInfo();

        courseInfo.setId( courseInfoDO.getNcCoursesInfoId() );
        courseInfo.setRLabel( courseInfoDO.getRLabelValue() );
        courseInfo.setClassification( courseInfoDO.getClassificationValue() );
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

        courseInfoDO.setNcCoursesInfoId( courseInfo.getId() );
        courseInfoDO.setRLabelValue( courseInfo.getRLabel() );
        courseInfoDO.setClassificationValue( courseInfo.getClassification() );
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
