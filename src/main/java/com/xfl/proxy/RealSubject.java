package com.xfl.proxy;

import com.xfl.concurrent.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by XFL
 * time on 2017/2/22 9:03
 * description:
 */
public class RealSubject implements Subject {
    @Override
    public void doSomething() throws SQLException {
        Connection connection = DBUtil.getConnection();
        System.out.println("call doSomething()");
        String sql = "INSERT INTO test (test_name)\n" +
                "VALUES\n" +
                "\t(?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, "test" + (Math.random() * 100) % 2);
        pstmt.execute();
    }
}
