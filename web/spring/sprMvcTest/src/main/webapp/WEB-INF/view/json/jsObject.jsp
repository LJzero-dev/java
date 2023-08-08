<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.6.4.js"></script>
<script>
// 자바스크립트에서의 객체 생성 : 중괄호로 묶으며 콜론으로 키와 값을 구분함
var obj = {
	"name":"홍길동", "age":33,
	func:function(val) {
		return val + "test";
	}
};
/* alert(obj.name + "::" + obj.age + obj.func("aaa")); */
function show() {
	$("#name").html("<strong>" + obj.name + "</strong>");
	$("#age").html("<strong>" + obj.age + "</strong>");
	$("#func").html("<strong>" + obj.func("kkk") + "</strong>");
}
</script>
</head>
<body>
객체 : {	"name":"홍길동", "age":33,func:function(val) {return val + "test";}};
<hr />
obj.name : <span id="name"></span><br />
obj.age : <span id="age"></span><br />
obj.func("kkk") : <span id="func"></span><br />
<input type="button" value="실행" onclick="show();" />
</body>
</html>