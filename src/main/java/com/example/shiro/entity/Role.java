package com.example.shiro.entity;

import com.example.shiro.enums.DeleteStatus;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ToString
public class Role implements Serializable {
    private String roleId;
    private String roleName;
    private String remark;
    private DeleteStatus deleteFlag;
    private String createBy;
    private LocalDateTime createTime;
    private String updateBy;
    private LocalDateTime updateTime;
    //private List<Menu> menus;

}
