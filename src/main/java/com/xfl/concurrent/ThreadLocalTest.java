package com.xfl.concurrent;

/**
 * Created by XFL
 * time on 2017/5/16 23:34
 * description:ThreadLocal线程的局部变量
 * https://my.oschina.net/huangyong/blog/159489
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        Thread thread1 = new ClientThread(1000);
        thread1.start();
        Thread thread2 = new ClientThread(500);
        thread2.start();
    }
}
