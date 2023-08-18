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
	<input type="number" v-model="numberText1" />
	<p>100에 더해서 표시 '{{numberText1 + 100}}'</p>
	<hr />
	<input type="number" v-model.number="numberText2" /><!-- 입력된 값을 숫자형 데이터로 변경하여 프로퍼티에 저장 -->
	<p>100을 더해서 표시 '{{numberText2 + 100}}'</p>
</div>
<script>
new Vue({
	el : "#app",
	data : {
		numberText1 : 0,
		numberText2 : 0
	}
});
</script>
</body>
</html>