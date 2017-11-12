package com.xfl.rpc;

import java.lang.reflect.Proxy;

/**
 * Created by XFL
 * time on 2017/5/14 22:12
 * description:消费者，调用服务
 * http://javatar.iteye.com/blog/1123915
 */
public class Consumer {
    public static <T> T refer(final Class<T> interfaceClass,
                              final String host, final int port) throws Exception {
        if (interfaceClass == null)
            throw new IllegalArgumentException("Interface class == null");
        if (!interfaceClass.isInterface())
            throw new IllegalArgumentException("The " + interfaceClass.getName() + " must be interface class!");
        if (host == null || host.length() == 0)
            throw new IllegalArgumentException("Host == null!");
        if (port <= 0 || port > 65535)
            throw new IllegalArgumentException("Invalid port " + port);
        System.out.println("Get remote service " + interfaceClass.getName() + " from server " + host + ":" + port);
        //生成动态代理对象
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass}, new RpcProxyHandler(host, port));
    }

    public static void main(String[] args) throws Exception {
        //此处返回的是动态代理对象
        HelloService service = refer(HelloService.class, "127.0.0.1", 1234);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            //调用hello方法时会调用代理对象的invoke方法
            String hello = service.hello("World" + i);
            System.out.println(hello);
            Thread.sleep(1000);
        }
    }
}
