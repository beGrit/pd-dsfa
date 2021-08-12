package com.dsfa.nc.pd.statistics.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName CountDto
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/26
 **/
@Data
public class CountDto implements Serializable {
    private long classCount;

    private long studentCount;

    private long teacherCount;
}
