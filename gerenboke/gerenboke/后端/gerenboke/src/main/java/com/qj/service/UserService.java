package com.qj.service;

import com.qj.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qj.framework.R;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qxiaoj
 * @since 2022-03-22
 */
public interface UserService extends IService<User> {
    /**
     * 通过用户名查询数据库，进行对比
     * @param username
     * @return
     */
    R getByUserName(String username);

    /**
     * 登录一系列操作
     *  生成token，查询数据，更新时间，返回数据
     * @param user
     * @param response
     * @return
     */
    R login(User user, HttpServletResponse response);

    /**
     * 注册用户
     * @param user
     * @return
     */
    R register(User user);

}
