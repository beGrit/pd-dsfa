package com.dsfa.nc.pd.lesson.service;

import javax.validation.constraints.NotNull;

/**
 * @InterfaceName CollectService
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/28
 **/
public interface IAppraiseService {
    boolean appraiseCourse(@NotNull String courseId, @NotNull String accountId, @NotNull String type);
}
