package com.hooli.core.exceptions;

import com.hooli.core.enums.ResultCode;

/**
 * @author ：hooli
 * @date ：Created in 2020/9/15 10:43 上午
 * @description：自定义异常
 */
public class BusinessException extends RuntimeException {

    protected Integer code;
    protected String msg;

    public BusinessException(ResultCode resultCode) {
        this.code = resultCode.code();
        this.msg = resultCode.msg();
    }
}
