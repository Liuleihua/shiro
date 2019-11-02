package com.example.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/login/{userName}/{password}")
    public String login (@PathVariable String userName, @PathVariable String password) {
        UsernamePasswordToken user = new UsernamePasswordToken(userName, password);
        Subject subject = SecurityUtils.getSubject();
        if (null == subject) {
            throw new RuntimeException("登陆异常");
        }
        try{
            subject.login(user);
        }catch (Exception e){
            e.printStackTrace();
            return "login";
        }
        return "index";
    }
}
