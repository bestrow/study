package com.libo.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringsecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringsecurityApplication.class, args);
    }

    @RequestMapping("/")
    public String home() {
        return "hello spring boot";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello world";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/roleAuth")
    public String role() {
        return "hello world";
    }


    @PreAuthorize("#id<10 or principal.username.equals(#username) and #user.username.equals('abc')") // 参数传入检查
    @PostAuthorize("returnObject%2==0") // 参数返回检查
    @RequestMapping("/test")
    public Integer test(Integer id, String username, User user) {
        return id;
    }

    @PreFilter("filterObject%2==0") // 集合参数传入检查
    @PostFilter("filterObject%4==0") // 集合参数返回检查
    @RequestMapping("/test2")
    public List<Integer> test2(List<Integer> idList) {
        return idList;
    }
}
