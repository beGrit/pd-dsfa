package com.dsfa.nc.web.nctest.lsf.demo.courses.service;

import com.dsfa.nc.web.nctest.lsf.demo.courses.DO.Courseware;
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
    Courseware dao = new Courseware().dao();

    public void test() {
        List<Courseware> coursewareList = dao.find("select * from nc_courses_courseware");
        System.out.println();
    }
}
