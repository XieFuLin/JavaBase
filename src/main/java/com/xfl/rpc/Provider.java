package com.xfl.rpc;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by XFL
 * time on 2017/5/14 21:22
 * description:生产者暴露服务
 * http://javatar.iteye.com/blog/1123915
 */
public class Provider {
    public static void export(final Object service, int port) throws Exception {
        //服务校验
        if (service == null) {
            throw new IllegalArgumentException("service must not be null");
        }
        //端口校验
        if (port <= 0 || port > 65535) {
            throw new IllegalArgumentException("Invalid port:" + port + "a valid port must between 0 and 65535");
        }
        //向操作系统注册服务
        ServerSocket serverSocket = new ServerSocket(port);
        //循环启动监听
        while (true) {
            Socket socket = serverSocket.accept();
            //开启独立的线程处理服务调用
            new ServerThread(socket, service).start();
        }
    }

    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        export(service, 1234);
    }
}
