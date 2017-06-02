package com.xfl.base;

/**
 * Created by XFL
 * time on 2017/2/26 23:34
 * description:http://www.jianshu.com//p/39f91f3fba32
 */
public class Base {
    private String baseName = "base";

    static {
        System.out.println("B");
    }
    public Base() {
        callName();
    }

    public void callName() {
        System.out.println(baseName);
    }

    static class Sub extends Base {
        private String baseName = "sub";

        static {
            System.out.println("S");
        }
        public void callName() {
            System.out.println(baseName);
        }
    }

    public static void main(String[] args) {
        Base b = new Sub();
        b = new Sub();
    }
}
