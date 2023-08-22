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
	<input type="text" v-model="findWord" />
	<ul>
		<li v-for="item in findItems">{{item}}</li>
	</ul>
</div>
<script>
new Vue({
	el : "#app",
	data : {
		findWord : "",	//	검색어
		items : ["설악산", "한라산", "북한산", "지리산", "백두산", "관악산"]
	},
	computed : {
		findItems() {
			if(this.findWord) {	//	this.findWord에 값이 있으면
				return this.items.filter(function(val){
					return (val.indexOf(this.findWord) >= 0);
				}, this);
			} else {			//	this.findWord에 값이 없으면
				return this.items;
			}
		}
	}
});
</script>
</body>
</html>