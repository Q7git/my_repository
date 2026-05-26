package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 注册
    public boolean register(User user) {
       
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return false;
        }
        
        userRepository.save(user);
        return true;
    }

    // 登录
    public User login(User user) {
        User dbUser = userRepository.findByUsername(user.getUsername());
        if (dbUser != null && dbUser.getPassword().equals(user.getPassword())) {
            
            return dbUser;
        }
        
        return null;
    }
    
    //List
    public List<User> list() {
    
        return userRepository.findAll();
    }
}