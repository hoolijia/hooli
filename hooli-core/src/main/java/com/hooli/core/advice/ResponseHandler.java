package com.hooli.core.advice;

import com.hooli.core.response.ErrorResult;
import com.hooli.core.response.Result;
import com.hooli.core.utils.JsonUtil;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author ：hooli
 * @date ：Created in 2020/9/14 4:55 下午
 * @description：统一返回值
 */
@ControllerAdvice(basePackages = "com.hooli")
public class ResponseHandler implements ResponseBodyAdvice {

    /**
     * @description：是否支持advice功能
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    /**
     * @description：处理response的具体实现
     */
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (o instanceof ErrorResult) {
            ErrorResult errorResult = (ErrorResult) o;
            return Result.fail(errorResult.getStatus(), errorResult.getMsg());
        } else if (o instanceof String) {
            return JsonUtil.object2Json(Result.success(o));
        }

        return Result.success(o);
    }
}
