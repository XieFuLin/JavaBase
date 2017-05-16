package com.xfl.concurrent;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by XFL
 * time on 2017/5/16 23:50
 * description:
 */
public class ClientThread extends Thread {
    private int wait;

    public ClientThread(int wait) {
        this.wait = wait;
    }

    @Override
    public void run() {
        Connection connection = DBUtil.getConnection();
        try {
            //模仿耗时操作任务
            Thread.sleep(wait);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        try {
            //主要是为了验证数据库连接是否关闭，可以起到模仿数据库操作的效果
            System.out.println(connection.getNetworkTimeout());
        } catch (SQLException e) {
            System.out.println(e);
        }
        DBUtil.closeConnection();
    }
}
