package com.ssg.springex.servlet_dao;

import com.sun.tools.javac.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MemberDAO dao = MemberDAO.getInstance();    // sql문으로 조회할 MemberDAO 객체를 생성
        List<MemberVO> memberList = dao.listMembers();  // 전체 회원정보 조회 후 조회 결과인 회원정보리스트를 반환받음
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
