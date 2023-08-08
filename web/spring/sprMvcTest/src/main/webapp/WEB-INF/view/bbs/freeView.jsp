<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>자유 게시판 글 보기</h2>
<table width="600" cellpadding="5">
<tr>
<th width="10%">작성자</th><td width="15%">${fl.getFl_writer()}</td>
<th width="10%">조회수</th><td width="10%">${fl.getFl_read()}</td>
<th width="10%">작성일</th><td width="*">${fl.getFl_date()}</td>
</tr>
<tr><th>글제목</th><td colspan="5">${fl.getFl_title()}</td></tr>
<tr><th>글내용</th><td colspan="5">${fl.getFl_content()}</td></tr>
<tr><td colspan="6" align="center">
	<input type="button" value="글목록" onclick="location.href='freeList${args}'" />
</td></tr>
</table>
</body>
</html>