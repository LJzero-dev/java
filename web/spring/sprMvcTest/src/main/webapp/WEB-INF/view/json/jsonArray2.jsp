<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
request.setCharacterEncoding("utf-8");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.6.4.js"></script>
<script>
	var jsonStr = '<%=request.getAttribute("jsonStr").toString().replaceAll("\'", "\"") %>';	//	jsonArray1에서 보낸 json형식의 문자열을 받아옴
// String 데이터를 자바스크립트배열로 변환
	var jsonArr = JSON.parse(jsonStr);
	//	var jsonArr = eval(jsonStr);
	//	eval()함수로도 비슷한 작업을 할 수 있으나 보안상의 문제로 권장하지 않음
	console.log(jsonArr);
</script>
</head>
<body>

</body>
</html>