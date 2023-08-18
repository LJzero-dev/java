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
	<p>이름 : <input type="text" v-model.lazy="myName" placeholder="이름"/></p>
	<label><input type="radio" v-model="myColor" value="red"  />빨강</label><br />
	<label><input type="radio" v-model="myColor" value="green" />초록</label><br />
	<label><input type="radio" v-model="myColor" value="blue" />파랑</label><br />	
	<label><input type="radio" v-model="myColor" value="yellow" />노랑</label><br />	
	<label><input type="radio" v-model="myColor" value="gray" />회색</label><br />	
	<p :style="{color:myColor2}">내 이름은 {{myName}} 이고 좋아하는 색은 {{ myColor2 }} 입니다.</p>
	<input type="button" v-on:click="myColor2 = myColor;" value="색상 적용"/>
</div>
<script>
new Vue({
	el : "#app",
	data : {
		myName : "",
		myColor : "",
		myColor2 : ""
	}
});
</script>
</body>
</html>