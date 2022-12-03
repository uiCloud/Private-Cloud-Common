package com.qbw.common.aspect.handler;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/**
 * @author qiubw
 * @description
 * @since 2022/12/1 22:57
 */
@Slf4j
public abstract class BaseErrorHandler {
    protected ErrorRequestContext getContext(Exception e, HttpServletRequest request) {
        // TODO 从请求和异常中获取需要的上下文信息，持久化到数据库中或打印日志
        return ErrorRequestContext.builder()
                .exception(e)
                .errorRequestHead(request.getHeader(""))
                .errorRequestBody(request.getParameterMap().toString())
                .build();
    }
}
