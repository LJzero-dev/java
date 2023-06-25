<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 
	
		*
	   ***
	  *****
	 *******
    *********
	 -->


<!-- 5개의 반복적인 일을 하는 outer for문 --> 
<c:forEach var="i" begin="0" end="4">

	<!-- 공백을 출력하는 반복문 작성 -->
	<c:forEach var="j" begin="${i+1 }" end="4">
	
		&nbsp;
		
	</c:forEach>
	
	<c:forEach var="j" begin="1" end="${1+(i*2) }">
		*
		
	</c:forEach>
	
	<br />	
</c:forEach>


</body>
</html>