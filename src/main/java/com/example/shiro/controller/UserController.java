package com.example.shiro.controller;

import com.example.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/getUser/{userName}")
    @ResponseBody
    public String getUserByUserName(@PathVariable String userName){
        System.out.println("userController: --------");
        return userService.getUserByUserName(userName).toString();
    }

    @RequestMapping("/")
    public String userIndex() {
        return "user index";
    }

    @RequestMapping("/register/add")
    public String addUser(String userName, String email){
        boolean result = userService.addUser(userName, email);
        if (result) {
            return "login";
        } else {
            return "register";
        }
    }
}
