package com.hooli.core.enums;

/**
 * @author ：hooli
 * @date ：Created in 2020/9/14 4:58 下午
 * @description：返回结果code
 */
public enum ResultCode {
    /* 成功状态码 */
    SUCCESS(200, "成功"),

    /* 系统500错误*/
    ERROR_SYSTEM(50000, "系统异常，请稍后重试"),
    ERROR_UNAUTHORIZE(50500, "签名验证失败"),

    /* 参数错误：50101-50199 */
    ERROR_PARAM_IS_INVALID(50101, "参数无效"),

    /* 用户错误: 50601-50699 */
    ERROR_USER_HAS_EXISTED(50601, "用户名已存在"),
    ERROR_USER_NOT_FIND(50602, "用户名不存在"),
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
