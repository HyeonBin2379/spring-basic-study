<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2025-10-22
  Time: 오후 4:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- setAttribute() 메서드로 등록한 값을 JSP 파일 내부에서 사용 --%>
<%
    String result = (String)session.getAttribute("result");
    session.removeAttribute("result");
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입 완료</title>
</head>
<body>
    <%--  결과 메시지 출력  --%>
    <p><%=result%></p>
    <a href="memberRegister">첫화면으로</a>
</body>
</html>
