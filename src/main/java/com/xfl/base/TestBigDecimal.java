package com.xfl.base;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by XFL
 * time on 2017/2/12 23:22
 * description:
 */
public class TestBigDecimal {
    public static void main(String[] args) {

        //  Double.toString()  可以将double类型转化为String
        System.out.println(new BigDecimal("0.06"));
        BigDecimal a1 = new BigDecimal("123.2562");
        BigDecimal a2 = new BigDecimal("0.75");
        System.out.println(a1.scale());
        //除
        System.out.println(a1.divide(a2, 2));
        //加
        System.out.println(a1.add(a2));
        //乘
        System.out.println(a1.multiply(a2));
        //减
        System.out.println(a1.subtract(a2));
        System.out.println(new BigDecimal("2.3").setScale(2));
        //只入不舍
        System.out.println("只入不舍" + a1.setScale(2, RoundingMode.UP));
        //只舍不入
        System.out.println("只舍不入" + a1.setScale(2, RoundingMode.DOWN));
        //四舍五入
        System.out.println("四舍五入" + a1.setScale(2, RoundingMode.HALF_UP));
        String number = "89" + "";
        DecimalFormat df2 = (DecimalFormat) DecimalFormat.getInstance();
        //强制保留两位小数,不足的补0
        df2.applyPattern("0.00");
        System.out.println(df2.format(Double.parseDouble(number)));
        double d1 = 30.29;
        double d2 = 1.01;
        System.out.println(new BigDecimal(d1));
        System.out.println(new BigDecimal(d2));
        System.out.println(new BigDecimal(d1).subtract(new BigDecimal(d2)));
        BigDecimal a3 = new BigDecimal(d1 + "");
        BigDecimal a4 = new BigDecimal(d2 + "");
        System.out.println(a3);
        System.out.println(a4);
        System.out.println(a3.subtract(a4));
        System.out.println(30.29 - 1.01);
        System.out.println(d1 - d2);

    }
}
