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
	<p>감상은 100자 이내로 입력해 주세요.</p>
	<textarea v-model="myText"></textarea>
	<p :style="{color:compColor}">남은 글자수는 {{leftCnt}}자 입니다.</p>
	<!-- 남은 글자 수가 20자 이내이면 orange색, 1자 미만이면 red색으로 표현 -->
</div>
<script>
new Vue({
	el : "#app",
	data : {
		myText : "오늘도 날씨가 덥습니다."
	},
	computed : {
		leftCnt() {	//	myText의 길이가 변하면 남은 글자 수를 계산함
			if(this.myText.length > 100)	this.myText = this.myText.substring(0,100);
			return 100 - this.myText.length;
		},
		compColor() {	//	leftCnt가 변하면 compColor를 계산
			return this.leftCnt < 1 ? "red" : this.leftCnt <= 20 ? "orange" : "green";
		}
	}
});
</script>
</body>
</html>