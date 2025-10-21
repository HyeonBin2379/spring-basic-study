package com.ssg.springex;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("LoginServlet init");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // request에 저장된 객체 데이터에 관한 인코딩 설정 -> 글자 깨짐 방지
        request.setCharacterEncoding("UTF-8");

        // 입력한 아이디, 비밀번호를 서블릿에서 처리
        String username = request.getParameter("user_id");
        String password = request.getParameter("user_pwd");

        System.out.println(username);
        System.out.println(password);

        response.setContentType(("text/html; charset=UTF-8"));
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> 아이디 : " + username + "</h1>");
        out.println("<h1> 비밀번호 : " + password + "</h1>");
        out.println("</body></html>");
    }
}
