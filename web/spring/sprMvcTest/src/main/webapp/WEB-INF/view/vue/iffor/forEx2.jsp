<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/style.css" />
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
</head>
<body>
<div id="app">
	<h3>문자열 배열 루프</h3>
	<ul>
		<li v-for="item in arrBook">{{item}}</li>
	</ul>
	<h3>객체 배열 루프</h3>
	<ul>
		<li v-for="item in arrObj">책 이름 : {{item.name}} / 가격 : {{item.price}}원</li>
	</ul>
</div>
<script>
new Vue({
	el : "#app",
	data : {
		arrBook : ["Java 기초", "JSP & Servlet", "Java with Spring"],
		arrObj : [
			{name:"Java 기초", price:25000},
			{name:"JSP & Servlet", price:30000},
			{name:"Java with Spring", price:35000}
		]
	}
});
</script>
</body>
</html>