package com.ssg.springex.homework.day02;

import java.sql.*;

public class MemberDAO {
    // MemberDAO 싱글톤 패턴 적용
    private static class LazyHolder {
        private static final MemberDAO memberDAO = new MemberDAO();
    }
    private MemberDAO() {
    }
    public static MemberDAO getInstance() {
        return LazyHolder.memberDAO;
    }

    private Connection conn;

    private void connDB() {
        this.conn = DBUtil.getConnection();
    }

    public String registerMember(MemberInfo newMember) {
        String sql = "insert into memberInfo values(?, ?, ?, ?, sysdate())";
        int affected = 0;
        try {
            connDB();

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newMember.getId());
            pstmt.setString(2, newMember.getPwd());
            pstmt.setString(3, newMember.getGender());
            pstmt.setString(4, String.join(", ", newMember.getHobbies()));

            affected = pstmt.executeUpdate();

            conn.close();
            pstmt.close();

            // 이미 가입된 아이디가 존재하는 경우까지 고려
            return (affected > 0) ? String.format("%s님 회원가입 성공하였습니다.", newMember.getId()) : "다시 시도해주세요.";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return "다시 시도해주세요.";
        }
    }
}
