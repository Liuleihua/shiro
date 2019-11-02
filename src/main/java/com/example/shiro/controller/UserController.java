package com.example.shiro.controller;

import com.example.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/getUser/{userName}")
    @ResponseBody
    public String getUserByUserName(@PathVariable String userName){
        System.out.println("userController: --------");
        return userService.getUserByUserName(userName).toString();
    }

    @RequestMapping("/register")
    public String addUser(String userName, String email, String password){
        if (null == userName) {
            throw new RuntimeException("用户名不能为空！");
        }
        boolean result = userService.addUser(userName, email, password);
        if (result) {
            return "login";
        } else {
            return "register";
        }
    }
}
