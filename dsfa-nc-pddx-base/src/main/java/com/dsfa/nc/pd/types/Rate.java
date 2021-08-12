package com.dsfa.nc.pd.types;

import lombok.Getter;

import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;

/**
 * @ClassName Rate 比率 (0% - 100%)
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/29
 **/
@Getter
public class Rate {
    private final double val;

    public Rate(@NotNull double val) {
        if (val >= 0 && val <= 1) {
            this.val = val;
        } else {
            throw new ValidationException();
        }
    }

    public Rate(@NotNull int val) {
        if (val >= 0 && val <= 100) {
            this.val = val / 100.0;
        } else {
            throw new ValidationException();
        }
    }

    public boolean equals(Rate rate) {
        if (rate.getVal() == this.getVal()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return (val * 100) + "%";
    }
}
