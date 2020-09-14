package com.hooli.core.enums;

/**
 * @author ：hooli
 * @date ：Created in 2020/9/14 4:58 下午
 * @description：返回结果code
 */
public enum ResultCode {
    // 成功状态码
    SUCCESS(200, "成功"),
    // 系统500错误
    SYSTEM_ERRPR(500, "系统异常，请稍后重试"),
    // 签名验证失败
    UNAUTHORIZE(50001, "签名验证失败"),
    // 参数错误：10001-19999
    PARAM_IS_INVALID(10001, "参数无效"),
    // 用户错误：20001-29999
    USER_HAS_EXISTED(20001, "用户名已存在"),
    USER_NOT_FIND(20002, "用户名不存在"),
    ;

    private Integer code;
    private String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer code() {
        return this.code;
    }

    public String msg() {
        return this.msg;
    }
}
