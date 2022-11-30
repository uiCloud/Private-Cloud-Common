package com.qbw.common.model;

import com.qbw.common.enums.StatusCodeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description
 * @author qiubw
 * @since 2022/7/17 13:00
 */
@Data
@NoArgsConstructor
public class WebResult implements Serializable {
  /** 响应状态码 */
  private String code;
  /** 响应信息 */
  private String message;
  /** 响应数据 */
  private Object data;
  /** 响应元信息 比如时间戳、traceId */
  private Object meta;

  /**
   * 通用的成功，无任何其他数据返回
   *
   * @return
   */
  public static WebResult success() {
    return WebResult.success(
        StatusCodeEnum.SUCCESS.getCode(), StatusCodeEnum.SUCCESS.getMessage(), null, null);
  }

  /**
   * 只带数据返回的成功
   *
   * @param data
   * @return
   */
  public static WebResult success(Object data) {
    return WebResult.success(StatusCodeEnum.SUCCESS.getCode(), data);
  }

  /**
   * 指定 code，不返回元信息的成功
   *
   * @param code 指定 code，则 message 通过 code 获取
   * @param data 有 data 时可以不返回元信息
   * @return
   */
  public static WebResult success(String code, Object data) {
    return WebResult.success(code, StatusCodeEnum.getMessageByCode(code), data, null);
  }

  /**
   * 指定 code，并返回元信息的成功
   *
   * @param code 指定 code，则 message 通过 code 获取
   * @param data
   * @param meta 有 data 时，也可以返回元信息
   * @return
   */
  public static WebResult success(String code, Object data, Object meta) {
    return WebResult.success(code, StatusCodeEnum.getMessageByCode(code), data, meta);
  }

  /**
   * 通用的失败，无任何其他数据返回
   *
   * @return
   */
  public static WebResult fail() {
    return WebResult.fail(
        StatusCodeEnum.EXCEPTION.getCode(), StatusCodeEnum.EXCEPTION.getMessage(), null);
  }

  /**
   * 只带数据返回的失败
   *
   * @param data
   * @return
   */
  public static WebResult fail(Object data) {
    return WebResult.fail(StatusCodeEnum.EXCEPTION.getCode(), data);
  }

  /**
   * 指定 code，并返回元信息的失败
   *
   * @param code 指定 code，则 message 通过 code 获取
   * @param meta
   * @return
   */
  public static WebResult fail(String code, Object meta) {
    return WebResult.fail(code, StatusCodeEnum.getMessageByCode(code), meta);
  }

  private static WebResult success(String code, String message, Object data, Object meta) {
    WebResult webResult = new WebResult();
    webResult.code = code;
    webResult.message = message;
    webResult.data = data;
    webResult.meta = meta;
    return webResult;
  }

  /**
   * @param code
   * @param message
   * @param meta
   * @return
   */
  private static WebResult fail(String code, String message, Object meta) {
    WebResult webResult = new WebResult();
    webResult.code = code;
    webResult.message = message;
    // 失败响应不需要数据
    webResult.data = null;
    webResult.meta = meta;
    return webResult;
  }
}
