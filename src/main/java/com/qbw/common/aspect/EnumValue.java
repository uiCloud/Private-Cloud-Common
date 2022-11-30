package com.qbw.common.aspect;

/**
 * @author qiubw
 * @description
 * @since 2022/11/29 23:34
 */
public interface EnumValue<T> {

    /**
     * 校验枚举值是否在枚举类中
     * @param value 待校验的值
     * @return
     */
    boolean existValue(T value);
}
