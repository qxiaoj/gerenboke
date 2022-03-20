package com.qj.util;


import org.apache.shiro.crypto.hash.Md5Hash;

import java.util.Random;
import java.util.UUID;

public class MD5Utils {

    /**
     * 通过传入的n，也就是意思是生成多少个salt
     * 在这个过程中，我们生成
     * @param n
     * @return
     */
    public static String getSalt(int n) {
        // 生成uuid
        String uuid = UUID.randomUUID().toString();
        // 将生成的uuid转换为char数组
        char[] chars = uuid.toCharArray();
        // 可变字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            // 随机生成0 ~ 生成的uuid的长度的一个数
            char aChar = chars[new Random().nextInt(chars.length-1)];
            sb.append(aChar);
        }
        return sb.toString();
    }


    /**
     * 生成加密以后的密码   用于注册的时候，对密码进行加密；或者登录的时候，通过输入的密码和拿到数据库里面的对应用户名的salt，生成一个加密以后的secret。
     */
    public static String toMD5Password(String password, String salt) {
        Md5Hash md5Hash = new Md5Hash(password, salt, 1024);
        return md5Hash.toHex();
    }

}
