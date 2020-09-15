package com.hooli.core.response;

import com.hooli.core.enums.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：hooli
 * @date ：Created in 2020/9/14 4:58 下午
 * @description：返回结果
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result<T> {

    private Integer code;
    private String msg;
    private T data;

    /**
     * @author     ：hooli
     * @date       ：Created in 2020/9/15 10:54 上午
     * @description：成功，没有data数据
     */
    public static Result success(){
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    /**
     * @author     ：hooli
     * @date       ：Created in 2020/9/15 10:55 上午
     * @description：成功，有data数据
     */
    public static Result success(Object data){
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    /**
     * @author     ：hooli
     * @date       ：Created in 2020/9/15 10:55 上午
     * @description：失败，指定status和desc
     */
    public static Result fail(Integer status, String desc){
        Result result = new Result();
        result.setCode(status);
        result.setMsg(desc);
        return result;
    }

    /**
     * @author     ：hooli
     * @date       ：Created in 2020/9/15 10:55 上午
     * @description：失败，指定ResultCode
     */
    public static Result fail(ResultCode resultCode){
        Result result = new Result();
        result.setResultCode(resultCode);
        return result;
    }

    /**
     * 把ResultCode枚举转换为ResResult
     */
    private void setResultCode(ResultCode resultCode){
        this.code = resultCode.code();
        this.msg = resultCode.msg();
    }
}
