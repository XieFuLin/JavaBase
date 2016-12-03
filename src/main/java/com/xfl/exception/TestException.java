package com.xfl.exception;

/**
 * Created by XFL.
 * time on 2016/12/3 15:14
 * description:异常捕获测试
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
            //执行return之前会先执行finally
            System.out.println(temp);
            return temp;
        } finally {
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
