<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Part를 이용한 다중파일 업로드</h2>
<form action="uploadPartProc2" method="post" enctype="multipart/form-data">
업로더 : <input type="text" name="name" /><br />
파일1 : <input type="file" name="file1" /><br />
파일2 : <input type="file" name="file2" /><br />
<input type="submit" value="다중 파일 업로드" />
</body>
</html>