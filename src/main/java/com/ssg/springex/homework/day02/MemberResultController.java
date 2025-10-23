package com.ssg.springex.homework.day02;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="memberResultController", urlPatterns = "/homework/day02/memberResult")
public class MemberResultController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MemberResultController.doGet");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/homework/day02/result.jsp");
        dispatcher.forward(req, resp);
    }
}
