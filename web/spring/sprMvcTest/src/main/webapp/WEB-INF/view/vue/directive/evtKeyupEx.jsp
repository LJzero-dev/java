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
	<input type="text" v-model="myText" v-on:keyup.enter="showAlert('Enter')"/>
	<input type="text" v-on:keyup.enter.ctrl="showAlert('Enter+Ctrl')"/>
	<p>{{myText}}</p>
</div>
<script>
new Vue({
	el : "#app",
	data : {
		myText : "Hello!!"
	},
	methods : {
		showAlert(val) {
			this.myText = val;
			alert(val + "키를 눌렀습니다.");
		}
	}	
});
</script>
</body>
</html>