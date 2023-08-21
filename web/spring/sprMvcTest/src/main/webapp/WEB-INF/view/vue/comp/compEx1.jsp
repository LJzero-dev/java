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
	<input type="number" v-model.number="price" />원 X
	<input type="number" v-model.number="count" />개
	<p>합계 : {{sum}}원 / 할인가 : {{realPrice}}원</p>
	할인율 : <input type="number" v-model.number="dc" />%
</div>
<script>
new Vue({
	el : "#app",
	data : {
		price : 100,
		count : 1,
		dc : 0
	},
	computed : {
		sum() {	//	price나 count가 변하면 합계 금액을 다시 계산함
			return this.price * this.count;
		},
		realPrice() {	//	합계 금액이 변하면 다시 계산함
			return this.sum * (100 - this.dc)/100;
		}
	}
});
</script>
</body>
</html>