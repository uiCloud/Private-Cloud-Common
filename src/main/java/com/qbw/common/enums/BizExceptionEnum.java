package com.qbw.common.enums;

import lombok.Getter;

/**
 * content
 *
 * @author qiubw
 * @since 2022/7/17 17:15
 */

public enum BizExceptionEnum {

  /** 未知的错误 */
  UNKNOWN_ERROR(-1, "未知错误"),
  JSON_PARSE_ERROR(-2, "JSON 解析异常"),
  /** common-service error */
  CREATE_CAPTCHA_IMAGE_ERROR(1, "生成图片验证码失败"),
  /** trade-service error */
  NOT_EXIST_LEDGER(10001, "交易记录不存在"),
  LEDGER_NOT_BELONG_CURRENT_USER(10002, "交易记录不属于当前用户"),
  UPDATE_LEDGER_ERROR(10003, "更新交易记录异常"),
  INSERT_LEDGER_ERROR(10004, "新增交易记录异常"),
  /** admin-service error */

  /** user-service error */

  ;

  private BizExceptionEnum(int code, String message) {
    this.code = code;
    this.message = message;
  }

  @Getter private Integer code;

  @Getter private String message;
}
