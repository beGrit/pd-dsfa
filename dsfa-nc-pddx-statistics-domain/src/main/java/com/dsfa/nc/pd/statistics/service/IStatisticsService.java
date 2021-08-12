package com.dsfa.nc.pd.statistics.service;


import com.dsfa.nc.pd.statistics.dto.CountDto;

/**
 * @ClassName TeacherCountService
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/26
 **/
public interface IStatisticsService {
    /**
     * 获取首页所有的统计数据 (特色班数量,学员数量,教师数量)
     * @return
     */
    CountDto getCounts();
}
