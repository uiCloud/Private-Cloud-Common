package com.qbw.common.aspect.validator;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

/**
 * @author qiubw
 * @description
 * @since 2022/12/1 22:37
 */
public class SpecificValidator implements ConstraintValidator<SpecificSelector, Object> {

  private String[] strValues;

  private int[] intValues;

  private Class<?> clz;

  @Override
  public void initialize(SpecificSelector specificSelector) {
    this.strValues = specificSelector.strValues();
    this.intValues = specificSelector.intValues();
    this.clz = specificSelector.clz();
  }

  @Override
  public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
    if (Objects.isNull(value)) {
      return true;
    }
    if (value instanceof String && StringUtils.isBlank((String) value)) {
      return true;
    }
    if (this.clz.isEnum()) {
      // 没有对应的枚举类，或者枚举类中没有枚举值
      EnumValue<String>[] enumValues = (EnumValue<String>[]) this.clz.getEnumConstants();
      if (Objects.isNull(enumValues) || enumValues.length == 0) {
        return true;
      }
      // 存在对应枚举值时返回 true
      for (EnumValue<String> enumValue : enumValues) {
        if (enumValue.existValue((String) value)) {
          return true;
        }
      }
    } else {
      if (value instanceof String) {
        for (String strValue : this.strValues) {
          if (StringUtils.equals(strValue, (String) value)) {
            return true;
          }
        }
      } else if (value instanceof Integer) {
        for (int intValue : intValues) {
          if (Objects.equals(intValue, value)) {
            return true;
          }
        }
      } else {
        // 不支持的类型
        return false;
      }
    }

    return false;
  }
}
