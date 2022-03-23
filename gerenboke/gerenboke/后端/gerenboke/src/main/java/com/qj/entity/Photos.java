package com.qj.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

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
public class Photos implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 照片ID
     */
    private String id;

    /**
     * 照片原文件名
     */
    private String name;

    /**
     * 照片简介
     */
    private String introduction;

    /**
     * 拍摄时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime filmingTime;

    /**
     * 所属二级相册
     */
    private Integer albumsTag;

    /**
     * 照片保存的名称
     */
    private String photoSaveName;


}
