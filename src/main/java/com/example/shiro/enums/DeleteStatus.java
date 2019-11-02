package com.example.shiro.enums;

public enum DeleteStatus {
    Y("Y",1),
    N("N",2);

    private String name;

    private Integer value;

    DeleteStatus(String name,Integer value) {
        this.name=name;
        this.value=value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}