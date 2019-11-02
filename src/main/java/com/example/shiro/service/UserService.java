package com.example.shiro.service;

import com.example.shiro.entity.User;
import com.example.shiro.mapper.UserMapper;
import com.example.shiro.utils.PasswordHelper;
import com.example.shiro.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User getUserByUserName(String userName) {
        System.out.println("userService " + userName);
        User user = userMapper.getUserByUserName(userName);
        return user;
    }

    public boolean addUser(String userName, String email, String password) {
        User u = userMapper.getUserByUserName(userName);
        if (u != null) {
            throw new RuntimeException("用户名已存在！");
        }
        User user = new User();
        user.setUserId(UUIDUtils.getUUID());
        user.setUsername(userName);
        user.setEmail(email);
        user.randomSalt();
        user.setPassword(password);
        PasswordHelper.encryptPassword(user);
        int result = userMapper.addUser(user);
        if (result > 0) {
            return true;
        }
        return false;
    }
}
