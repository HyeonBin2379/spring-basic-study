package com.ssg.springex.servlet_basic;

import java.io.*;

// javax: java extension을 의미
// servlet을 사용해야 웹상에서 클래스 운용 가능
import javax.servlet.http.*;
import javax.servlet.annotation.*;

// 웹 서블릿 -> HTTP를 기반으로 동작
// was에서는 스레드 단위로 서비스를 제공: 1개의 클라이언트는 1개의 스레드를 사용
// HelloServlet 클래스는 HttpServlet 인터페이스의 doGet 메서드를 구현하여 get 메서드로 통신 시 수행할 작업을 구현
// @WebServlet: index.jsp와 연결하는 링크의 주소값을 지정
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    // a href 태그의 링크가 가리키는 웹페이지로 이동하는 것과 동일한 기능
    // 클라이언트의 요청에 관한 정보는 HttpServletRequest 객체에 저장
    // 서버 측의 응답 정보는 HttpServletResponse 객체에 저장
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}