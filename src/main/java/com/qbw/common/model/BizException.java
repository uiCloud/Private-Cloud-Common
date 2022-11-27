package com.qbw.common.model;

import com.qbw.common.enums.BizExceptionEnum;
import lombok.Getter;

/**
 * content
 *
 * @author qiubw
 * @since 2022/7/17 17:15
 */

public class BizException extends RuntimeException {
    private static final long serialVersionUID = -3378078453821393999L;

    @Getter
    private Integer code;

    @Getter
    private String message;


    public BizException(BizExceptionEnum bizExceptionEnum) {
        this(bizExceptionEnum, bizExceptionEnum.getMessage());
;    }

    public BizException(BizExceptionEnum bizExceptionEnum, String message) {
        this.code = bizExceptionEnum.getCode();
        this.message = message;
;    }
}
