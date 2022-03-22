package com.qj.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

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
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private String id;

    /**
     * 用户登录名称
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 通过登录密码加盐生成password存入数据库
     */
    @NotBlank(message = "盐不能为空")
    private String salt;

    /**
     * 用户昵称，用于右上角显示
     */
    private String nickname;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 用户邮箱
     */
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;

    /**
     * 用户创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间（修改密码，用户昵称等操作）
     */
    private LocalDateTime updateTime;

    /**
     * 上次登录时间，在第一次注册登录时候生效
     */
    private LocalDateTime lastLoginTime;

    /**
     * 状态 1.正常 0.停用
     */
    private Integer status;

    private Integer views;

    private String content;


}
