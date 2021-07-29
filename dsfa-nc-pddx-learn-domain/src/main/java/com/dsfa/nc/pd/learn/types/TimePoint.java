package com.dsfa.nc.pd.learn.types;

import lombok.Getter;

/**
 * @ClassName TimePoint
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/29
 **/
@Getter
public class TimePoint {
    private final int second;
    private final int minute;
    private final int hour;

    public TimePoint(int second, int minute, int hour) {
        this.second = second;
        this.minute = minute;
        this.hour = hour;
    }

    public TimePoint(int seconds) {
        this.hour = seconds % 60 % 24;
        this.minute = seconds - this.hour * 60 * 60;
        this.second = seconds - this.hour * 60 * 60 - this.minute * 60;
    }

    public TimePoint(String val) {
        String[] strs = val.split(":");
        this.second = Integer.parseInt(strs[2]);
        this.minute = Integer.parseInt(strs[1]);
        this.hour = Integer.parseInt(strs[0]);
    }

    public boolean after(TimePoint t2) {
        return this.getSeconds() > t2.getSeconds();
    }

    public boolean before(TimePoint t2) {
        return this.getSeconds() < t2.getSeconds();
    }

    public int getSeconds() {
        return this.second + this.minute * 60 + this.hour * 60 * 60;
    }
}
