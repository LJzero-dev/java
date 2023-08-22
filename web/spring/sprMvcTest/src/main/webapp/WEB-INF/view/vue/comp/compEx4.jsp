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
	<!-- 0에서 255까지의 값을 표현하는 range 컨트롤 -->
	 <input v-model="R" type="range" min=0 max=255>
	 <input v-model="G" type="range" min=0 max=255>
	 <input v-model="B" type="range" min=0 max=255>
	 <p :style="{backgroundColor:mixColor}">{{mixColor}}</p>
</div>
<script>
new Vue({
	el : "#app",
	data : {
		R : 255,
		G : 150,
		B : 100
	},
	computed : {
		mixColor(){
			return "rgb(" + this.R + ", " + this.G + ", " + this.B + ")"
		}
	}
});
</script>
</body>
</html>