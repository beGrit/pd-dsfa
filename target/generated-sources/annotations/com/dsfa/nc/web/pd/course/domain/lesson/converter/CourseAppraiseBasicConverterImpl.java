package com.dsfa.nc.web.pd.course.domain.lesson.converter;

import com.dsfa.nc.web.pd.course.domain.lesson.entity.appraise.CourseAppraiseItem;
import com.dsfa.nc.web.pd.course.domain.lesson.types.AppraiseItemType;
import com.dsfa.nc.web.pd.course.persistence.lesson.CourseAppraiseItemDO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-28T17:28:35+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_281 (Oracle Corporation)"
)
@Component
public class CourseAppraiseBasicConverterImpl implements CourseAppraiseBasicConverter {

    @Override
    public CourseAppraiseItem toEntity(CourseAppraiseItemDO courseAppraiseItemDO) {
        if ( courseAppraiseItemDO == null ) {
            return null;
        }

        CourseAppraiseItem courseAppraiseItem = new CourseAppraiseItem();

        courseAppraiseItem.setId( courseAppraiseItemDO.getCsmlLsfAppraiseId() );
        courseAppraiseItem.setCourseId( courseAppraiseItemDO.getCourseId() );
        courseAppraiseItem.setAccountId( courseAppraiseItemDO.getAccountId() );

        courseAppraiseItem.setType( new AppraiseItemType(courseAppraiseItemDO.getType()) );

        return courseAppraiseItem;
    }

    @Override
    public CourseAppraiseItemDO toDO(CourseAppraiseItem courseAppraiseItem) {
        if ( courseAppraiseItem == null ) {
            return null;
        }

        CourseAppraiseItemDO courseAppraiseItemDO = new CourseAppraiseItemDO();

        courseAppraiseItemDO.setCsmlLsfAppraiseId( courseAppraiseItem.getId() );
        courseAppraiseItemDO.setCourseId( courseAppraiseItem.getCourseId() );
        courseAppraiseItemDO.setAccountId( courseAppraiseItem.getAccountId() );

        courseAppraiseItemDO.setType( courseAppraiseItem.getType().getName() );

        return courseAppraiseItemDO;
    }
}
