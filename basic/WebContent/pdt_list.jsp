<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#pdt { border-collapse:collapse; }
#pdt, #pdt td { border:1px black solid; }
#pdt td { width:15px; height:100px; text-align:center; }
</style>
</head>
<body>
<h2>상품 목록</h2>
<!-- 총 상품은 10개이고, 한 줄에 상품 4개씩 보여주는 목록 -->
<table width="600" id="pdt">
<%
int num = 0;
for (int i = 1; i < 11; i++) {
	if (i % 4 == 1) out.println("<tr>");
%>
<td>상품</td>
<%
	if (i % 4 == 0) out.println("</tr>");
	num = i % 4; 
}

if (num > 0) {
	out.println("<td colspan=\"" + (4 - num) + "\"></td></tr>");
}
%>
</table>
</body>
</html>