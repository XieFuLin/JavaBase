package com.xfl.rpc;

/**
 * Created by XFL
 * time on 2017/5/14 21:18
 * description:接口实现
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "hello:" + name;
    }
}
