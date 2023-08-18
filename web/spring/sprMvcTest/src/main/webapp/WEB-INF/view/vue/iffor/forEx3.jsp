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
	<ul>
		<li v-for="(item, index) in arrBook">{{index}} : {{item}}</li>
	</ul>
</div>
<script>
new Vue({
	el : "#app",
	data : {
		arrBook : ["Java 기초", "JSP & Servlet", "Java with Spring"]
	}
});
</script>
</body>
</html>