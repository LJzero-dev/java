<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.6.4.js"></script>
<script>
/* 
name이 누렁이, family가 시골잡종, age가 1, weight가 2.14인 JSON형식의 문자열 생성
*/
var data = '{"name":"누렁이","family":"시골잡종","age":1,"weight":2.14}';

function parse() {
	var obj = JSON.parse(data);	// JSON형식의 문자열을 자바스크립트 객체로 변환함
	$("#show1").text(obj.name + "::" + obj.family);
}
var jindo = {name : "jindo", color : "white",weight : null, birth : new Date(),
		cry : function() {
			return "멍멍!!";
		}
};
var str = JSON.stringify(jindo);
function showStr() {
	var obj = JSON.parse(str);
	// JSON형식의 문자열(str)을 자바스크립트 객체로 변환
	$("#obj1").text(obj);
	// [object Object]
	console.log(obj);
}

function showFunc() {
	var obj = JSON.parse(str);
	$("#obj2").text(jindo.cry());	// 멍멍!
	$("#obj2").text(obj.cry());	//	error : obj.cry is not a function
	// 문자열로 변환한 뒤 객체로 만들었기 때문에 함수는 없음
}

function showDate1() {	
	var obj = JSON.parse(str);
	$("#obj3").text(jindo.birth.getDate());	//	8
	$("#obj3").text(obj.birth.getDate());	// error : obj.birth.getDate is not a function 문자열로 변환한 뒤 객체로 만들었기 때문에 birth도 문자열이 됨	
}

function showDate2() {	
	var obj = JSON.parse(str, function test(key, value) {
		// return value;
		return key == "birth" ? new Date(value) : value;
	});
	console.log(obj);
	$("#obj4").text(jindo.birth.getDate());	//	8
	$("$obj4").text(obj.birth.test());		//	8
}
</script>
</head>
<body>
<p id="show1"></p>
<input type="button" value="parse" onclick="parse();" />
<hr />
<p id="obj1"></p>
<input type="button" value="문자열 보이기" onclick="showStr();" />
<hr />
<p id="obj2"></p>
<input type="button" value="함수 보이기" onclick="showFunc();" />
<hr />
<p id="obj3"></p>
<input type="button" value="날짜 보이기1" onclick="showDate1();" />
<hr />
<p id="obj4"></p>
<input type="button" value="날짜 보이기2" onclick="showDate2();" />
<hr />
</body>
</html>