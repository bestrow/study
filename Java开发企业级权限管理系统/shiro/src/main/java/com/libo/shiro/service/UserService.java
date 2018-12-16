package com.libo.shiro.service;

import com.libo.shiro.model.User;

/**
 * @auther anglesang
 * @date 2018/12/11 22:18
 **/
public interface UserService {

    User findByUsername(String username);
}
