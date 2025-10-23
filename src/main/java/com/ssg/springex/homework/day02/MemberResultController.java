package com.ssg.springex.homework.day02;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name="memberResultController", urlPatterns = "/homework/day02/memberResult")
public class MemberResultController extends HttpServlet {

//    /homework/day02/memberRegister에서 /homework/day02/memberResult로 보낸 post 요청을 처리
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MemberResultController.doPost");
        req.setCharacterEncoding("UTF-8");

        // 요청 메시지로부터 신규 회원정보 가져오기
        String userID = req.getParameter("user_id");
        String userPwd = req.getParameter("user_pwd");
        String gender = req.getParameter("gender");
        List<String> hobbies = Arrays.asList(req.getParameterValues("hobby"));

        // 신규 회원 정보를 MemberInfo 객체에 저장
        MemberInfo memberInfo = new MemberInfo();
        memberInfo.setId(userID);
        memberInfo.setPwd(userPwd);
        memberInfo.setGender(gender);
        memberInfo.setHobbies(hobbies);

        // 신규 회원 정보 추가 작업 수행 -> insert문 수행 결과 메시지 출력
        MemberDAO dao = MemberDAO.getInstance();
        String result = dao.registerMember(memberInfo);
        System.out.println(result);

        // insert문 수행 결과를 출력하는 result.jsp을 웹 브라우저에서 출력
        HttpSession session = req.getSession();
        session.setAttribute("result", result);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/homework/day02/result.jsp");
        dispatcher.forward(req, resp);
    }
}
