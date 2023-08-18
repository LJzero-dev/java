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
	<input type="number" v-model.number="num1" />
	<input type="number" v-model.number="num2" />
	<hr />
	<input type="button" value="덧샘계산" v-on:click="result = num1 + num2;" />
	<input type="button" value="뺄샘계산" v-on:click="result = num1 - num2;" />
	<input type="button" value="곰샘계산" v-on:click="result = num1 * num2;" />
	<input type="button" value="나눗샘계산" v-on:click="result = num1 / num2;" />
	<p>결과는 {{result}} 입니다</p>
	<hr />
	<input type="button" value="덧샘계산" v-on:click="cal(num1 + num2);" />
	<input type="button" value="뺄샘계산" v-on:click="cal(num1 - num2);" />
	<input type="button" value="곰샘계산" v-on:click="cal(num1 * num2);" />
	<input type="button" value="나눗샘계산" v-on:click="cal(num1 / num2);" />
	<p>결과는 {{result2}} 입니다</p>
</div>
<script>
new Vue({
	el : "#app",
	data : {
		num1 : 0,
		num2 : 0,
		result : 0,
		result2 : 0
	},
	methods : {
		cal(val){
			this.result = val;
		}
	}
});
</script>
</body>
</html>