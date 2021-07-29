package com.dsfa.nc.pd.learn.types;

import lombok.Getter;

/**
 * @ClassName Rate 比率 (0% - 100%)
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/29
 **/
@Getter
public class Rate {
    private final double val;

    public Rate(double val) {
        this.val = val;
    }
}
