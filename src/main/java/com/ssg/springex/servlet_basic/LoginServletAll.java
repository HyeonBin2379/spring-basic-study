package com.ssg.springex.servlet_basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login1")
public class LoginServletAll extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("LoginServlet init");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LoginServlet doGet() 메서드 호출");
        doHandle(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // request에 저장된 객체 데이터에 관한 인코딩 설정 -> 글자 깨짐 방지
        System.out.println("LoginServlet doPost() 메서드 호출");
        doHandle(request, response);
    }

    private void doHandle(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // 입력한 아이디, 비밀번호를 서블릿에서 처리
        String username = request.getParameter("user_id");
        System.out.println("doHandle 메서드 호출");
        String password = request.getParameter("user_pwd");
        System.out.println(username);
        System.out.println(password);
    }
}
