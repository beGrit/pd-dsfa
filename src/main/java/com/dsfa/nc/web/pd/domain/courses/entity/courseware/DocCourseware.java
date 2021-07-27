package com.dsfa.nc.web.pd.domain.courses.entity.courseware;

import lombok.Getter;

/**
 * @ClassName DocCourseware
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/23
 **/
@Getter
public class DocCourseware extends Courseware {
    /**
     * 讲义文件的url地址
     */
    private String fileAdditionUrl;
}
