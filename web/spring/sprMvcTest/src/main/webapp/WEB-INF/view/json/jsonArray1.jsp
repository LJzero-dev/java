<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.6.4.js"></script>
<script>
function chkVal(frm){
	var jsonArr = [{"id":"AA", "addr":"Seoul"},{"id":"BB", "addr":"Busan"}];	// Json형식의 데이터를 JSON.stringify()를 이용하여 문자열로 변환 후 폼 요소에 저장
	frm.jsonArr.value = JSON.stringify(jsonArr);
	return true;
}
</script>
</head>
<body>
<form action="jsonArray2" method="post" onsubmit="return chkVal(this);">
	<input type="hidden" name="jsonArr" value=""/>
	<input type="submit" value="전송" />
</form>
</body>
</html>