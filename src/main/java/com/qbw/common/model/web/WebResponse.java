package com.qbw.common.model.web;

import com.qbw.common.enums.StatusCodeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

/**
 * @description
 * @author qiubw
 * @since 2022/7/17 13:00
 */
@Data
@NoArgsConstructor
public class WebResponse implements Serializable {
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
  public static WebResponse success() {
    return WebResponse.success(
        StatusCodeEnum.SUCCESS.getCode(), StatusCodeEnum.SUCCESS.getMessage(), null, null);
  }

  /**
   * 只带数据返回的成功
   *
   * @param data
   * @return
   */
  public static WebResponse success(ResponseEntity data) {
    return WebResponse.success(StatusCodeEnum.SUCCESS.getCode(), data);
  }

  /**
   * 指定 code，不返回元信息的成功
   *
   * @param code 指定 code，则 message 通过 code 获取
   * @param data 有 data 时可以不返回元信息
   * @return
   */
  public static WebResponse success(String code, Object data) {
    return WebResponse.success(code, StatusCodeEnum.getMessageByCode(code), data, null);
  }

  /**
   * 指定 code，并返回元信息的成功
   *
   * @param code 指定 code，则 message 通过 code 获取
   * @param data
   * @param meta 有 data 时，也可以返回元信息
   * @return
   */
  public static WebResponse success(String code, Object data, Object meta) {
    return WebResponse.success(code, StatusCodeEnum.getMessageByCode(code), data, meta);
  }

  /**
   * 通用的失败，无任何其他数据返回
   *
   * @return
   */
  public static WebResponse fail() {
    return WebResponse.fail(
        StatusCodeEnum.EXCEPTION.getCode(), StatusCodeEnum.EXCEPTION.getMessage(), null);
  }

  /**
   * 只带数据返回的失败
   *
   * @param data
   * @return
   */
  public static WebResponse fail(Object data) {
    return WebResponse.fail(StatusCodeEnum.EXCEPTION.getCode(), data);
  }

  /**
   * 指定 code，并返回元信息的失败
   *
   * @param code 指定 code，则 message 通过 code 获取
   * @param meta
   * @return
   */
  public static WebResponse fail(String code, Object meta) {
    return WebResponse.fail(code, StatusCodeEnum.getMessageByCode(code), meta);
  }

  public static WebResponse success(String code, String message, Object data, Object meta) {
    WebResponse webResponse = new WebResponse();
    webResponse.code = code;
    webResponse.message = message;
    webResponse.data = data;
    webResponse.meta = meta;
    return webResponse;
  }

  /**
   * @param code
   * @param message
   * @param meta
   * @return
   */
  public static WebResponse fail(String code, String message, Object meta) {
    WebResponse webResponse = new WebResponse();
    webResponse.code = code;
    webResponse.message = message;
    // 失败响应不需要数据
    webResponse.data = null;
    webResponse.meta = meta;
    return webResponse;
  }
}
