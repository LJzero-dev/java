<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>메일 입력 폼</h2>
<form action="mailSend" method="post">
보내는 사람 메일 주소 : <input type="text" name="sender" /><br />
받는 사람 메일 주소 : <input type="text" name="receiver" /><br />
메일 제목 : <input type="text" name="title" /><br />
메일 내용 : <textarea rows="10" cols="40" name="content"></textarea><br />
<input type="submit" value = "메일 보내기" />
</form>
</body>
</html>