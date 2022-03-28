package com.qj.entity;

import java.io.Serializable;

import com.qj.framework.BaseEntity;
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
@Accessors(chain = true)
public class Type extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 类型ID
     */
    private String id;

    /**
     * 类型名称
     */
    private String typeName;


}
