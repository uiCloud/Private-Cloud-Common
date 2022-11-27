package com.qbw.common.util;

import com.qbw.common.config.SnowflakeIdWorker;
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

    private final static SnowflakeIdWorker worker = new SnowflakeIdWorker(0, 0);

    public Long generateId() {
        return new Long(worker.nextId());
    }
}
