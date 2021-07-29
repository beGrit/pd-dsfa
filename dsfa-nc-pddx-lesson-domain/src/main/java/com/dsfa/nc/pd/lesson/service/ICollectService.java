package com.dsfa.nc.pd.lesson.service;

/**
 * @InterfaceName CollectService
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/28
 **/
public interface ICollectService {
    boolean collectCourse(String courseId, String accountId, String type);
}
