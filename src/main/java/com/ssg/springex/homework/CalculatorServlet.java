package com.ssg.springex.homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "calculatorServlet", value = "/homework/calculator")
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        int x = Integer.parseInt(req.getParameter("x"));
        int y = Integer.parseInt(req.getParameter("y"));
        String op = req.getParameter("op");

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String data = "<html>";
        data += "<body>";
        data += "<h1>" + calculate(x, y, op) + "</h1>";
        data += "</body>";
        data += "</html>";
        out.print(data);
    }

    private String calculate(int x, int y, String op) {
        String result = "";
        switch (op) {
            case "add":
                result = String.format("출력 : %d %s %d = %d", x, "+", y, x+y);
                break;
            case "sub":
                result = String.format("출력 : %d %s %d = %d", x, "-", y, x-y);
                break;
            case "mul":
                result = String.format("출력 : %d %s %d = %d", x, "*", y, x*y);
                break;
            case "div":
                result = String.format("출력 : %d %s %d = %d", x, "/", y, x/y);
                break;
        }
        return result;
    }
}
