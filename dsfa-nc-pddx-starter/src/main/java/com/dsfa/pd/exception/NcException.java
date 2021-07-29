package com.dsfa.pd.exception;

import com.dsfa.platform.starter.exception.DsfException;

/**
 * @ClassName OTException
 * @Author 文进
 * @Date 2020/7/31 下午2:50
 * @Version 1.0.0
 * @Description TODO
 **/
public class NcException extends DsfException {

    public NcException(String message) {
        super(message);
    }

    public static NcException create(Code code){
        return (NcException) new NcException(code.msg()).setState(code.state());
    }
}
