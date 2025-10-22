package com.ssg.springex;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="memberRegister", value="/register")
public class MemberRegister extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String userID = req.getParameter("user_id");
        String userPwd = req.getParameter("user_pwd");
        String gender = req.getParameter("gender");
        String[] hobbies = req.getParameterValues("hobby");

        resp.setContentType(("text/html; charset=UTF-8"));
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<p> 아이디 : " + userID + "</p>");
        out.println("<p> 비밀번호 : " + userPwd + "</p>");
        out.println("<p> 성별 : " + gender + "</p>");
        out.println("<p> 취미 : " + String.join(" ", hobbies) + "</p>");
        out.println("</body></html>");
    }
}
