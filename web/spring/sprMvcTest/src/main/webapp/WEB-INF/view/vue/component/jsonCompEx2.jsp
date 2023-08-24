<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/style.css" />
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<style>
.v-move { transition:transform 1s; }
</style>
</head>
<body>
<div id="app">
	<transition-group>
		<div v-for="item in dataArray" :key="item.title">
			<json-component :object="item"></json-component>
		</div>
	</transition-group>
	<input type="button" value="정렬" v-on:click="sortData" />
	<input type="button" value="섞기" v-on:click="shuffleData" />
	<p><input type="file" v-on:change="loadData" /></p>
</div>
<script>
var JsonComponent = {
		props : ["object"],
		template : `
		<div style="width:400px; backgroundColor:#ffddaa;">
			<p style="backgroundColor:#ffa95e;">{{object.title}}</p>
			<p>설명 : {{object.body}}</p>
		</div>
		`
}

new Vue({
	el : "#app",
	data : {
		dataArray : [{title : "AA", body : "aaa"},	{title : "BB", body : "bbb"},	{title : "CC", body : "ccc"},	{title : "DD", body : "ddd"},	{title : "EE", body : "eee"}]
	},
	components : {
		"json-component" : JsonComponent
	},
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
		},
		loadData(e) {
			var file = e.target.files[0];
			if (file) {
				var reader = new FileReader();
				var vm = this;
				
				reader.readAsText(file);
				
				reader.onload = function(e) {
					vm.dataArray = JSON.parse(e.target.result);
				}
			}
		}
	}
});
</script>
</body>
</html>