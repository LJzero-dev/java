<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
</head>
<body>
<div id="app1">
	<p>{{ exNumber }}</p><!-- 12345 -->
	<p>{{ exString }}</p><!-- test string -->
	<p>{{ exBoolean }}</p><!-- true -->
</div>
<script>
new Vue({
	el: "#app1",
	data:{
		exNumber:12345,
		exString:"test string",
		exBoolean:true
	}
});
</script>
<hr />
<div id="app2">
	<p>{{ "원가 : " + price + " / 10% 할인가 : " + price*0.9}}</p><!-- 원가 : 100000 / 10% 할인가 : 90000 -->
	<p>{{ uname + "님 환영합니다." }}</p><!-- 홍길동님 환영합니다. -->
	<p>{{ "성 : " + uname.charAt(0) }}</p><!-- 성 : 홍 -->
	<p>{{ "이름 : " + uname.substring(1) }}</p><!-- 이름 : 길동 -->
</div>
<script>
new Vue({
	el:"#app2",
	data:{
		price: 100000,
		uname: "홍길동"
	}
});
</script>
</body>
</html>