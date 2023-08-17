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
	<label><input type="checkbox" v-model="chkTest" />
	체크박스의 상태는 {{ chkTest }}</label>
	<hr />
	<label><input type="checkbox" v-model="chkArr" value="red" />빨강</label><br />
	<label><input type="checkbox" v-model="chkArr" value="green" />초록</label><br />
	<label><input type="checkbox" v-model="chkArr" value="blue" />파랑</label><br />
	선택한 색상은 {{ chkArr }}
	<hr />
	<label><input type="checkbox" onclick="isChk(this);"/></label>
	<input id="btn" type="button" value="전송" disabled="disabled" onclick="alert();"/>
	<hr />
	Vue로 구현 :
	<label><input type="checkbox" v-model="agree" /></label>
	<input type="button" value="전송" v-bind:disabled="agree == false" onclick="alert();"/><!-- disabled속성은 agree프로퍼티의 값이 false일 때 사용됨 -->
	Vue로 구현 :
	<br />
	<label><input type="checkbox" v-model="agree" /></label>
	<input type="button" value="전송" v-bind:disabled="!agree" onclick="alert();"/>
</div>
<script>
function isChk(chk){
	document.getElementById("btn").disabled = !chk.checked;
}
new Vue({
	el : "#app",
	data : {
		chkTest : false,	//	처음에는 체크되어 있지 않은 상태
		chkArr : [],		//	사용자가 선택한 값(들)을 저장할 배열
		agree : false		//	처음에는 체크되어 있지 않은 상태
	}
});
</script>
</body>
</html>