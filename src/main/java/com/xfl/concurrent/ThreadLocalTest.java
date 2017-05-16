package com.xfl.concurrent;

/**
 * Created by XFL
 * time on 2017/5/16 23:34
 * description:ThreadLocal线程的局部变量
 * https://my.oschina.net/huangyong/blog/159489
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        //让线程1多等待一会，目的是为了让线程2和线程1拿到同一个数据库连接(同一个对象)
        Thread thread1 = new ClientThread(1500, "thread1");
        thread1.start();
        Thread thread2 = new ClientThread(500, "thread2");
        thread2.start();
    }
}
