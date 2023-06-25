<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=getString(str) %>
<hr />
<%! // 선언문으로 멤버(변수 및 메소드)를 선언 및 정의하는 영역으로 위치에 상관없이 파일 전체에서 사용가능
String str = "JSP & Servlet";

// 문자열을 인수로 받아 null이면 "no"를, 아니면 뒤에 "_ok"를 붙여서 리턴하는 메소드
public String getString(String s) {
	if (s == null) 	return "no";
	else			return s + "_ok";
}
%>
<hr />
<% 
String str2 = null;
out.println(getString(str2));
%>
</body>
</html>