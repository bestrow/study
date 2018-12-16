package com.libo.springsecurity;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @auther anglesang
 * @date 2018/12/8 17:23
 **/
public class MyPasswordEncoder implements PasswordEncoder {

    private final static String SALT = "123456";

    /**
     * 加密方法
     * 对原始密码进行加密
     *
     * @param rawPassword
     * @return
     */
    @Override
    public String encode(CharSequence rawPassword) {
        Md5PasswordEncoder encoder = new Md5PasswordEncoder();
        return encoder.encodePassword(rawPassword.toString(), SALT);
    }

    /**
     * 匹配方法
     * 拿原始密码和加密后的密码进行匹配
     *
     * @param rawPassword
     * @param encodedPassword
     * @return
     */
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        Md5PasswordEncoder encoder = new Md5PasswordEncoder();
        return encoder.isPasswordValid(encodedPassword, rawPassword.toString(), SALT);
    }
}
