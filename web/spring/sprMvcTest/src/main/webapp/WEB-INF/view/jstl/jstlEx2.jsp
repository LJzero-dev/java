<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>&lt;c:if&ge;</h2>
<c:if test="${10 > 20}" var="result1">
	10은 20보다 크다.<!-- 조건(test)이 거짓이므로 동작하지 않음 -->
</c:if>
result1 : ${result1}
<br>
<c:if test="${10 < 20}" var="result2">
	20은 10보다 크다.
</c:if>
result2 : ${result2}
<hr />
<h2>&lt;c:choose&gt; 사용</h2>
<!-- 
uid라는 변수에 'test3'의 값을 넣음 choose태그를 이용하여 uid의 값을 각각 'admin', 'test1', 'test2'와 비교한 후 출력
 비교하는 값이 uid 변수와 같으면 'ID : 변수값'으로 출력하고, 없으면 '변수값님 반값습니다.'라고 출력
 단, choose태그에서는 문자열의 비교를 '=='로 할 수 있음 
 -->
 <c:set var="uid" value="test3" />
<c:choose>
	<c:when test="${uid eq 'admin'}">ID : admin</c:when>
	<c:when test="${uid eq 'test1'}">ID : test1</c:when>
	<c:when test="${uid eq 'test2'}">ID : test2</c:when>
	<c:otherwise>${uid}님 반갑습니다.</c:otherwise>
</c:choose>
</body>
</html>