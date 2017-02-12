package com.xfl.base;

import java.math.BigDecimal;

/**
 * Created by XFL
 * time on 2017/2/12 23:22
 * description:
 */
public class TestBigDecimal {
    public static void main(String[] args) {
        System.out.println(0.06 + 0.01);
        System.out.println(1.0 - 0.42);
        System.out.println(4.015 * 100);
        System.out.println(303.1 / 1000);
        System.out.println(new BigDecimal("0.06"));
    }
}
