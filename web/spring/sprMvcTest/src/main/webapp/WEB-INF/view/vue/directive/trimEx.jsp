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
	<input type="text" v-model="trimText1" />
	<p>앞뒤 공백 남김 '{{trimText1}}'</p>
	<input type="text" v-model.trim="trimText2" />
	<p>앞뒤 공백 제거 '{{trimText2}}'</p>
	<hr />
</div>
<script>
new Vue({
	el : "#app",
	data : {
		trimText1 : "",
		trimText2 : ""
	}
});
</script>
</body>
</html>