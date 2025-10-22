package com.ssg.springex.servlet_dao;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MemberDAO dao = MemberDAO.getInstance();    // sql문으로 조회할 MemberDAO 객체를 생성
        List<MemberVO> memberList = dao.listMembers();  // 전체 회원정보 조회 후 조회 결과인 회원정보리스트를 반환받음

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("<html>\n\t<body>");
        out.print("\n\t\t<table border='1'>\n\t\t\t<tr align='center' bgcolor='lightgreen'>\n");
        out.print("\n\t\t\t\t<th>ID</th>\n\t\t\t\t<th>이름</th>\n\t\t\t\t<th>이메일</th>\n\t\t\t\t<th>가입일</th>\n\t\t\t</tr>");
        for (MemberVO memberVO : memberList) {
            String id = memberVO.getId();
            String name = memberVO.getName();
            String email = memberVO.getEmail();
            Date joinDate = memberVO.getJoinDate();

            out.printf("\n\t\t\t<tr>\n\t\t\t\t<td>%s</td>\n\t\t\t\t<td>%s</td>\n\t\t\t\t<td>%s</td>\n\t\t\t\t<td>%s</td>\n\t\t\t</tr>\n", id, name, email, joinDate);
        }
        out.print("\n\t\t</table>\n\t</body>\n</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
