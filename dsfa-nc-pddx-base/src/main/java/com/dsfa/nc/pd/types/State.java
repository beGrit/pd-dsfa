package com.dsfa.nc.pd.types;

import lombok.Getter;

/**
 * @ClassName State 启用状态
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/29
 **/
@Getter
public class State {
    private final String value;
    private final String text;

    public State(String value, String text) {
        this.value = value;
        this.text = text;
    }
}
