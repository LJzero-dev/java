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
	<div v-for="item in dataArray" :key="item.title">
		<my-component :object="item"></my-component>
	</div>
	<input type="button" value="정렬" v-on:click="sortData" />
	<input type="button" value="섞기" v-on:click="shuffleData" />
</div>
<script>
var MyComponent = {
	props : ["object"],
	template : `
		<div style="width:300px; backgroundColor:#ffddaa;">
			<p style="backgroundColor:#ffa95e;">title : {{object.title}}</p>
			<p>body : {{object.body}}</p>
		</div>
	`
	//	template 부분이 길어서 줄바꿈이 필요할 경우 백틱(`)문자로 감싸면 사용하기 쉬움

}

new Vue({
	el : "#app",
	data : {
		dataArray : [{title : "AA", body : "aaa"},	{title : "BB", body : "bbb"},	{title : "CC", body : "ccc"},	{title : "DD", body : "ddd"},	{title : "EE", body : "eee"}]
	},
	components : {
		"my-component" : MyComponent
	}	,
	methods : {
		sortData() {
			this.dataArray.sort(function(a, b) {
				return (a.title < b.title ? -1 : 1);
			});
		},
		shuffleData() {	
			/* this.dataArray.sort(() => Math.random() - 0.5); */
			var tmpArray = [];
			var len = this.dataArray.length;
			for (var i = len; len > 0; len--) {
				var r = Math.floor(Math.random() * len);
				tmpArray.push(this.dataArray[r]);
				this.dataArray.splice(r, 1);
			}
			this.dataArray = tmpArray;
		}
	}
});
</script>
</body>
</html>