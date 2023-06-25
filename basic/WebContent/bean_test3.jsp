<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="beanTest" class="test.BeanTest" scope="page"></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
<jsp:setProperty name="beanTest" property="name" param="name" />
<jsp:setProperty name="beanTest" property="gender" param="gender" />
 -->
 <jsp:setProperty name="beanTest" property="*" />
 <!-- 자바빈의 멤버변수와 받아오는 파라미터의 개수와 이름이 동일하면 '*'로 한번에 모든 setter를 실행 -->
이름 : <jsp:getProperty name="beanTest" property="name" /><br />
성별 : <jsp:getProperty name="beanTest" property="gender" />
</body>
</html>