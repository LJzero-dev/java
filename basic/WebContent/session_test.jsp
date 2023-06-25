<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
session.setMaxInactiveInterval(10);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Session_Test</h2>
isNew() : <%=session.isNew() %><br />
세션 생성시간 : <%=session.getCreationTime() %> <br />
최종 접근시간 : <%=session.getLastAccessedTime() %> <br />
세션 ID :<%=session.getId() %> <br />
세션 유지시간 :<%=session.getMaxInactiveInterval() %> <br />
</body>
</html>