package com.qbw.common.util;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * content
 *
 * @author qiubw
 * @since 2022/7/17 17:15
 */
@Component
public class IdGenerator implements Serializable {

  public Long getId() {
    return SnowflakeIdWorker.generateId();
  }

  public String getIdWith(String prefix) {
    StringBuilder stringBuilder = new StringBuilder(prefix);
    stringBuilder.append(SnowflakeIdWorker.generateId());
    return stringBuilder.toString();
  }
}
