<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script>
var arr = [
	{uname:"홍길동", age:33}, {uname:"전우치", age:30}, {uname:"임꺽정", age:27}
]
</script>
</head>
<body>
<div id="app">
	<p>obj : {{obj}}</p>
	<p>obj[0] : {{obj[0]}}</p>
	<p>obj[1] : {{obj[1]}}</p>
	<p>obj[2] : {{obj[2]}}</p>
	<p>이름 : {{obj[0].uname}}</p>
	<p>나이 : {{obj[0].age}}</p>	
</div>
<script>


new Vue({
	el : "#app",
	data : {
		obj : arr	//	자바스크립트에서 생성한 배열을 vue용 프로퍼티에 담음
	}
});
</script>
</body>
</html>