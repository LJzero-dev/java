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
	<p style="color:#e80;">문자색을 직접 지정</p>
	<p style="font-size:2em;">문자 크기를 직접 지정</p>
	<p style="background-color:aqua;">배경색을 직접 지정</p>
	<hr />	
	<p :style="{color:exColor}">문자색 v-bind로 지정</p>
	<p :style="{fontSize:exFontSize}">글씨 크기를 v-bind로 지정</p>
	<p :style="{backgroundColor:exBackColor}">배경색을 v-bind로 지정</p>
</div>
<script>
new Vue({
	el : "#app",
	data : {
		exColor: "#e80",
		exFontSize : "2em",
		exBackColor: "aqua"
	}
});
</script>
</body>
</html>