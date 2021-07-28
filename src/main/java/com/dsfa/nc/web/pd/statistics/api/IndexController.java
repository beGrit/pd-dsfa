package com.dsfa.nc.web.pd.statistics.api;

import com.dsfa.nc.web.pd.statistics.dto.CountDto;
import com.dsfa.nc.web.pd.statistics.service.IndexCountService;
import com.dsfa.platform.sdk.common.Result;
import com.dsfa.platform.starter.web.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName IndexController PC首页数据统计API
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/26
 **/
@RestController
@RequestMapping(value = "/pc/nc/pagehome/index")
public class IndexController extends BaseController {
    @Autowired
    IndexCountService countService;

    @GetMapping(value = "counts")
    public Result counts() {
        CountDto dto = countService.getCounts();
        return success(dto);
    }
}
