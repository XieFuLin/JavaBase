package com.xfl.base;

import java.text.DecimalFormat;

/**
 * Created by XFL
 * time on 2017/2/19 17:05
 * description:
 */
public class DecimalFormatSimpleDemo {

    //使用实例化对象(传递格式参数)时设置格式化模板
    public static void SimgleFormat(String pattern, double value) {
        DecimalFormat myFormat = new DecimalFormat(pattern);  // 实例化 DecimalFormat对象
        String output = myFormat.format(value);
        System.out.println(value + " " + pattern + " " + output);
    }

    //使用applyPattern()方法对数字进行格式化
    static public void UseApplyPatternMethodFormat(String pattern, double value) {
        DecimalFormat myFormat = new DecimalFormat();  // 实例化 DecimalFormat对象
        myFormat.applyPattern(pattern);       //调用applyPattern()方法对数字进行格式化
        String output = myFormat.format(value);
        System.out.println(value + " " + pattern + " " + output);
    }

    static public void main(String[] args) {
        SimgleFormat("######.###", 123456.789);   //调用静态SimgleFormat方法
        SimgleFormat("###.###", 123456.789);   //'#'不够位时任然可以正常显示
        SimgleFormat("00000000.###kg", 123456.78); //在数字后面加上单位,'0'代表不存在位补0,'#'代表不存在位不显示
        UseApplyPatternMethodFormat("#.###%", 0.789); //百分号显示
        UseApplyPatternMethodFormat("###.##", 0.789); //四舍五入
        UseApplyPatternMethodFormat("0.00\u2030", 0.789); //千分位显示

        //特殊方法对数字进行格式化
        DecimalFormat myFormat = new DecimalFormat();  // 实例化 DecimalFormat对象
        myFormat.setGroupingSize(3); //将数字以每3位进行分组
        String output = myFormat.format(12345678.12345);
        System.out.println("将数字以每3位进行分组: " + output);
        myFormat.setGroupingUsed(false); //不允许数字进行分组
        output = myFormat.format(12345678.12345);
        System.out.println("不允许数字进行分组: " + output);

    }
}