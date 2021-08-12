package com.dsfa.nc.pd.types;

import lombok.Getter;

import javax.validation.ValidationException;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName TimePoint (格式 00:00:00)
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/29
 **/
@Getter
public class TimePoint implements Serializable {
    private final int second;
    private final int minute;
    private final int hour;

    public TimePoint(int second, int minute, int hour) {
        if (second >= 60 || minute >= 60) {
            throw new ValidationException();
        }
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
        String temp = "\\d\\d:[0-5]\\d:[0-5]\\d";
        Pattern pattern = Pattern.compile(temp);
        Matcher matcher = pattern.matcher(val);
        if (!matcher.matches()) {
            throw new ValidationException();
        }
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

    @Override
    public String toString() {
        String s1 = "";
        String s2 = "";
        String s3 = "";
        s1 = "" + hour;
        if (minute < 10) {
            s2 = "0" + minute;
        } else {
            s2 = "" + minute;
        }
        if (second < 10) {
            s3 = "0" + second;
        } else {
            s3 = "" + second;
        }
        return s1 + ":" + s2 + ":" + s3;
    }
}
