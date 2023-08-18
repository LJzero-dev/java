<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/style.css" />
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<style>
#vfor { text-align:left; }
#vfor th { padding:12px; border-bottom:2px solid darkhray }
#vfor td { padding:12px; }
#vfor tr:nth-of-type(even) { background-color:rgba(0, 0, 255, 0.1); }
</style>
</head>
<body>
<div id="app">
	<h3>관심 받는 언어 랭킹</h3>
	<table width="600" cellspacing="0" id="vfor">
		<thead>
			<tr>
				<th v-for="item in header">{{item}}</th>
			</tr>
		</thead>
		<tbody>
			<tr v-for="line in ranking" >
				<td v-for="item in line">{{item}}</td>
			</tr>		
		</tbody>
	</table>
</div>
<script>
new Vue({
	el : "#app",
	data : {
		header : ["프로그램 언어", 2020, 2015, 2010, 2005, 2000],
		ranking : [
			["Java", 1, 1, 1, 1, 2],
			["C&C++", 2, 2, 2, 2, 1],
			["Python", 4, 5, 6, 10, 12],
			["JavaScript", 5, 6, 10, 9, 11]
		]
	}
});
</script>
</body>
</html>