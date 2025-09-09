package com.czh.lxy422;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCTest {
    /**
     * 编写JDBC程序, 查询数据
     */
    @ParameterizedTest
    @CsvSource({"1,123456,35"})
    public void testUpdate(int userId, String newPassword, int newAge)throws Exception{
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db01","root","czhnb666");
        String sql = "UPDATE user SET password = ?, age = ? WHERE id = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, newPassword); // 第一个问号对应的参数
        pstmt.setInt(2, newAge);      // 第二个问号对应的参数
        pstmt.setInt(3, userId);         // 第三个问号对应的参数

        // 执行更新
        int rowsUpdated = pstmt.executeUpdate();

        // 输出结果
        System.out.println(rowsUpdated + " row(s) updated.");

        // 关闭资源
        pstmt.close();
        connection.close();
    }
}
