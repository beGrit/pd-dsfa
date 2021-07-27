package com.dsfa.nc.web.pd.domain.courses.service;

import com.dsfa.nc.web.pd.domain.courses.Do.CoursewareDO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName Test
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/23
 **/
@Service
public class TestService {
    CoursewareDO dao = new CoursewareDO().dao();

    public void test() {
        List<CoursewareDO> coursewareList = dao.find("select * from nc_courses_courseware");
        System.out.println();
    }
}
