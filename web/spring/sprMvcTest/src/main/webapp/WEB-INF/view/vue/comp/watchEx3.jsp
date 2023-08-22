<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/style.css" />
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.7.1/gsap.min.js"></script>
</head>
<body>
<div id="app">
	<p>값은 {{aniNumber}}입니다.</p>
	<input type="number" v-model.number="myNumber" />
</div>
<script>
new Vue({
	el : "#app",
	data : {
		myNumber : 0,
		tweenedNumber : 0		
	},
	computed : {
		aniNumber() {
			return this.tweenedNumber.toFixed(0);
		}
	},
	watch : {
		myNumber() {
			TweenMax.to(this.$data, 1, {tweenedNumber : this.myNumber});
		}
	}
});
</script>
</body>
</html>