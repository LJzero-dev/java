<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="vo.*" %>
<%
MemberInfo loginInfo = (MemberInfo)session.getAttribute("loginInfo");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<% if (loginInfo == null) { %>
<a href="loginMvc">�α���-MVC</a><br />
<a href="loginSpr">�α���-SPR</a>
<hr />
<a href="memberJoin">ȸ������</a>
<% } else { %>
<a href="logout">�α׾ƿ�</a>
<% } %>
</body>
</html>