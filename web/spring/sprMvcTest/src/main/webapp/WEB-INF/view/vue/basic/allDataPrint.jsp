<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
</head>
<body>
<div id="app">
	<p>all data : {{ $data }}</p>
	<!-- 
	all data : {
		"exNumber": 12345,
		"exString": "test string",
		"esBoolean": true,
	    "exArr": [ "홍길동", "전우치", "임꺽정" ],
	    "exObj": { "uname": "홍길동", "age": 33, "arr": [ 1, 2, 3 ],"inner": { "uname": "전우치", "age": 30 } } } 
	-->
</div>
<script>
new Vue({
	el : "#app",
	data : {
		exNumber : 12345,
		exString : "test string",
		esBoolean : true,
		exArr : ["홍길동", "전우치", "임꺽정"],
		exObj : {uname:"홍길동", age:33, arr:[1, 2, 3], inner:{uname:"전우치", age:30}}
	}
});
</script>
</body>
</html>