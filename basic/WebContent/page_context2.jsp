<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

String idx = request.getParameter("idx");
String val = request.getParameter("val");

String num = request.getParameter("num");
String name = request.getParameter("name");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>page_context2</h2>
idx : <%=idx %> / val : <%=val %><br />
num : <%=num %> / name : <%=name %>
<hr />
<%
pageContext.include("page_context3.jsp");
%>
</body>
</html>