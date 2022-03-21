package com.qj.relam;

import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.qj.shiro.JWTToken;
import com.qj.util.JWTUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ShiroRealm extends AuthorizingRealm {

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {

        String token = (String) auth.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JWTUtils.getUsername(token);
        if (StringUtils.isEmpty(username)) {
            throw new AuthenticationException("token错误!");
        }

        UserAO user = userService.getUserByName(username);
        if (user == null) {
            throw new AuthenticationException("用户不存在!");
        }

//        if (Constant.DISABLE.equals(user.getEnabled())) {
//            throw new AuthenticationException("账号已被禁用!");
//        }

        try {
            if (JWTUtils.verify(token, username)) {
                return new SimpleAuthenticationInfo(token, token, getName());
            } else {
                throw new AuthenticationException("token认证失败!");
            }
        } catch (TokenExpiredException e) {
            throw new AuthenticationException("token已过期!");
        } catch (SignatureVerificationException e) {
            throw new AuthenticationException("密码不正确!");
        }

    }


    /**
     * 清除登陆用户授权信息缓存.
     */
    public void clearCached() {
        this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
    }


    /**
     * 超级管理员不做权限的判断，自动拥有所有权限
     *
     * @param principals
     * @param permission
     * @return
     */
    public static String SYSTEM_SUPER_ADMIN = "admin";

    @Override
    public boolean isPermitted(PrincipalCollection principals, String permission) {
        String username = JWTUtils.getUsername(principals.getPrimaryPrincipal().toString());
        //Constant常量文件配置:

        return SYSTEM_SUPER_ADMIN.equals(username) || super.isPermitted(principals, permission);
    }

    @Override
    public boolean hasRole(PrincipalCollection principals, String roleIdentifier) {
        String username = JWTUtils.getUsername(principals.getPrimaryPrincipal().toString());
        return SYSTEM_SUPER_ADMIN.equals(username) || super.hasRole(principals, roleIdentifier);
    }

}
