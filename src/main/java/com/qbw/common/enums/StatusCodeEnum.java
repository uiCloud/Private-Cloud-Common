package com.qbw.common.enums;

import lombok.Getter;

/**
 * @author qiubw
 * @description
 * @since 2022/7/17 13:00
 */
public enum StatusCodeEnum {
    /**
     * 成功
     */
    SUCCESS("200", "操作成功"),

    /**
     * 发生异常
     */
    EXCEPTION("401", "发生异常"),
    ;


    private StatusCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Getter
    private String code;

    @Getter
    private String message;
}
