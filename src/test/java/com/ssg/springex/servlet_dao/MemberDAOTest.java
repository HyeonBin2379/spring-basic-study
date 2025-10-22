package com.ssg.springex.servlet_dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberDAOTest {

    @Test
    @DisplayName("MemberDAO 싱글톤 객체 검사")
    void getInstanceTest() {
        MemberDAO dao1 = MemberDAO.getInstance();
        MemberDAO dao2 = MemberDAO.getInstance();

        System.out.println(dao1);
        System.out.println(dao2);

        Assertions.assertEquals(dao1, dao2);
    }

    @Test
    @DisplayName("전체 회원 정보를 리스트에 저장")
    void listMembersTest() {
        MemberDAO dao = MemberDAO.getInstance();
        List<MemberVO> memberList = dao.listMembers();
        Assertions.assertEquals(3, memberList.size());
    }
}