<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.6.4.js"></script>
<script>
function noJson() {	// 서버의 'noJson' 이라는 url로 요청을 보내고, 그 응답으로 받아온 문자열을 쉼표를 기준으로 배열로 만든 후 result1에 목록 태그로 출력 요청을 받는 컨트롤러에서는 '홍길동', '전우치', '임꺽정'의 값을 가지는 배열을 이용하여 쉼표를 기준으로 문자열로 만든 후 리턴
$.ajax({
	type:"get",
	url:"noJson",
	success: function(rs){        	 
	var arr = rs.split(",");
	var str = "<ul>";        	 
	for (i = 0; i < arr.length; i++) {
		str += "<li>" + arr[i] + "</li>";
	}
	$("#result1").html(str += "</ul>");
	}
    })
}
</script>
</head>
<body>
<p id="result1"></p>
<input type="button" value="json 없이 실행" onclick="noJson();" />
<hr />
</body>
</html>