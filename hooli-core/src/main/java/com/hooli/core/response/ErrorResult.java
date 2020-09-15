package com.hooli.core.response;

import com.hooli.core.enums.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：hooli
 * @date ：Created in 2020/9/15 10:04 上午
 * @description：异常处理返回
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorResult {

    private Integer status;
    private String msg;
    private String exception;

    /**
     * @author     ：hooli
     * @date       ：Created in 2020/9/15 10:06 上午
     * @description：对异常提示语进行封装
     */
    public static ErrorResult fail(ResultCode resultCode, Throwable e, String msg) {
        ErrorResult result = ErrorResult.fail(resultCode, e);
        result.setMsg(msg);
        return result;
    }

    /**
     * @author     ：hooli
     * @date       ：Created in 2020/9/15 10:06 上午
     * @description：对异常枚举进行封装
     */
    public static ErrorResult fail(ResultCode resultCode, Throwable e) {
        ErrorResult result = new ErrorResult();
        result.setStatus(resultCode.code());
        result.setMsg(resultCode.msg());
        result.setException(e.getClass().getName());
        return result;
    }
}
