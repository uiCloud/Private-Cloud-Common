package com.qbw.common.model;

import com.qbw.common.enums.StatusCodeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description
 *
 * @author qiubw
 * @since 2022/7/17 13:00
 */
@Data
@NoArgsConstructor
public class WebResult implements Serializable {
  private String status;
  private String message;
  private Object data;

  private static WebResult success(String status, String message, Object data) {
    WebResult webResult = new WebResult();
    webResult.status = status;
    webResult.message = message;
    webResult.data = data;
    return webResult;
  }

  public static WebResult success(String status, Object data) {
    return WebResult.success(status, StatusCodeEnum.SUCCESS.getMessage(), data);
  }

  public static WebResult success(Object data) {
    return WebResult.success(StatusCodeEnum.SUCCESS.getCode(), data);
  }

  public static WebResult success() {
    return WebResult.success(StatusCodeEnum.SUCCESS.getCode(), StatusCodeEnum.SUCCESS.getMessage());
  }

  public static WebResult fail(String message) {
    WebResult webResult = new WebResult();
    webResult.status = StatusCodeEnum.EXCEPTION.getCode();
    webResult.message = message;
    webResult.data = null;
    return webResult;
  }
}
