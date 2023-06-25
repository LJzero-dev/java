<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String cook = request.getHeader("cookie");
String name = "", value = "";

if (cook != null) {	// 쿠키가 있으면
	Cookie[] cookies = request.getCookies();
	for (int i = 0; i < cookies.length; i++) {	// 이름이 'name'인 쿠키를 찾아 그 쿠기의 이름과 값을 각각 name과 value에 저장한 후 루프를 빠져나옴
		if (cookies[i].getName().equals("name")) {
		name = cookies[i].getName();
		value = cookies[i].getValue();
		break;
		}
	}
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>쿠키이름 : <%=name %></h3>
<h3>쿠키 값 : <%=value %></h3>
</body>
</html>