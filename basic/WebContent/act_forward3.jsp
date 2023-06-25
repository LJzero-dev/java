<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>포워드된 페이지(act_forward3.jsp)</h2>
<!-- 받아온 파라미터들의 값들을 출력 -->
이름 : <%=request.getParameter("name") %>
나이 : <%=request.getParameter("age") %>
전화 : <%=request.getParameter("tel") %>
</body>
</html>