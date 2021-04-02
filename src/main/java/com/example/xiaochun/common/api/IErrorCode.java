package com.example.xiaochun.common.api;

public interface IErrorCode {

    /**
     * 错误编码: -1失败;200成功
     *
     * @return 错误编码
     */
    Integer getCode();

    /**
     * 错误描述
     *
     * @return  错误藐视
     */
    String getMessage();

}
