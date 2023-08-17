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
	<input type="text" v-model="uname" />
	<p>추가될 이름 : {{ uname }}</p>
	<p>모든 이름 : {{ arrName }} </p>
	<input type="button" value="이름 추가" v-on:click="addName" />
	<input type="button" value="이름 삭제" v-on:click="delName" />
</div>
<script>
new Vue({
	el : "#app",
	data : {
		uname : "",
		arrName : ["홍길동", "전우치", "임꺽정"]
	},
	methods : {
		addName() {
			this.arrName.push(this.uname);
		},
		delName() {
			this.arrName.splice(this.arrName.length - 1, 1);
		}
	}
});
</script>
</body>
</html>