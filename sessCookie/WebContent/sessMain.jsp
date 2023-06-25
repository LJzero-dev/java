<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="test.MemberInfo" %>
<%
response.setCharacterEncoding("utf-8");
String uid = null, name = null;
int point = 0;
boolean isLogin = false;
MemberInfo mi = (MemberInfo)session.getAttribute("loginInfo");
if (mi != null) {	// 로그인 되었으면
	isLogin = true;
	uid = mi.getUid();	name = mi.getName();	point = mi.getPoint();
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if (!isLogin) { %>
아직 로그인 전 입니다.<br />
<a href="sessLoginForm.jsp">로그인</a>
<% } else { %>
<%=uid %>(<%=name %>)님 환영합니다.<br />
현재 보유하고 있는 포인트는 <%=point %>입니다.<br />
<a href="sessLogout.jsp">로그아웃</a>
<% } %>
</body>
</html>