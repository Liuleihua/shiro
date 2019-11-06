package com.example.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public ModelAndView index () {
        Session session = SecurityUtils.getSubject().getSession();
        String userName = (String) session.getAttribute("user_name");
        ModelAndView md = new ModelAndView();
        md.addObject("user_name", userName);
        md.setViewName("index");
        return md;
    }
}
