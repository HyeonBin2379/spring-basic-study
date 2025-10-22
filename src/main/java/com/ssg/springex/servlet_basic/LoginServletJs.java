package com.ssg.springex.servlet_basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login3")
public class LoginServletJs extends HttpServlet {

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

    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doHandle 메서드 호출");
        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // 입력한 아이디, 비밀번호를 서블릿에서 처리
        String user_id = request.getParameter("user_id");
        String user_pwd = request.getParameter("user_pwd");
        String user_address = request.getParameter("user_address");

        String data = "<html>";
        data += "<body>";
        data += "<h1>" + user_id + "</h1>";
        data += "<p>" + user_pwd + "</p>";
        data += "<p>" + user_address + "</p>";
        data += "<a href='http://localhost:8080/login2.html'>로그인 화면</a>";
        data += "</body>";
        data += "</html>";
        out.print(data);
    }
}
