<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Request 헤더 정보</h2>
<table border="1">
<tr><td>헤더 이름</td><td>헤더 값</td></tr>
<%
Enumeration en = request.getHeaderNames();
while (en.hasMoreElements()) {
	String header = (String)en.nextElement();
	out.println("<tr>");
	out.println("<td>" + header + "</td>");
	out.println("<td>" + request.getHeader(header) + "</td>");
	out.println("</tr>");
}
%>
</table>
</body>
</html>