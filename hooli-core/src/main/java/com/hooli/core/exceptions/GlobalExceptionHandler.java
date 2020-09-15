package com.hooli.core.exceptions;

import com.hooli.core.enums.ResultCode;
import com.hooli.core.response.ErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：hooli
 * @date ：Created in 2020/9/15 10:08 上午
 * @description：全局异常处理
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * @author     ：hooli
     * @date       ：Created in 2020/9/15 10:09 上午
     * @description：处理运行时异常
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public ErrorResult handleThrowable(Throwable e, HttpServletRequest request) {
        ErrorResult error = ErrorResult.fail(ResultCode.ERROR_SYSTEM, e);
        log.error("URL:{}, 系统异常：", request.getRequestURI(), e);
        return error;
    }
}
