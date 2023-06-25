<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
application 영역 속성<br />
이름 : <%=application.getAttribute("name") %> /
ID : <%=application.getAttribute("uid") %>
<hr />
session 영역 속성<br />
메일 : <%=session.getAttribute("mail") %>
주소 : <%=session.getAttribute("addr") %>
<hr />
request 영역 속성<br/>
req : <%=request.getAttribute("req") %>
<hr />
pageContext 영역 속성<br/>
page : <%=pageContext.getAttribute("page") %>
<hr />
</body>
</html>