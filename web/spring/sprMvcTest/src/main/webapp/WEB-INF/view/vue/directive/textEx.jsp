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
	js 이용 : <input type="text" name="myName" id="myName" placeholder="이름" onkeyUp="showTxt(this.value);" />
	<p>나는 <span id="txt1"></span> 입니다.</p>
	<hr />
	Vue 이용 : 
	<input type="text" v-model="myName" placeholder="이름" />
	<!-- 현 컨트롤(텍스트 필드)의 value속성 값을 myName이라는 프로퍼티로 연결 -->
	<p>나는 {{ myName }} 입니다.</p>
	<hr />
	<textarea v-model="myText"></textarea>
	<p>입력된 문장은 "{{ myText }}"</p>
	<p>문자수는 {{ myText.length }}자입니다.</p>
</div>
<script>
function showTxt(val){
	var txt = document.getElementById("txt1");
	txt.innerHTML = val;
}

new Vue({
	el : "#app",
	data : {
		myName : "",
		myText : "오늘도 덥습니다."
	}
});
</script>
</body>
</html>