<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>자바빈즈 테스트 폼</h2>
<form action="bean_test3.jsp" method="post">
이름 : <input type="text" name="name" /><br />
성별 : <input type="radio" name="gender" value="남자" />남자
<input type="radio" name="gender" value="여자" />여자<br />
<input type="submit" value="전송" />
</form>
</body>
</html>