package com.qj.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author qxiaoj
 * @since 2022-03-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true) // 开启链式编程
public class Albums implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 相册ID
     */
    private String id;

    /**
     * 相册名称
     */
    private String name;

    /**
     * 相册封面
     */
    private String cover;

    /**
     * 相册简介
     */
    private String introduction;

    /**
     * 修改时间
     */
    private LocalDateTime createTime;

    /**
     * 相册级别
     */
    private Integer albumLevel;

    /**
     * 所属一级相册
     */
    private Integer albumType;


}
