package com.qj.shiro;

import org.apache.shiro.authc.AuthenticationToken;


/**
 * JWTToken 替换 Shiro 原生 Token
 */
public class JWTToken implements AuthenticationToken {

    // 密钥
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
