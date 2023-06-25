<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
request.setCharacterEncoding("utf-8");
session.setMaxInactiveInterval(1);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>영역(scope)과 속성(attribute) 테스트4</h2>
<table border="1">
<tr><th colspan="2">Application 영역에 저장한 내용들</th></tr>
<tr><th>이름</th><td><%=application.getAttribute("name") %></td></tr>
<tr><th>ID</th><td><%=application.getAttribute("uid") %></td></tr>
</table>
<hr />
<table border="1">
<tr><th colspan="2"> 영역에 저장한 내용들</th></tr>
<%
Enumeration en = session.getAttributeNames();
if (en != null) {
	while (en.hasMoreElements()) {
		String attName = (String)en.nextElement();
		String attValue = (String)session.getAttribute(attName);
		out.println("<tr><th>" + attName + "</th><td>" + attValue + "</td></tr>");
	}
} else {
	out.println("<tr><th colspan=\"2\">현재 Session 영역에 속성이 없습니다.</th></tr>");	
}
%>
</table>

<br />
<a href="attr_test5.jsp">attr_test5.jsp로 이동</a>
</body>
</html>