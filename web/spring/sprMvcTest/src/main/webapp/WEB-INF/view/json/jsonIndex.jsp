<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>JSON Test Page!!</h2>
<table width="700" cellpadding="5">
	<tr>
		<td width="25%"><a href="jsObject">Javascript Object</a></td>
		<td width="25%"><a href="test01Stringify">stringify() Test</a></td>
		<td width="25%"><a href="test02Parse">parse() Test</a></td>
		<td width="25%"><a href="whyJson">why Json</a></td>
	</tr>
	<tr>
		<td width="25%"><a href="jsonFile">json file</a></td>
		<td width="25%"><a href="jsonArray1">JSONArray1</a></td>
		<!--
		 1. jsonArray1.jsp에서 자바스크립트 배열을 문자열로 만들어  jsonArray2로 보냄
		 2. jsonArray1에서 보낸 문자열을 jsonArray2에서 다시 자바스크립트 배열로 변환하여 사용
		 - 문자열을 JSONArray로 만들어 출력
		 - 문자열을 jsonArray2.jsp로 보낸 후 다시 자바스크립트 배열로 변환하여 사용
		 -->
		<td width="25%"><a href="jasonArrayDb1">jasonArray2</a></td>
		<!-- 
		jsonArrayDb1.jsp에서 회원 목록을 보여줌
		 - 아이디와 이름으로 검색할 수 있음
		 - 원하는 회원들을 선택할 수 있음
		jsonArrayDb2에서는 jsonArrayDb1.jsp에서 보낸 회원들의 정보들을
		JSONArray로 변경하여 출력
		 -->
		<td width="25%"><a href=""></a></td>
	</tr>
</table>
</body>
</html>