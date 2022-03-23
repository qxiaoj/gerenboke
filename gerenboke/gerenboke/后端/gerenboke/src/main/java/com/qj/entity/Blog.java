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
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 博客ID
     */
    private String id;

    /**
     * 博客标题
     */
    private String title;

    /**
     * 博客内容
     */
    private String content;

    /**
     * 博客首页配图
     */
    private String firstPicture;

    /**
     * 博客标签（转载，原创，翻译）
     */
    private String flag;

    /**
     * 此博客浏览次数
     */
    private Integer views;

    /**
     * 是否发布
     */
    private Boolean release;

    /**
     * 是否开启评论
     */
    private Boolean commentable;

    /**
     * 是否公开
     */
    private Boolean published;

    /**
     * 是否推荐
     */
    private Boolean recommend;

    /**
     * 博客创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 博客更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 对应类型ID
     */
    private String typeId;

    /**
     * 对应用户ID
     */
    private String userId;

    /**
     * 博客描述
     */
    private String description;

    /**
     * 评论次数
     */
    private Integer commentCount;


}
