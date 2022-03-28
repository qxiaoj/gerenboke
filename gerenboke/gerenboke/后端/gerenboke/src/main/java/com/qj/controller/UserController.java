package com.qj.controller;


import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qj.entity.User;
import com.qj.framework.R;
import com.qj.service.UserService;
import com.qj.util.JWTUtils;
import com.qj.util.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author qxiaoj
 * @since 2022-03-22
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录，生成token，然后进行验证
     * @param
     * @param
     * @return
     */
    @PostMapping("/login")
    public R login(@RequestBody User user, HttpServletResponse response){
        return userService.login(user,response);
    }

    /**
     * 未登陆认证
     *
     * @param message
     * @return
     */
    @RequestMapping(value = "/noLogin", method = {RequestMethod.GET, RequestMethod.POST})
    public Object noLogin(String message) {
        return R.err().put("message", message != null ? message : "用户登录信息已失效，请重新登录后再试。");

    }

    /**
          * 退出登录
          *
          * @param
          * @param
          * @return
          */
    @RequestMapping(value = "/logout", method = {RequestMethod.GET, RequestMethod.POST})
    public R logout() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return R.ok().put("message","退出登录成功");
    }

    @RequestMapping(value = "/register", method = { RequestMethod.POST})
    public R register(@RequestBody User user) {
        return userService.register(user);
    }

    /**
     * 判断是否存在此用户
     * @param username
     * @return
     */
    @RequestMapping(value = "/findUserName", method = { RequestMethod.GET})
    public R findUserName(String username) {
        return userService.getByUserName(username);
    }


    /**
     * 登陆以后，对齐资料完成度，进行判断，并完善资料，前端还要添加一个修改头像的功能
     * @param user
     * @return
     */
    @RequestMapping(value = "/findUserName", method = { RequestMethod.POST})
    public R modifyData(@RequestBody  User user) {

        return R.ok();
    }




}

