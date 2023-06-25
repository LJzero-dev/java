<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>서블릿 호출(Post 방식)</h2>
<form action="callServlet" method="post">
<input type="hidden" name="aa" value = "a" />
id : <input type="text" name="id" /><br />
pw : <input type="password" name="pw" /><br />
aa : <input type="checkbox" name="aa" value="b" />b
<input type="checkbox" name="aa" value="c" />c
<input type="checkbox" name="aa" value="d" />d<br />
aa : <input type="text" name="aa" /><br />
aa : <select name="aa">
	<option value="1">1111</option>
	<option value="2" disabled="disabled">2222</option>	
	<option value="3">3333</option>
</select>
<br />
<input type="submit" value="전송" />
</form>
</body>
</html>
