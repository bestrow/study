package com.libo.shiro.service;

import com.libo.shiro.mapper.UserMapper;
import com.libo.shiro.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @auther anglesang
 * @date 2018/12/11 22:19
 **/
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
