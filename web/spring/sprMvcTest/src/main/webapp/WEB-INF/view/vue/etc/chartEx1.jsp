<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/style.css" />
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://www.gstatic.com/charts/loader.js"></script>
<style>
#chartDiv {
	height:500px; border:1px solid black; margin:0 0 10px 0;
}
</style>
</head>
<body>
<h3>지금 사용하고 있는 언어 투표</h3>
<div id="chartDiv">
</div>
<div id="app">
	<!-- 버튼 6개를 for문을 이용하여 출력 -->
	<span v-for="(item, index) in dataArray" v-if="index > 0">
		&nbsp;&nbsp;{{item[0]}} : {{item[1]}}
		<input type="button" value="투표" v-on:click="vote(index);" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</span>
</div>
<script>
var orgdata = [["종류", "투표수"], ["C&C++", 7], ["Java", 13], ["Kotlin", 8], ["Python",7 ], ["PHP", 3], ["ASP.Net", 2]];

google.charts.load("current", {packages: ["corechart"]});
google.charts.setOnLoadCallback(drawBasic);

function drawBasic(){
	var data = google.visualization.arrayToDataTable(orgdata);
	var options = {title : "많이 사용하는 언어", "is3D" : true};
	var chart = new google.visualization.PieChart(document.getElementById("chartDiv"));
	chart.draw(data, options);
}

new Vue({
	el : "#app",
	data : {
		dataArray : orgdata
	},
	methods : {
		vote(index){
			var obj = this.dataArray[index];	//	2차원 배열인 dataArray에서 index에 해당하는 요소를 추출하여 obj에 저장 obj에 저장된 dataArray배열의 요소는 당연히 1차원 배열임
			obj[1]++;
			this.dataArray.splice(index, 1, obj);	//	dataArray배열의 index위치에 있는 요소를 삭제 후 obj로 변경
			drawBasic();	//	차트 다시 그리는 함수 호출
		}
	}
});
</script>
</body>
</html>