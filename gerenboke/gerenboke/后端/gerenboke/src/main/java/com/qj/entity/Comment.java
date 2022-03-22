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
@Accessors(chain = true)
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 评论ID
     */
    private String id;

    /**
     * 对应的用户的昵称
     */
    private String nickname;

    /**
     * 对应的用户评论邮箱
     */
    private String email;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 评论创建时间
     */
    private LocalDateTime createTime;

    /**
     * 博客ID
     */
    private Long blogId;

    /**
     * 父级评论ID
     */
    private Long parentCommentId;

    /**
     * 是否是管理员
     */
    private Boolean adminComment;


}
