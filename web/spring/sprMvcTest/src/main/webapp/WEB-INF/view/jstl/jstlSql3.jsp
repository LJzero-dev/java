<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원 목록 검색</h2>
<form name="frm">
	<select name="schtype">
		<option value="id" <c:if test="${pi.getSchtype() == 'id'}">selected="selected"</c:if>>아이디</option>
		<option value="name" <c:if test="${pi.getSchtype() == 'name'}">selected="selected"</c:if>>이름</option>
	</select>	
	<input type="text" name="keyword" value="${pi.getKeyword()}" />
	<input type="submit" value="검색" />
	<input type="button" value="전체 검색" onclick="location.href='jstlSql3';" />
</form>
<table width="800">
<tr align="center">
<th width="5%">번호</th>
<th width="10%">아이디</th>
<th width="15%">이름(성별)</th>
<th width="15%">생일</th>
<th width="20%">전화번호</th>
<th width="25%">이메일</th>
<th width="10%">포인트</th>
</tr>
<tr>
<c:forEach var="mi" items="${memberList}" varStatus="status">
	<tr>
		<td>${status.count}</td>
		<td>${mi.getMi_id()}</td>
		<td>${mi.getMi_name()}(${mi.getMi_gender()})</td>
		<td>${mi.getMi_birth()}</td>
		<td>${mi.getMi_phone()}</td>
		<td>${mi.getMi_email()}</td>
		<td>${mi.getMi_point()}</td>
	</tr>
</c:forEach>
</tr>
</table>
</body>
</html>