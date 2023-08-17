<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<style>
.cls1 { text-decoration:line-through; color:gray; }
.cls2 { background:aqua; }
</style>
</head>
<body>
<div id="app">
	<p class="cls1">직접 클래스 지정</p>
	<p :class="clsPt1">v-bind 클래스 지정</p>
	<p :class="[clsPt1,clsPt2]">v-bind 여러 클래스 지정</p>
	<p :class="{'cls1':isOn}">데이터로 클래스 ON/OFF 1</p>
	<p :class="{'cls1':isOff}">데이터로 클래스 ON/OFF 1</p>
</div>
<script>
new Vue({
	el : "#app",
	data : {
		clsPt1 : "cls1",
		clsPt2 : "cls2",
		isOn : true,
		isOff : false
	}
});
</script>
</body>
</html>