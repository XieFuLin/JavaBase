package com.xfl.base;

/**
 * Created by XFL.
 * time on 2016/11/20 0:46
 * description:测试子类与父类
 */
public class TestExtends {
    public TestExtends() {
        SuperClass superClass = new SuperClass("Super str");
        System.out.println(superClass.getStr() + "  " + superClass.getMessage());
        Subclass subclass = new Subclass("Sub str");
        System.out.println(subclass.getStr() + "  " + subclass.getMessage());
        //这里报错 ClassCastException 指类型转换出错 当前者的域小于后者的时候出现
        //  Subclass subclass1 = (Subclass) new SuperClass("Super str");
        //   System.out.println(subclass1.getStr()+"  "+subclass1.toString());
        SuperClass superClass1 = new Subclass("Sub str");
        System.out.println(superClass1.getStr() + "  " + superClass1.getMessage());
    }

    /**
     * 父类.
     */
    private class SuperClass {
        private String str;

        public SuperClass() {

        }

        public SuperClass(String str) {
            this.str = str;
            System.out.println("调用父类构造方法");
        }

        public String getStr() {
            System.out.println("调用父类getStr()方法");
            return "Super: " + str;
        }

        /**
         * 该方法只有父类实现
         *
         * @return 返回message
         */
        public String getMessage() {
            System.out.println("调用父类 getMessage()方法");
            return "Super Message";
        }


        @Override
        public String toString() {
            System.out.println("调用父类toString()方法");
            return "Super toString()";
        }
    }

    /**
     * 子类.
     */
    private class Subclass extends SuperClass {
        private String str;

        public Subclass(String str) {
            super(str);
            this.str = str;
            System.out.println("调用子类构造方法");
        }

        @Override
        public String getStr() {
            System.out.println("调用子类getStr()方法");
            return "Sub: " + str;
        }


        @Override
        public String toString() {
            System.out.println("调用子类类toString()方法");
            return "Sub toString()";
        }
    }

    public static void main(String[] args) {
        new TestExtends();
    }
}
