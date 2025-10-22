package com.ssg.springex.servlet_dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class DBUtilTest {

    @Test
    @DisplayName("DB 연결 싱글톤 패턴 테스트")
    void getConnection() {
        Connection conn1 = DBUtil.getConnection();
        Connection conn2 = DBUtil.getConnection();

        System.out.println(conn1);
        System.out.println(conn2);

        Assertions.assertEquals(conn1, conn2);
    }
}