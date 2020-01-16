package com.bestrow.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bestrow.demo.entity.User;
import com.bestrow.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
@Api(tags = "用户接口")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    @ApiOperation(value = "根据ID获取用户信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true)
    public User getUser(String id) {
        User user = userService.getById(id);
        return user;
    }

    @GetMapping("/getUserList")
    @ApiOperation(value = "获取用户列表")
    public List<User> getUserList() {
        return userService.list();
    }

    @GetMapping("/getUserListPage")
    @ApiOperation(value = "根据年龄条件分页查询用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页数据量", required = true),
            @ApiImplicitParam(name = "minAge", value = "最小年龄"),
            @ApiImplicitParam(name = "maxAge", value = "最大年龄")
    })
    public IPage<User> getUserListPage(Integer pageNum, Integer pageSize, Integer minAge, Integer maxAge) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        if (null != minAge) qw.lambda().ge(User::getAge, minAge);
        if (null != maxAge) qw.lambda().le(User::getAge, maxAge);
        IPage<User> page = new Page<>();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        page = userService.page(page, qw);
        return page;
    }

    @PostMapping("/saveUser")
    @ApiOperation(value = "添加用户")
    public String saveUser(User user) {
        boolean flag = userService.save(user);
        if (flag) {
            return "添加成功";
        } else {
            return "添加失败";
        }
    }

    @GetMapping("/deleteUser")
    @ApiOperation(value = "删除用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true)
    public String deleteUser(String id) {
        boolean flag = userService.removeById(id);
        if (flag) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @PostMapping("/updateUser")
    @ApiOperation(value = "更新用户信息")
    public String updateUser(User user) {
        boolean flag = userService.updateById(user);
        if (flag) {
            return "添加成功";
        } else {
            return "添加失败";
        }
    }

    @PostMapping("/saveOrUpdateUser")
    @ApiOperation(value = "新增或者更新用户信息")
    public String saveOrUpdateUser(User user) {
        //传入的实体类User中ID为null就会新增
        //实体类ID值存在,如果数据库存在ID就会更新,如果不存在就会新增
        boolean flag = userService.saveOrUpdate(user);
        if (flag) {
            return "新增或者更新用户信息成功";
        } else {
            return "新增或者更新用户信息失败";
        }
    }

    @GetMapping("/getUserListByAgeCondition")
    @ApiOperation(value = "根据年龄条件获取用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "minAge", value = "最小年龄"),
            @ApiImplicitParam(name = "maxAge", value = "最大年龄")
    })
    public List<User> getUserListByAgeCondition(Integer minAge, Integer maxAge) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        if (null != minAge) qw.lambda().ge(User::getAge, minAge);
        if (null != maxAge) qw.lambda().le(User::getAge, maxAge);
        return userService.list(qw);
    }
}
