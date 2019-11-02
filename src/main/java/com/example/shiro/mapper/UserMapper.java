package com.example.shiro.mapper;

import com.example.shiro.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User getUserByUserName(String userName);

    int addUser(User user);
}
