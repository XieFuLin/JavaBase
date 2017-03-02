package com.xfl.proxy;

/**
 * Created by XFL
 * time on 2017/2/22 9:03
 * description:
 */
public class RealSubject implements Subject {
    @Override
    public void doSomething() {
        System.out.println("call doSomething()");
    }
}
