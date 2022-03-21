package com.qj.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * 用于生成token，识别token,校验等信息
 */
@ConfigurationProperties(prefix = "jwt")
@Component
public class JWTUtils {
    //指定一个token过期时间（毫秒）
    private static String EXPIRE_TIME;  //7天
    // jwt加解密的私钥使用配置的字符串而不使用用户登录密码的好处是防止用户密码被其他人修改后，用户操作系统此时再去校验token会发生token解析对不上的情况。
    private static String SECRET;

    /**
     * 生成token  私钥，通过前端登录时候传入的
     * @param map
     * @return
     */
    public static String getJWTToken(Map<String, String> map) {
        // 从当前创建时间开始，7天过期时间
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);

        JWTCreator.Builder builder = JWT.create();

        // 先设置头部信息 跳过
        // builder.withHeader();
        // 设置payload
        map.forEach((key, value) -> builder.withClaim(key, value));
        // 设置令牌过期时间
        String token = builder.withExpiresAt(date)
                .sign(Algorithm.HMAC256(SECRET)); // 设置私钥  该私钥由 后期登录的时候，MD5以及hash散列和salt构成
        return token;

    }

    /**
     * 检验token是否正确
     * @return
     */
    public static boolean verify(String token, String username) {
        try {
            //根据密码生成JWT效验器
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .build();
            //效验TOKEN
            verifier.verify(token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
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
