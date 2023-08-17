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
	<label><input type="radio" v-model="pick" value="red" />빨강</label><br />
	<label><input type="radio" v-model="pick" value="green" />초록</label><br />
	<label><input type="radio" v-model="pick" value="blue" />파랑</label><br />	
	선택한 색상은 {{ pick }}
	<hr />
	<!-- 두 개의 라디오 버튼을 만들고 그 중 하나를 선택하면 해당 이미지가 보이게 함 -->
	<label><input type="radio" v-model="fileName" value="resources/img/book.png" />책</label><br />
	<label><input type="radio" v-model="fileName" value="resources/img/library.png" />도서관</label><br />
	<p>{{ fileName }} 선택</p>
	<img :src="fileName" width="150" />
</div>
<script>
new Vue({
	el : "#app",
	data : {
		pick : "red",	//	먼저 선택되어 있게할 라디오 버튼의 값 설정(비워두면 모든 라디오버튼은 선택되지 않은 상태가 됨)
		fileName : "resources/img/book.png"
	}
});
</script>
</body>
</html>