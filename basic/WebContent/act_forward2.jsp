<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String url = request.getParameter("forwardPage");
String tel = "010-1234-5678";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- act_forward3.jsp로 액션 태그를 이용하여, 포워딩(tel이라는 이름의 파라미터도 가져감) -->
<jsp:forward page="act_forward3.jsp"></jsp:forward>
</body>
</html>