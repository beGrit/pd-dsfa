package com.dsfa.nc.web.nctest.lsf.demo.controller;

import com.dsfa.nc.web.nctest.lsf.demo.courses.service.TestService;
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

    @RequestMapping("test1")
    public void test1() {
        testService.test();
    }
}
