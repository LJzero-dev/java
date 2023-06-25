<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>page_context1</h2>
<%
// 현 파일 실행시 'page_context1.jsp?idx=111&val=abcd'로 실행시킴
pageContext.forward("page_context2.jsp?num=123&name=test");
/*
지정한 파일로 바로 이동함(sendRedirect()와 비슷)
단, forward()로 이동하면 현재 파일이 가지는 request와 response 객체가
같이 이동되어 이동하는 파일에서 두 객체를 사용할 수 있음 
forward()로 이동하면 url이 변하지 않음
*/
%>
</body>
</html>