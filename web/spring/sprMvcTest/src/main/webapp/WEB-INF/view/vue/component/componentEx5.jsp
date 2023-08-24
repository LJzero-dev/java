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
	<!-- 1~10의 숫자를 짝수인지 홀수인지 출력(예 : 1은 홀수 입니다.) -->
	<!-- 계산은 component에서 computed 옵션을 사용해야 함 -->
	<test-component v-for="item in numArray" :num="item"></test-component>
</div>
<script>
var TestComponent = {
	template : "<p>{{result}}</p>",
	props : {
		num : Number	
	},
	computed : {
		result() {
			return this.num + "은 " + (this.num % 2 == 1 ? "홀수" : "짝수") + " 입니다.";
		}
	}
}

new Vue({
	el : "#app",
	data : {
		numArray : [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
	},
	components : {
		"test-component" : TestComponent
	}
});
</script>
</body>
</html>