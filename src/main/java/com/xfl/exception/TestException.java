package com.xfl.exception;

/**
 * Created by XFL.
 * time on 2016/12/3 15:14
 * description:异常捕获测试
 */
public class TestException {
    public static void main(String[] args) {
        System.out.println(test1());
        System.out.println(test2());
    }

    /**
     * 出异常返回4,不出异常返回5.finally是在return之前执行的
     *
     * @return
     */
    private static String test1() {
        String str = "1";
        try {
            str = "2";
            int a = 1;
            int b = (Math.random() * 10) % 3 > 2 ? 1 : 0;
            int c = a / b;
        } catch (Exception e) {
            str = "3";
            //执行return之前会先执行finally
            return str;
        } finally {
            str = "4";
        }
        str = "5";
        return str;
    }

    /**
     * 出异常返回7,不出异常返回7.finally是在return之前执行的
     *
     * @return
     */
    private static String test2() {
        String str = "1";
        try {
            str = "2";
            int a = 1;
            int b = (Math.random() * 10) % 3 > 2 ? 1 : 0;
            int c = a / b;
        } catch (Exception e) {
            str = "3";
            //执行return之前会先执行finally
            return str = "6";
        } finally {
            str = "4";
            //finally中包含return时catch中的return不起作用了
            return str = "7";
        }
    }
}
