package com.ssg.springex.homework.day02;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="register", urlPatterns="/homework/day02/memberRegister")
public class MemberRegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 웹 브라우저 주소창에 /homework/day02/memberRegister 입력하거나, 링크 클릭 시 회원가입 페이지 출력
        System.out.println("MemberRegisterController.doGet");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/homework/day02/memberRegister.html");
        dispatcher.forward(req, resp);
    }
}
