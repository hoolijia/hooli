package com.hooli.core.exceptions;

import com.hooli.core.enums.ResultCode;
import com.hooli.core.response.ErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author ：hooli
 * @date ：Created in 2020/9/15 10:08 上午
 * @description：全局异常处理
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * @author ：hooli
     * @date ：Created in 2020/9/15 10:09 上午
     * @description：处理运行时异常
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public ErrorResult handleThrowable(Throwable e, HttpServletRequest request) {
        ErrorResult error = ErrorResult.fail(ResultCode.ERROR_SYSTEM, e);
        log.error("URL:{}, 系统异常：", request.getRequestURI(), e);
        return error;
    }

    /**
     * @author ：hooli
     * @date ：Created in 2020/9/15 10:45 上午
     * @description：处理自定义异常
     */
    @ExceptionHandler(BusinessException.class)
    public ErrorResult handleBusinessException(BusinessException e, HttpServletRequest request) {
        ErrorResult error = ErrorResult.builder().status(e.code)
                .msg(e.msg)
                .exception(e.getClass().getName())
                .build();
        log.warn("URL:{} ,业务异常:{}", request.getRequestURI(), error);
        return error;
    }

    /**
     * @author     ：hooli
     * @date       ：Created in 2020/9/15 3:05 下午
     * @description：Assert的异常统一封装
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResult illegalArgumentException(IllegalArgumentException e, HttpServletRequest request) {
        ErrorResult error = ErrorResult.builder().status(40000)
                .msg(e.getMessage())
                .exception(e.getClass().getName())
                .build();
        log.warn("URL:{} ,业务校验异常:{}", request.getRequestURI(),e);
        return error;
    }

    /**
     * @author ：hooli
     * @date ：Created in 2020/9/15 11:39 上午
     * @description：统一异常封装
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        String msg = this.handle(e.getBindingResult().getFieldErrors());
        ErrorResult error = ErrorResult.fail(ResultCode.ERROR_PARAM_IS_INVALID, e, msg);
        log.warn("URL:{} ,参数校验异常:{}", request.getRequestURI(), msg);
        return error;
    }

    private String handle(List<FieldError> fieldErrors) {
        StringBuilder sb = new StringBuilder();
        for (FieldError obj : fieldErrors) {
            sb.append(obj.getField());
            sb.append("=[");
            sb.append(obj.getDefaultMessage());
            sb.append("],");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
