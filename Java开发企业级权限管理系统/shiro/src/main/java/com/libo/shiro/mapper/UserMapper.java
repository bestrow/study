package com.libo.shiro.mapper;

import com.libo.shiro.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @auther anglesang
 * @date 2018/12/11 22:15
 **/
@Mapper
public interface UserMapper {

    User findByUsername(@Param("username") String username);
}
