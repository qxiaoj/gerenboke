package com.qj.service.impl;

import com.qj.entity.User;
import com.qj.mapper.UserMapper;
import com.qj.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qxiaoj
 * @since 2022-03-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getByUserName(String username) {
        System.out.println("1222222222222222");
        User user = userMapper.getByUserName(username);
        return user;
    }
}
