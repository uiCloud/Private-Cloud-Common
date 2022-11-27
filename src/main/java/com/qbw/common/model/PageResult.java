package com.qbw.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * content
 *
 * @author qiubw
 * @since 2022/7/17 17:15
 */

@Data
@AllArgsConstructor
public class PageResult<T> implements Serializable {
    private List<T> data;
    private Integer total;
}
