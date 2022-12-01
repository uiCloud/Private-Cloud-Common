package com.qbw.common.aspect.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author qiubw
 * @description
 * @since 2022/12/1 22:36
 */
@Target({
  ElementType.FIELD,
  ElementType.METHOD,
  ElementType.ANNOTATION_TYPE,
  ElementType.CONSTRUCTOR,
  ElementType.PARAMETER
})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {SpecificValidator.class})
@Documented
public @interface SpecificSelector {
  String message() default "必须为指定值";

  String[] strValues() default {};

  int[] intValues() default {};

  // 使用指定枚举
  // 1. 使用属性命名 code
  // 2. 枚举上使用
  Class<?> clz() default Class.class;

  // 分组
  Class<?>[] groups() default {};

  // 负载
  Class<? extends Payload>[] payload() default {};
}
