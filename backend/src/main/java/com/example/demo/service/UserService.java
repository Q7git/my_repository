package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 注册
    public String register(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return "用户已存在";
        }
        userRepository.save(user);
        return "注册成功";
    }

    // 登录
    public String login(User user) {
        User dbUser = userRepository.findByUsername(user.getUsername());
        if (dbUser != null && dbUser.getPassword().equals(user.getPassword())) {
            return "登录成功";
        }
        return "用户名或密码错误";
    }
}