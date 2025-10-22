package com.ssg.springex.servlet_dao;

import java.sql.*;
import java.util.List;

import java.util.ArrayList;

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

    private void disconnect() throws SQLException {
        this.conn.close();
        this.stmt.close();
    }

    public List<MemberVO> listMembers() {
        List<MemberVO> memberList = new ArrayList<>();
        try {
            connDB();
            String sql = "select * from members";
            try (ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    String id = rs.getString("userId");
                    String pwd = rs.getString("userPwd");
                    String name = rs.getString("userName");
                    String email = rs.getString("userEmail");
                    Date joinDate = rs.getDate("joinDate");

                    MemberVO member = new MemberVO();
                    member.setId(id);
                    member.setPwd(pwd);
                    member.setName(name);
                    member.setEmail(email);
                    member.setJoinDate(joinDate);

                    memberList.add(member);
                }
            }
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return memberList;
    }
}
