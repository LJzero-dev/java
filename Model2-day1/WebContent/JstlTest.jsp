<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 변수 선언 -->
<c:set var="sum" value="0" />

<!-- 반복문 for -->

<c:forEach var="i" begin="1" end="10" step="${i=i+2 }" >

	<c:set var="sum" value="${sum=sum+i }" />
	
</c:forEach>

${sum }

</body>
</html>