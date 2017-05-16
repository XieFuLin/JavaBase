package com.xfl.concurrent;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by XFL
 * time on 2017/5/16 23:43
 * description:
 */
public class DBUtil {
    // 数据库配置
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/shop";
    private static final String username = "XFL";
    private static final String password = "618033988";
    // 定义一个数据库连接
    private static Connection conn = null;

    // 获取连接
    public static Connection getConnection() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    // 关闭连接
    public static void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
