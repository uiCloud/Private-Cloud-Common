package com.qbw.common.aspect.handler;

import com.qbw.common.enums.StatusCodeEnum;
import com.qbw.common.model.web.WebResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.List;

/**
 * @author qiubw
 * @description
 * @since 2022/12/1 22:59
 */
@Slf4j
@RestControllerAdvice
public class GlobalErrorHandler extends BaseErrorHandler {

  /**
   * 参数异常，单独处理
   * 因为需要返回信息给前端
   * @param e
   * @param request
   * @return
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Object methodArgumentNotValidException(
      MethodArgumentNotValidException e, HttpServletRequest request) {
    List<ObjectError> objectErrorList = e.getBindingResult().getAllErrors();
    StringBuilder errorMessageBuilder = new StringBuilder("参数错误！");
    for (ObjectError objectError : objectErrorList) {
      FieldError fieldError = (FieldError) objectError;
      errorMessageBuilder.append(fieldError.getDefaultMessage());
      errorMessageBuilder.append(String.format("字段[%s]", fieldError.getField()));
      log.info("参数校验失败，字段[{}]异常[{}]", fieldError.getField(), fieldError.getDefaultMessage());
    }

    return WebResponse.fail(
        StatusCodeEnum.REQUEST_ARGUMENT_ERROR.getCode(), errorMessageBuilder.toString(), null);
  }

  @ExceptionHandler(SQLException.class)
  public Object sqlException(SQLException e, HttpServletRequest request) {
    return handleException(e, request);
  }

  @ExceptionHandler(SQLSyntaxErrorException.class)
  public Object sqlException(SQLSyntaxErrorException e, HttpServletRequest request) {
    return handleException(e, request);
  }

  @ExceptionHandler(RuntimeException.class)
  public Object runtimeException(RuntimeException e, HttpServletRequest request) {
    return handleException(e, request);
  }

  @ExceptionHandler(IOException.class)
  public Object ioException(IOException e, HttpServletRequest request) {
    return handleException(e, request);
  }

  @ExceptionHandler(Exception.class)
  public Object handleException(Exception e, HttpServletRequest request) {
    String uri = request.getRequestURI();
    ErrorRequestContext errorRequestContext = getContext(e, request);
    // TODO 可以持久化某个方法的异常频次、发生的时间等，便于统计
    log.info("请求路径[{}]发生异常", uri);
    log.info(
        "异常方法[{}]发生[{}]异常",
        errorRequestContext.getMethodName(),
        errorRequestContext.getExceptionClass());
    return WebResponse.fail();
  }
}
