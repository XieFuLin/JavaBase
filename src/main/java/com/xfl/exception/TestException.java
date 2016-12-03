package com.xfl.exception;

/**
 * Created by XFL.
 * time on 2016/12/3 15:14
 * description:异常捕获测试
 * 在执行finally代码时，如果finally代码本身没有退出的语句（return或抛出异常），
 * finally执行完毕后还会返回try或catch，由try或catch执行退出指令
 */
public class TestException {
    public static void main(String[] args) {
        int result1 = test1();
        int result2 = test2();
        System.out.println("最终的结果是: " + result1);
        System.out.println("最终的结果是: " + result2);
    }

    /**
     * 出异常返回3,不出异常返回4.finally是在return之前执行的
     *
     * @return
     */
    private static int test1() {
        int temp = 1;
        try {
            temp += 1;
            int a = 1;
            int b = (Math.random() * 10) % 3 > 1 ? 1 : 0;
            int c = a / b;
        } catch (Exception e) {
            temp += 1;
            System.out.println(temp);
            /**
             * Return并不是让函数马上返回，而是return语句执行后，将把返回结果放置进函数栈中，
             * 此时函数并不是马上返回，它要执行finally语句后才真正开始返回。
             * finally语句是在try的return语句执行之后，return返回之前执行
             */
            return temp;
        } finally {
            /**
             * finally不是一定会执行的.
             * (1）try语句没有被执行到，如在try语句之前就返回了，这样finally语句就不会执行，
             * 这也说明了finally语句被执行的必要而非充分条件是：相应的try语句一定被执行到。
             *（2）在try块中有System.exit(0);这样的语句，System.exit(0);是终止Java虚拟机JVM的，
             * 连JVM都停止了，所有都结束了，当然finally语句也不会被执行到。
             */
            temp += 1;
            System.out.println(temp);
        }
        temp += 1;
        System.out.println(temp);
        return temp;
    }

    /**
     * 出异常返回4,不出异常返回3.finally是在return之前执行的
     *
     * @return
     */
    private static int test2() {
        int temp = 1;
        try {
            temp += 1;
            int a = 1;
            int b = (Math.random() * 10) % 3 > 1 ? 1 : 0;
            int c = a / b;
        } catch (Exception e) {
            temp += 1;
            //执行return之前会先执行finally
            System.out.println(temp);
            return temp;
        } finally {
            temp += 1;
            //finally中包含return时catch中的return不起作用了
            System.out.println(temp);
            return temp;
        }
    }
}
