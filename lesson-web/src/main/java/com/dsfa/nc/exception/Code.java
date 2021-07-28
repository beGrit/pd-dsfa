package com.dsfa.nc.exception;


import cn.hutool.core.util.ObjectUtil;
import com.dsfa.platform.sdk.common.kit.StrKit;

/**
 * @author wenjin
 */
public enum Code {

    /**
     *
     */
    NOT_LOGIN(40000,"会话超时或未登录"),
    ;

    /**
     *  状态码
     */
    private int state;
    /**
     * 消息内容
     */
    private String msg;

    Code(int state, String msg){
        this.state = state;
        this.msg = msg;
    }

    public int state(){
        return this.state;
    }

    public String msg(){
        return this.msg;
    }

    public void doThrow() {
        throw NcException.create(this);
    }

    public void hasThrow(boolean flag) {
        if (flag) {
            throw NcException.create(this);
        }
    }

    public void notBlank(Object obj) {
        hasThrow(ObjectUtil.isNull(obj) || StrKit.isBlank(obj.toString()));
    }

    public void length(int min, int max, Object obj){
        notBlank(obj);
        int len = obj.toString().length();
        hasThrow(len < min || len > max);
    }

    public void range(int min, int max, Object obj) {
        notBlank(obj);
        try {
            int v = Integer.parseInt(obj.toString());
            hasThrow(v < min || v >= max);
        } catch (NumberFormatException e) {
            hasThrow(true);
        }
    }

    @Override
    public String toString(){
        return this.msg;
    }
}
