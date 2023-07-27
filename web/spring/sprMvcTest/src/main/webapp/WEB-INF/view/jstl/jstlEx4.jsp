<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:url var="tmpUrl" value="http://www.naver.com/test.html">
	<c:param name="v1" value="10" />
	<c:param name="v2" value="20" />
	<c:param name="op" value="plus" />
</c:url>
${tmpUrl}<!-- http://www.naver.com/test.html?v1=10&v2=20&op=plus -->
<hr />
<c:if test="${param.chk == 'yes'}"><!-- param.chk : 현 화면에 받아오는 값들 중 chk라는 이름의 값을 의미 -->
	<c:redirect url="jstlEx2" /><!-- 조건에 맞으면 지정한 URL로 이동 -->
</c:if>
<input type="button" value="Redirect로 이동" onclick="location.href='jstlEx4?chk=yes';" />
</body>
</html>