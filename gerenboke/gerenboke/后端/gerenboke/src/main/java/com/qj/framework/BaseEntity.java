package com.qj.framework;

import com.baomidou.mybatisplus.annotation.TableField;
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
    @TableField(exist = false) // 设置不让mybatis plus自动映射到数据库
    private Integer pageSize;
    // 每页显示数
    @TableField(exist = false)
    private Integer pageNum;
}
