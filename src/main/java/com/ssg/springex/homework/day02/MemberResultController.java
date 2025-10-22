package com.ssg.springex.homework.day02;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name="memberResultController", urlPatterns = "/homework/day02/memberResult")
public class MemberResultController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String userID = req.getParameter("user_id");
        String userPwd = req.getParameter("user_pwd");
        String gender = req.getParameter("gender");
        List<String> hobbies = Arrays.asList(req.getParameterValues("hobby"));

        MemberDAO dao = MemberDAO.getInstance();
        MemberInfo memberInfo = new MemberInfo();
        memberInfo.setId(userID);
        memberInfo.setPwd(userPwd);
        memberInfo.setGender(gender);
        memberInfo.setHobbies(hobbies);

        String result = dao.registerMember(memberInfo);
        req.setAttribute("result", result);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/homework/day02/result.jsp");
        dispatcher.forward(req, resp);
    }
}
