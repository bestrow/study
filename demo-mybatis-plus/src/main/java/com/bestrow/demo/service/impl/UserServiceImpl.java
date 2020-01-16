package com.bestrow.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bestrow.demo.dao.UserMapper;
import com.bestrow.demo.entity.User;
import com.bestrow.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}



