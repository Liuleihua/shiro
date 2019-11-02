package com.example.shiro.handler;

import com.example.shiro.entity.Result;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DefaultExceptionHandler {
    /**
     * 无权限异常
     * @param e 异常信息
     * @return
     */
    @ExceptionHandler(value= AuthorizationException.class)
    public Result AuthorizationExceptionHandler(Exception e){
        return Result.build().fail("无权限访问："+e.getMessage());
    }
}
