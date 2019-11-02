package com.example.shiro.mapper;

import com.example.shiro.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {


    List<Role> getRolesByUserId(String userId);
}
