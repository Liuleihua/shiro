package com.example.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/page")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("/login")
    public String login (String userName, String password) {
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
