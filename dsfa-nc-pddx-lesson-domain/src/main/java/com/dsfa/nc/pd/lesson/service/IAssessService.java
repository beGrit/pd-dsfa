package com.dsfa.nc.pd.lesson.service;

import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;

/**
 * @InterfaceName CollectService
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/28
 **/
public interface IAssessService {
    /**
     * 评价功能
     * @param courseId 课程id
     * @param accountId 用户id
     * @param type 评价类型
     * @return 评价是否成功
     */
    @Transactional
    boolean assessCourse(@NotNull String courseId, @NotNull String accountId, @NotNull String type);
}
