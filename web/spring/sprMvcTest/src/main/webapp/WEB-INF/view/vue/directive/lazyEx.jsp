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
	<input type="text" v-model.lazy="lazyText" />
	<p>입력 완료 후 표시 '{{lazyText}}'</p>
</div>
<script>
new Vue({
	el : "#app",
	data : {
		lazyText : ""	//	모든 글자를 입력할 때 까지 저장되지 않음(엔터를 치거나 포커스가 이동할 때 까지)		
	}
});
</script>
</body>
</html>