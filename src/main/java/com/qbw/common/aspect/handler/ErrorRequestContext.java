package com.qbw.common.aspect.handler;

import lombok.Builder;
import lombok.Data;

/**
 * @author qiubw
 * @description
 * @since 2022/12/1 23:09
 */
@Data
@Builder
public class ErrorRequestContext {
  /**
   * 问题请求报文
   */
  private Object errorRequestHead;
  private Object errorRequestBody;
  /**
   * 异常信息
   */
  private Exception exception;
  private String exceptionClass;
  private String exceptionMessage;
  private String exceptionTrace;
  /**
   * 问题定位
   */
  private String className;
  private String methodName;
  private Integer lineNumber;
  /**
   * 响应信息
   */
  private String errorCode;
  private String errorMessage;
}
