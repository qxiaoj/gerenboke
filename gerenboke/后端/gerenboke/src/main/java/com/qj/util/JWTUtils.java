package com.qj.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.Map;

/**
 * 用于生成token，识别token等信息
 */
public class JWTUtils {
    //指定一个token过期时间（毫秒）
    private static final long EXPIRE_TIME = 7 * 24 * 60 * 60 * 1000;  //7天

    /**
     * 生成token  这里的签名由后期登录的时候，MD5以及hash散列和salt构成
     * @param map
     * @param secret
     * @return
     */
    public static String getJWTToken(Map<String, String> map, String secret) {

        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);

        JWTCreator.Builder builder = JWT.create();

        // 先设置头部信息 跳过
        // builder.withHeader();
        // 设置payload
        map.forEach((key, value) -> builder.withClaim(key, value));
        // 设置令牌过期时间
        String token = builder.withExpiresAt(date)
                .sign(Algorithm.HMAC256(secret)); // 设置私钥  该私钥由 后期登录的时候，MD5以及hash散列和salt构成
        return token;

    }


    /**
     * 在token中获取到username信息
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 判断是否过期
     */
    public static boolean isExpire(String token){
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getExpiresAt().getTime() < System.currentTimeMillis() ;
    }
}
