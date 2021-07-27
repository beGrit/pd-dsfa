package com.dsfa.nc.web.pd.domain.controller;

import com.dsfa.nc.web.pd.domain.courses.entity.courseware.Courseware;
import com.dsfa.nc.web.pd.domain.courses.repository.ICoursewareRepository;
import com.dsfa.nc.web.pd.domain.courses.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/23
 **/
@RequestMapping("/web/nctest/lsf")
@RestController
public class LsfTestController {

    @Autowired
    TestService testService;

    @Autowired
    ICoursewareRepository courseRepository;

    @RequestMapping("test1")
    public void test1() {
        Courseware courseware = courseRepository.findByID("00208a0b-1bbf-48dc-a957-27fc63b88068");
        testService.test();
    }
}
