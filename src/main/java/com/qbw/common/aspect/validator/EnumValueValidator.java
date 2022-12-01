package com.qbw.common.aspect.validator;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

/**
 * @author qiubw
 * @description
 * @since 2022/11/29 23:26
 */
public class EnumValueValidator implements ConstraintValidator<EnumValidate, String> {

  private Class<? extends Enum> enumClass;

  @Override
  public void initialize(EnumValidate enumValue) {
    this.enumClass = enumValue.enumClass();
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
    // 待校验的时空值，不需要校验
    if (StringUtils.isBlank(value)) {
      return true;
    }
    // TODO 是否支持除 String 以外类型枚举值的校验？
    // 没有对应的枚举类，或者枚举类中没有枚举值
    EnumValue<String>[] enumValues = (EnumValue<String>[]) enumClass.getEnumConstants();
    if (Objects.isNull(enumValues) || enumValues.length == 0) {
      return true;
    }
    // 存在对应枚举值时返回 true
    for (EnumValue<String> enumValue : enumValues) {
      if (enumValue.existValue(value)) {
        return true;
      }
    }
    // 不存在对应枚举值时返回 true
    return false;
  }
}
