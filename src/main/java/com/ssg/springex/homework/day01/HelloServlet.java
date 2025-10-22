package com.ssg.springex.homework.day01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/homework/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("안녕하세요, 서블릿!");
        System.out.println("현재 시간: " + new Date());

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>안녕하세요, 서블릿!</h1>");
        out.println("<p>현재 시간: " + new Date() + "</p>");
        out.println("</body></html>");
    }
}
