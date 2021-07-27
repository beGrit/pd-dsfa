package com.dsfa.nc.web.pd.domain.courses.converter;

import com.dsfa.nc.web.pd.domain.teacher.Do.TeacherDO;
import com.dsfa.nc.web.pd.domain.teacher.entity.TeacherInfo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-27T17:21:42+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_281 (Oracle Corporation)"
)
public class TeacherConverterImpl implements TeacherConverter {

    @Override
    public TeacherInfo toEntity(TeacherDO teacherDO) {
        if ( teacherDO == null ) {
            return null;
        }

        TeacherInfo teacherInfo = new TeacherInfo();

        teacherInfo.setName( teacherDO.getName() );
        teacherInfo.setPosition( teacherDO.getPosition() );
        teacherInfo.setPhone( teacherDO.getPhone() );
        teacherInfo.setPhoto( teacherDO.getPhoto() );
        if ( teacherDO.getBirth() != null ) {
            teacherInfo.setBirth( new SimpleDateFormat().format( teacherDO.getBirth() ) );
        }
        teacherInfo.setAwards( teacherDO.getAwards() );
        teacherInfo.setPinyin( teacherDO.getPinyin() );

        return teacherInfo;
    }

    @Override
    public TeacherDO toDo(TeacherInfo teacherInfo) {
        if ( teacherInfo == null ) {
            return null;
        }

        TeacherDO teacherDO = new TeacherDO();

        teacherDO.setName( teacherInfo.getName() );
        teacherDO.setPhoto( teacherInfo.getPhoto() );
        teacherDO.setPhone( teacherInfo.getPhone() );
        try {
            if ( teacherInfo.getBirth() != null ) {
                teacherDO.setBirth( new SimpleDateFormat().parse( teacherInfo.getBirth() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        teacherDO.setAwards( teacherInfo.getAwards() );
        teacherDO.setPosition( teacherInfo.getPosition() );
        teacherDO.setPinyin( teacherInfo.getPinyin() );

        return teacherDO;
    }
}
