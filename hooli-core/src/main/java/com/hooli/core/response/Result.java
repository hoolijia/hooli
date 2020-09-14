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

    // 状态
    private Integer status;
    // 状态码的描述
    private String desc;
    // 返回的数据
    private T data;

    /**
     * 成功，没有data数据
     * @return
     */
    public static Result success(){
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    /**
     * 成功，有data数据
     * @param data
     * @return
     */
    public static Result success(Object data){
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    /**
     * 失败，指定status和desc
     * @param status
     * @param desc
     * @return
     */
    public static Result fail(Integer status, String desc){
        Result result = new Result();
        result.setStatus(status);
        result.setDesc(desc);
        return result;
    }

    /**
     * 失败，指定ResultCode enum
     * @param resultCode
     * @return
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
        this.status = resultCode.code();
        this.desc = resultCode.msg();
    }
}
