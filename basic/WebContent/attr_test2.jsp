<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String name = request.getParameter("name");
String uid = request.getParameter("uid");

application.setAttribute("name", name);
application.setAttribute("uid", uid);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>영역(scop)과 속성(attribute) 테스트2</h2>
<h3><%=name %>님 반갑습니다.<br /><%=name %>님의 아이디는<%=uid %>입니다.</h3>
<form name="frm" action="attr_test3.jsp" method="post">
<table border="1">
<tr><th colspan="2">Session 영역에 저장할 내용들</th></tr>
<tr><td>메일</td><td><input type="text" name="mail" /></td></tr>
<tr><td>주소</td><td><input type="text" name="addr" /></td></tr>
<tr><th colspan="2"><input type="submit" value="전송"></th></tr>
</table>
</form>
</body>
</html>