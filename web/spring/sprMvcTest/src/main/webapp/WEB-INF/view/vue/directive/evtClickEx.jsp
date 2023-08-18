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
	<p>카운트 : {{count}}</p>
	<hr />
	<input type="button" value="3증가" v-on:click="countUp(3)" />
	<input type="button" value="30증가" v-on:click="countUp(30)" />
	<input type="button" value="300증가" v-on:click="countUp(300)" />
	<hr />
	<!-- 택스트 필드에 더할 값을 입력한 후 버튼을 클릭하면 그 값을 더하여 카운트에 표시 -->
	<input type="number" v-model.number="addNum" />
	<input type="button" value="증가" v-on:click="countUp(addNum)" />	
</div>
<script>
new Vue({
	el : "#app",
	data : {
		count : 0,
		count2 : 0
	},
	methods : {
		countUp(cnt) {
			this.count += cnt
		}
	}	
});
</script>
</body>
</html>