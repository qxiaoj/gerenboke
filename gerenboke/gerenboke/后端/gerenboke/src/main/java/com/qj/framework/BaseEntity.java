package com.qj.framework;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true) // 开启链式编程
public class BaseEntity implements Serializable {
    // 页码数
    private Integer pageSize;
    // 每页显示数
    private Integer pageNum;
}
