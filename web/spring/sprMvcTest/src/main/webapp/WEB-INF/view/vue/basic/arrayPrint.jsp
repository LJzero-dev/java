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
	<p>arr : {{arr}}</p>
	<p>arr[0] : {{arr[0]}}</p>
	<p>arr[1] : {{arr[1]}}</p>
	<p>arr[2] : {{arr[2]}}</p>
</div>
<script>
new Vue({
	el: "#app",
	data: {
		arr: ["홍길동", "전우치", "임꺽정"]
	}
});
</script>
</body>
</html>