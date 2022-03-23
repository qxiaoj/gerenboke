package com.qj.service.impl;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qj.entity.User;
import com.qj.framework.R;
import com.qj.mapper.UserMapper;
import com.qj.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qj.util.JWTUtils;
import com.qj.util.MD5Utils;
import com.qj.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

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

    /**
     * 注册的时候判断用户是否存在
     * @param username
     * @return
     */
    @Override
    public R getByUserName(String username) {
        User user = userMapper.getByUserName(username);
        if (user != null) {
            return R.err().put("message","该用户已存在，请重新输入用户名");
        }
        return R.ok();
    }

    /**
     * 登录生成token，然后将查询的数据返回给前端一个token，以及数据，以及更新当前的上次登录时间，显示
     * @param user
     * @param response
     * @return
     */
    @Override
    public R login(User user, HttpServletResponse response) {
        User userOne = userMapper.selectOne(new QueryWrapper<User>().eq("username", user.getUsername()));

        Assert.notNull(userOne, "用户不存在");

        if (!userOne.getPassword().equals(MD5Utils.toMD5Password(user.getPassword(),userOne.getSalt()))) {
            return R.err().put("message","密码错误");
        }

        String token = JWTUtils.getJWTToken(userOne.getUsername());

        userOne.setPassword(null);
        userOne.setSalt(null);

        // 这个时间，我应该由前端去判断，  然后重新更新时间
        // 先查询之前的数据，然后传回去，并更新时间
//        userOne.setLastLoginTime(LocalDateTime.now());
        userMapper.update(new User().setLastLoginTime(LocalDateTime.now()),new QueryWrapper<User>().eq("id", userOne.getId()));

        response.setHeader("Authorization", token);
        response.setHeader("Access-control-Expose-Headers", "Authorization");
        return R.ok().put("message","登录成功").put("user",userOne);
    }

    /**
     * 注册用户
     * @param user
     * @return
     */
    @Override
    public R register(User user) {
        // 在这里我们还要做一步操作；
        if (userMapper.getByUserName(user.getUsername()) != null) {
            return R.err().put("message","用户名重复，请重新输入");
        }

        // 生成uuid  传入了用户名和密码
        user.setId(UUIDUtils.getUuid());
        // 对密码进行加密和生成salt
        String salt = MD5Utils.getSalt(8);
        user.setSalt(salt);
        String password = MD5Utils.toMD5Password(user.getPassword(), salt);
        user.setPassword(password)
        // 设置头像默认图片地址 默认为classpath*:static/images/1.png
        .setAvatar("classpath*:static/images/1.png")
        // 设置创建时间
        .setCreateTime(LocalDateTime.now())
        // 设置默认状态 1为可用
        .setStatus(1);

        // 对加入的数据进行增加操作
        int insert = userMapper.insert(user);

        return R.ok().put("message",insert > 0 ? "注册成功!请登录" : "注册失败，请重新操作");
    }
}
