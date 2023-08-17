<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/style.css" />
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script>
var count = 0;
function countUp() {
	count += 1;
	document.getElementById("jsCount").innerHTML = count;
}
function countDown() {
	count -= 1;
	document.getElementById("jsCount").innerHTML = count;
}
</script>
</head>
<body>
<h2>클릭시 카운트 올리기</h2>
<h3>자바스크립트로 작업</h3>
<span id="jsCount">0</span>회
<input type="button" value="카운트 올리기" onclick="countUp();" />
<input type="button" value="카운트 내리기" onclick="countDown();" />
<hr />
<div id="app">
	{{ count }}회
<input type="button" value="카운트 올리기" v-on:click="count++" />
<input type="button" value="카운트 내리기" v-on:click="countDown" />
</div>
<script>
new Vue({
	el : "#app",
	data : {
		count : 0
	},
	methods : {
		countDown : function() {
			this.count--;	//	vue의 data 프로퍼티를 사용하려면 this를 붙여야 함
		},
		countUp() {	//	메소드 선언 시 function은 생략가능
			this.count++;
		}
	}
});
</script>
</body>
</html>