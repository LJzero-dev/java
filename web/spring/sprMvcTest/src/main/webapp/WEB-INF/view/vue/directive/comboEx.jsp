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
	<select v-model="myColor">
		<option disabled="disabled" value="">색을 선택하세요.</option>
		<option>red</option>
		<option>green</option>
		<option>blue</option>
		<option>orange</option>
		<option>brown</option>
	</select>
	<p :style="{color:myColor}">선택한 색상은 {{ myColor }} 입니다.</p>
	<hr />
	<select v-model="myColor2" multiple="multiple">
		<option disabled="disabled" value="">색을 선택하세요.</option>
		<option>red</option>
		<option>green</option>
		<option>blue</option>
		<option>orange</option>
		<option>brown</option>
	</select>
	<p>선택한 색상(들)은 {{ myColor2 }} 입니다.</p>
</div>
<script>
new Vue({
	el : "#app",
	data : {
		myColor : "",
		myColor2 : []
	}
});
</script>
</body>
</html>