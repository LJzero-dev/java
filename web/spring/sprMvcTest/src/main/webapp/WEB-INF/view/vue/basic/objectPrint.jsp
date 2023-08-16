<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
</head>
<body>
<div id="app">
	<p>obj : {{obj}}</p>
	<p>{{ "obj.uname : " + obj.uname}}</p>
	<p>{{ "obj.age : " + obj.age}}</p>
	<p>{{ "obj.addr : " + obj.addr}}</p>
	<p>{{ "obj.arr : " + obj.arr}}</p>
	<p>{{ "obj.arr[0] : " + obj.arr[0]}}</p>
	<p>{{ "obj.arr[1] : " + obj.arr[1]}}</p>
	<p>{{ "obj.arr[2] : " + obj.arr[2]}}</p>
	<p>{{ "obj.inner.name : " + obj.inner.name}}</p>
	<p>{{ "obj.inner.age : " + obj.inner.age}}</p>
</div>
<!-- 
obj : { "uname": "홍길동", "age": 33, "addr": "서울", "arr": [ 1, 2, 3 ] }
obj.uname : 홍길동
obj.age : 33
obj.addr : 서울
obj.arr : 1,2,3
obj.arr[0] : 1
obj.arr[1] : 2
obj.arr[2] : 3
 -->
<script>
new Vue({
	el: "#app",
	data: {
		obj: {uname:"홍길동", age:33, addr:"서울", arr:[1, 2, 3], "inner": { name: "전우치", age: 30 }}
		//	이름이 '전우치'이고, 나이는 30인 객체 'inner'를 obj에 추가한 후 출력
	}
});
</script>
</body>
</html>