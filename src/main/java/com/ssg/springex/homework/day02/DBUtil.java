package com.ssg.springex.homework.day02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static Connection conn;

    static {
        try {
            // 실행 시 최초 1회만 MySQL 드라이버 로딩 -> 싱글톤
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL 드라이버 로딩 성공");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/member_servlet_db?serverTimezone=Asia/Seoul&charEncoding=UTF-8", "root", "mysql1234");
            System.out.println("Connection 생성 성공");
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
