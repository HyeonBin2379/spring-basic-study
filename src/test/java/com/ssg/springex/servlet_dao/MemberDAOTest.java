package com.ssg.springex.servlet_dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberDAOTest {

    @Test
    void getInstanceTest() {
        MemberDAO dao1 = MemberDAO.getInstance();
        MemberDAO dao2 = MemberDAO.getInstance();

        System.out.println(dao1);
        System.out.println(dao2);

        Assertions.assertEquals(dao1, dao2);
    }
}