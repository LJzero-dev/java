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
<p v-text="txt"></p>
<p v-html="txt"></p>
<p>{{txt}}</p>
</div>
<script>
new Vue({		//	현 문서에서 vue를 사용하기위한 인스턴스 생성
	el: "#app",	//	id가'app'인 문서의 요소를 연결하여 사용한다는 의미 
	data: {
		txt: "<h3>Hello Vue!!</h3>"
	}
});
</script>
</body>
</html>