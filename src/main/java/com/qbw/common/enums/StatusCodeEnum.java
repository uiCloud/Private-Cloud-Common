package com.qbw.common.enums;

import lombok.Getter;

/**
 * @author qiubw
 * @description
 * @since 2022/7/17 13:00
 */
public enum StatusCodeEnum {
  /** 成功 */
  SUCCESS("200", "操作成功"),

  REQUEST_ARGUMENT_ERROR("401", "请求体中参数错误"),
  /** 异常 */
  EXCEPTION("401", "系统异常"),
  ;

  @Getter private String code;

  @Getter private String message;

  StatusCodeEnum(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public static String getMessageByCode(String code) {
    return code;
  }
}
