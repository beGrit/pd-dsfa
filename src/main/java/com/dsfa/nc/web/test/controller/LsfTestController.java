package com.dsfa.nc.web.test.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName LsfTestController
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/22
 **/
//@RequestMapping("/lsf/test")
//@RestController
public class LsfTestController {
    @RequestMapping("test1")
    public void test() {
        System.out.println();
    }

    @RequestMapping("test2")
    public void test1(@RequestParam("id") String id) {
        System.out.println();
    }

    @PostMapping("test3")
    public void test2(@RequestBody Map map) {
        System.out.println();
    }

    @RequestMapping("test4")
    public void test3(@RequestParam("id") String id, @RequestBody Map map) {
        System.out.println();
    }
}
