<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/style.css" />
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<style>
.test-comp {
	width:400px; background:#ffffe0; border:darkorange solid; border-radius:8px; padding:10px; 
}
</style>
</head>
<body>
<div id="app">
	<test-component></test-component>
	<test-component></test-component>
	<test-component></test-component>
</div>
<script>
var TestComponent = {
	template : "<p class='test-comp'>카운트 : {{count}} " +
/*
	+ "<input type='button' v-on:click='countUp' value='증가' />" + 
	"<input type='button' v-on:click='countDown' value='감소' />
*/
	"<input type='button' v-on:click='countChange(1)' value='증가' />" + 
	"<input type='button' v-on:click='countChange(-1)' value='감소' />" +
	"</p>",data : function() {
		//	component의 data 프로퍼티는 함수의 결과로 리턴받아야 함
		return {
			count : 0
		}
	},
	methods : {
		countUp() {
			this.count++;	
		},
		countDown() {
			this.count--;
		},
		countChange(val) {
			this.count = this.count + val;
		}
	}
}

new Vue({
	el : "#app",
	data : {
		count : 0
	},
	methods : {
	},
	components : {
		"test-component" : TestComponent
	}
});
</script>
</body>
</html>