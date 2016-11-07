package com.xfl.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by XFL
 * time on 2016/11/7 23:00
 * description:
 */
public class Reflect {
    public static void main(String[] args) throws Exception {
        // 加载类
        Class<?> cls = Class.forName("com.xfl.reflect.User");
        // 查看类的构造方法
        Constructor<?> cs[] = cls.getConstructors();
        System.out.println("构造方法个数:" + cs.length);
        // 构造方法 传入参数
        User user2 = (User) cs[1].newInstance("myname");
        System.out.println(user2.getUsername());
        // 获取指的构造函数
        Constructor<?> c = cls.getConstructor(String.class);
        User user3 = (User) c.newInstance("myname");
        System.out.println(user3.getUsername());
        Constructor<?> c2 = cls.getConstructor();
        User user4 = (User) c2.newInstance();
        System.out.println(user4.getUsername());
        System.out.println("-------------");

        // getDeclared获得所有属性
        Field fields[] = cls.getDeclaredFields();
        System.out.println(fields.length);
        for (Field f : fields) {
            System.out.println(f.getName());
        }
        // Field field = cls.getField("username");
        Field field = cls.getDeclaredField("username");

        // 使私有属性可访问
        field.setAccessible(true);

        System.out.println(field.get(user2));

        // obj.username
        // 获取方法
        Method method = cls.getMethod("setUsername", String.class);
        method.invoke(user2, "XFL");

        Method method2 = cls.getMethod("getUsername");
        System.out.println(method2.invoke(user2));

        Method method3 = cls.getDeclaredMethod("getUsername");
        method3.setAccessible(true);
        System.out.println("私有get:" + method3.invoke(user2));
    }
}
