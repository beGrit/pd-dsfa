package com.dsfa.nc.web.test.controller;

import com.dsfa.nc.web.test.service.ImportTest;

import com.dsfa.platform.starter.meta.core.base.DsfaBaseController;
import com.dsfa.platform.starter.session.AuthIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author rm
 * @date 2021年 05月10日 09:18:07
 */
@Controller
@RequestMapping("test")
public class TestController extends DsfaBaseController {
    @Autowired
    ImportTest importTest;


    @AuthIgnore
    @GetMapping("importMd")
    public void importMd() {
       importTest.dsfaRm();
       importTest.importMd();

    }


}
