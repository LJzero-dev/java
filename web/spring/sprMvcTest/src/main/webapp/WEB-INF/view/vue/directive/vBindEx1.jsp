<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
</head>
<body>
<div id="app1">
	<img src="resources/img/book.png" width="200" />직접 지정
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<img v-bind:src="fileName" v-bind:width="width" />v-bind로 지정
</div>
<script>
new Vue({
	el : "#app1",
	data : {
		fileName : "resources/img/library.png",
		width : 150
	}
});
</script>
<hr />
<div id="app2">
	<a href="http://www.naver.com/">링크를 직접 지정</a><br />
	<a :href="naverUrl">v-bind로 지정</a><br />	
</div>
<script>
new Vue({
	el : "#app2",
	data : {
		naverUrl : "http://www.naver.com/"
	}
});
</script>
</body>
</html>