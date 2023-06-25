<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Part를 이용한 단일파일 업로드</h2>
<form action="uploadPartProc1" method="post" enctype="multipart/form-data">
업로더 : <input type="text" name="name" /><br />
파일 : <input type="file" name="file1" /><br />
<input type="submit" value="단일 파일 업로드" />
</form>
</body>
</html>