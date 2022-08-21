package com.xuegao.test.model;

public class Users {
    private Integer uid;
    private String name;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Users{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                '}';
    }
}
