package com.xfl.reflect;

/**
 * Created by XFL
 * time on 2016/11/7 23:01
 * description:
 */
public class User {
    private String username;
    public User() {
        System.out.println("调用User构造方法");
    }

    public User(String username) {
        this.username = username;
        System.out.println("调用带参数User构造方法");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
