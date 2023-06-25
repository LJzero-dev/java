<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>forward 액션 태그 테스트</h2>
<form name="frm" action="act_forward2.jsp" method="post">
<input type="hidden" name="forwardPage" value="act_forward3.jsp" />
이름 : <input type="text" name="name" /><br />
나이 : <input type="text" name="age" /><br />
<input type="submit" value="전 송" />
</form>
</body>
</html>