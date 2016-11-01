package com.xfl.io;

import java.io.UnsupportedEncodingException;

/**
 * Created by XFL
 * time on 2016/11/1 20:54
 * description:
 */
public class TestIo {
    public TestIo() {
    }
    public static void  main(String []args){
        System.out.println("Test Io");
        testBytes("XFL宁都");
    }
    private static void testBytes(String str){
        if (str != null){
            try {
                byte[] bytes = str.getBytes("GBK");
                for (byte aByte : bytes) {
                    System.out.print(aByte + ":");
                }
            }  catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        }
    }
}
