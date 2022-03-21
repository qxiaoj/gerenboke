package com.qj.controller;



import com.hxkg.datafusion.common.jwt.JWTUtil;
import com.hxkg.datafusion.entity.customized.UserAO;
import com.hxkg.datafusion.entity.customized.VUserPrivilegeAO;
import com.hxkg.datafusion.service.IUserService;
import com.hxkg.datafusion.service.IVUserPrivilegeService;
import com.hxkg.datafusion.util.*;
import com.qj.framework.R;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class LoginController {
    private static Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Resource
    private IUserService userService;

    @Resource
    private IVUserPrivilegeService vUserPrivilegeService;


    /**
     * 未登陆认证
     *
     * @param message
     * @return
     */
    @RequestMapping(value = "noLogin", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Object noLogin(String message) {
        ServiceResult<String> genResult = ServiceResultHelper.genResult(false, Constant.NO_AUTHENTICATION, StringUtils.isNotEmpty(message) ? message : "用户登录信息已失效，请重新登录后再试。", null);
        return R.err();
    }

    /**
     * 未授权
     *
     * @return
     */
    @RequestMapping(value = "unauthorized", method = {RequestMethod.GET, RequestMethod.POST})
    public Object unauthorized() {
        return ServiceResultHelper.genResult(false, Constant.ErrorCode.PERMISSION_DENIED_CODE,
                Constant.ErrorCode.PERMISSION_DENIED_MSG, null);
    }

    /**
     * 登录操作
     *
     * @param username
     * @param password
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "doLogin", method = {RequestMethod.GET, RequestMethod.POST})
    public Object doLogin(String username, String password, Boolean rememberMe, HttpServletRequest request, HttpServletResponse response) {
        ServiceResult<UserAO> genResult;
        // 获取盐值
        String salt;
        UserAO loginUser = userService.getUserByName(username);
        if (loginUser == null) {
            genResult = ServiceResultHelper.genResult(false, Constant.ErrorCode.USER_NOT_EXIST_ERROR, Constant.ErrorCode.USER_NOT_EXIST_ERROR_MSG, null);
            return genResult;
        }
        if (Constant.DISABLE.equals(loginUser.getEnabled())) {
            genResult = ServiceResultHelper.genResult(false, Constant.ErrorCode.USER_DISABLE_ERROR, Constant.ErrorCode.USER_DISABLE_ERROR_MSG, null);
            return genResult;
        }
        salt = loginUser.getSalt();
        password = MD5Util.MD5Encode(password + salt);
        UserAO user = userService.getUserByNameAndPwd(username, password);
        if (user != null) {
            genResult = ServiceResultHelper.genResult(true, Constant.SUCCESS, "登录成功", user);
            //获取权限
            List<VUserPrivilegeAO> userPrivileges = vUserPrivilegeService.queryPrivilegeByUserName(username);
            user.setPrivileges(userPrivileges);
            //更新登录信息
            user.setLastLoginTime(DateTimeUtil.format(new Date(), DateTimeUtil.YEAR_MONTH_DAY_HOUR_MINUTE_SECOND));
            user.setLastLoginIp(IPUtil.getClientIp(request));
            userService.saveOrUpdate(user);
            genResult.setAdditionalProperties("token", JWTUtil.sign(username, user.getId()));
        } else {
            genResult = ServiceResultHelper.genResult(false, Constant.ErrorCode.PASSWORD_ERROR, Constant.ErrorCode.PASSWORD_ERROR_MSG, null);
        }
        return genResult;
    }

    /**
     * 退出登录
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "logout", method = {RequestMethod.GET, RequestMethod.POST})
    public Object logout(HttpServletRequest request, HttpServletResponse response) {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        CookieUtil cookieUtil = new CookieUtil(request, response, 0);
        cookieUtil.deleteCookie(Constant.SESSION_CURRENT_USER);
        cookieUtil.deleteCookie("JSESSIONID");
        ServiceResult<Object> ret = new ServiceResult<Object>();
        ret.setMsg("退出登录成功");
        ret.setCode(Constant.SUCCESS);
        ret.setData(null);
        ret.setSucceed(true);
        return ret;
    }
}
