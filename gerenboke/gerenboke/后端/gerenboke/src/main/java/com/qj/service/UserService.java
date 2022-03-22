package com.qj.service;

import com.qj.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

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
    User getByUserName(String username);
}
