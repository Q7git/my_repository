package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.JwtUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 注册
    @PostMapping("/register")
    public Result<?> register(@RequestBody User user) {

        boolean success = userService.register(user);

        if (success) {
            return Result.success("注册成功");
        }

        return Result.fail("用户名已存在");
    }

    // 登录
    @PostMapping("/login")
    public Result<?> login(@RequestBody User user) {

        User loginUser = userService.login(user);

        if (loginUser != null) {
            
            String token = JwtUtils.createToken(loginUser.getUsername());
            
            return Result.success(token);
        }

        return Result.fail("用户名或密码错误");
    }
    
    //List
    @GetMapping("/list")
    public Result<?> list() {
    
        return Result.success(userService.list());
    }
}