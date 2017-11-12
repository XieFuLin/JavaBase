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
    private static final String url = "jdbc:mysql://localhost:3306/spring-boot";
    private static final String username = "XFL";
    private static final String password = "618033988";
    // 定义一个数据库连接
    private static Connection conn = null;
    // 定义一个用于放置数据库连接的局部线程变量（使每个线程都拥有自己的连接）
    private static ThreadLocal<Connection> connContainer = new ThreadLocal<Connection>();
    // 获取连接
    public static Connection getConnection() {
        //从ThreadLocal中获取Connection
        Connection conn = connContainer.get();
        if (conn != null) {
            return conn;
        }
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //将 connContainer放入到ThreadLocal中
            connContainer.set(conn);
        }
        return conn;
    }

    // 关闭连接
    public static void closeConnection() {
        //获取Connection
        Connection conn = connContainer.get();
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //移除Connection
            connContainer.remove();
        }
    }
}
