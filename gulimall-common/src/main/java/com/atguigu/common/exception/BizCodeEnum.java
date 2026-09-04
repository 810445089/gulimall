package com.atguigu.common.exception;

import lombok.Getter;

@Getter
public enum BizCodeEnum {

    UNKNOWN_EXCEPTION(10000, "系统未知异常"),
    VALID_EXCEPTION(10001, "参数格式校验失败"),
    TOO_MANY_REQUEST(10002, "请求流量过大"),
    SMS_CODE_EXCEPTION(10002, "验证码获取频率太高，稍后再试"),
    PRODUCT_UP_EXCEPTION(11000, "商品上架异常"),
    USER_EXIST_EXCEPTION(15001, "用户名已存在"),
    PHONE_EXIST_EXCEPTION(15002, "手机号已存在"),
    EMAIL_EXIST_EXCEPTION(15003, "邮箱已存在"),
    NO_STOCK_EXCEPTION(21000, "库存不足"),
    LOGIN_USER_PASSWORD_ERROR(15003, "账号密码错误");

    private final int code;
    private final String Message;

    BizCodeEnum(int code, String Message) {
        this.code = code;
        this.Message = Message;
    }

}
