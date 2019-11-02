package com.example.shiro.service;

import com.example.shiro.entity.Role;
import com.example.shiro.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleMapper roleMapper;
    public List<Role> getRolesByUserId(String userId){
        return roleMapper.getRolesByUserId(userId);
    }
}
