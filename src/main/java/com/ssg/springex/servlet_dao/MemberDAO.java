package com.ssg.springex.servlet_dao;

import com.sun.tools.javac.util.List;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MemberDAO {

    private static class LazyHolder {
        private static final MemberDAO memberDAO = new MemberDAO();
    }

    private Connection conn;
    private Statement stmt;

    public static MemberDAO getInstance() {
        return LazyHolder.memberDAO;
    }

    private MemberDAO() {
        connDB();
    }

    private void connDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL 드라이버 로딩 성공");

            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/member_servlet_db?serverTimezone=Asia/Seoul&charEncoding=UTF-8", "root", "mysql1234");
            System.out.println("Connection 생성 성공");

            this.stmt = conn.createStatement();
            System.out.println("Statement 생성 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버가 존재하지 않습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<MemberVO> listMembers() {
        return null;
    }
}
