package com.ssg.springex.servlet_dao;

import java.sql.*;
import java.util.List;

import java.util.ArrayList;

public class MemberDAO {

    private static class LazyHolder {
        private static final MemberDAO memberDAO = new MemberDAO();
    }

    public static MemberDAO getInstance() {
        return LazyHolder.memberDAO;
    }

    private Statement stmt;

    private MemberDAO() {
    }

    private void connDB() throws SQLException {
        Connection conn = DBUtil.getConnection();
        this.stmt = conn.createStatement();
        System.out.println("Statement 생성 성공");
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return memberList;
    }
}
