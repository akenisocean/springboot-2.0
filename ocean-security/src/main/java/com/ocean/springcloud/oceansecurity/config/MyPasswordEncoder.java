package com.ocean.springcloud.oceansecurity.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author: chao
 * @description: 自定密码加密方式
 * @create: 2020-05-06 23:30
 */
@Component
public class MyPasswordEncoder implements PasswordEncoder {

    @Resource
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public String encode(CharSequence charSequence) {
        return bCryptPasswordEncoder.encode(charSequence);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
    }
}