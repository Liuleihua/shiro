package com.example.shiro.controller;

import com.example.shiro.vcode.Captcha;
import com.example.shiro.vcode.GifCaptcha;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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

    @PostMapping("/login")
    @ResponseBody
    public Map<String, Object> login (String userName, String password, String vcode, Boolean rememberMe) {

        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        Map<String, String> map=new HashMap<String, String>();

        if(vcode==null||vcode==""){
            resultMap.put("status", 500);
            resultMap.put("message", "验证码不能为空！");
            return resultMap;
        }

        Session session = SecurityUtils.getSubject().getSession();
        //转化成小写字母
        vcode = vcode.toLowerCase();
        String v = (String) session.getAttribute("v_code");
        //还可以读取一次后把验证码清空，这样每次登录都必须获取验证码
        if(!vcode.equals(v)){
            resultMap.put("status", 500);
            resultMap.put("message", "验证码错误！");
            return resultMap;
        }

        UsernamePasswordToken user = new UsernamePasswordToken(userName, password);
        Subject subject = SecurityUtils.getSubject();
        if (null == subject) {
            resultMap.put("status", 400);
            resultMap.put("message", "登录失败");
        }
        try{
            subject.login(user);
            resultMap.put("status", 200);
            resultMap.put("message", "登录成功");
        }catch (Exception e){
            resultMap.put("status", 400);
            resultMap.put("message", "登录失败");
        }
        return resultMap;
    }

    @RequestMapping(value="/getGifCode",method= RequestMethod.GET)
    public void getGifCode(HttpServletResponse response, HttpServletRequest request){
        try {
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/gif");
            /**
             * gif格式动画验证码
             * 宽，高，位数。
             */
            Captcha captcha = new GifCaptcha(146,33,4);
            //输出
            HttpSession session = request.getSession(true);
            captcha.out(response.getOutputStream());
            String str = captcha.text().toLowerCase();
            //存入Session
            session.setAttribute("v_code", str);
        } catch (Exception e) {
            System.err.println("获取验证码异常："+e.getMessage());
        }
    }
}
