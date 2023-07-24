<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
session.setAttribute("sessTest", "세션에 있는 값입니다.");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>EL Test Form</h2>
<form name="frm" action="elEx2" method="post">
이름 : <input type="text" name="uname" />
<input type="submit" value="전송" />
</form>
</body>
</html>