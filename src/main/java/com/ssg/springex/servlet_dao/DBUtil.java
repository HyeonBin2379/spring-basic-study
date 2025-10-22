package com.ssg.springex.servlet_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL 드라이버 로딩 성공");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            System.out.println("Connection 생성 성공");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/member_servlet_db?serverTimezone=Asia/Seoul&charEncoding=UTF-8", "root", "mysql1234");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
