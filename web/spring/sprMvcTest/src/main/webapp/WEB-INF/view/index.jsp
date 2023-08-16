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
<a href="loginMvc">로그인-MVC</a><br />
<a href="loginSpr">로그인-SPR</a>
<hr />
<a href="memberJoin">회원가입</a>
<% } else { %>
<a href="logout">로그아웃</a>
<hr />
<a href="memberUp">정보수정</a>
<hr />
<a href="schedule">일정관리</a>
<% } %>
<hr />
<a href="jstlIndex">JSTL Index Test</a>
<hr />
<a href="bbsFormIn">파일업로드</a>
<hr />
<a href="freeList">자유 게시판</a>
<hr />
<a href="jsonIndex">JSON</a>
<hr />
<a href="vueIndex">Vue.js</a>
</body>
</html>