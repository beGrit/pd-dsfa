package com.dsfa.nc.pd.lesson.entity.courseware;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName Courseware
 * @Description TODO 课件
 * @Author pocky
 * @Date 2021/7/23
 **/
@Getter
@Setter
public class Courseware {
    /**
     * 实体唯一标识
     */
    private String id;

    /**
     * 编号
     */
    private String rCode;

    /**
     * 课件名称
     */
    private String title;

    /**
     * 课件类型
     */
    private String rType;

    /**
     * 备注
     */
    private String remark;

    /**
     * 课件状态
     */
    private boolean state;
}
