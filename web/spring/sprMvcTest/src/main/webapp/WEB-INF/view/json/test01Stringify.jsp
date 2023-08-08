<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.6.4.js"></script>
<script>
var dog = ["진돗개", "풍산개", "삽살개"];	// 자바스크립트 qoduf 객체
function showArray() {
	var arrStr = JSON.stringify(dog); // 자바사크립트 객체 dog를 JSON형 문자열로 변환
	$("#arr").text(arrStr);
	// ["진돗개","풍산개","삽살개"]
}

var jindo = {
		name : "jindo", color : "white",
		weight : null, birth : new Date(),
		cry : function() {
			return "멍멍!!";
		}
};

function showObj1() {
	var str = JSON.stringify(jindo);
	$("#obj1").text(str);
	// {"name":"jindo","color":"white","weight":null,"birth":"2023-08-08T05:45:47.214Z"}
	// 함수는 데이터가 아니므로 문자열로 변환이 되지 않음
}

function showObj2() {
	var str = JSON.stringify(jindo, ["color", "birth"]);
	// stringify() 함수의 replacer 파라미터에 보고 싶ㅇ느 요소의 이름들만 넣으면 해당 요소들만 문자열로 변환되어 들어감
	$("#obj2").text(str);
}

function showObj3() {
	var str = JSON.stringify(jindo, function test(key, value) {
//		return value;	// 전체 데이터 리턴
		return key == "name" ? "pungsan" : value;
		// name이 키로 들어오면 값을 "pungsan"으로 변경하고 나머지는 그대로 출력
		//	{"name":"pungsan","color":"white","weight":null,"birth":"2023-08-08T06:21:00.754Z"}
	});
	$("#obj3").text(str);
}
</script>
</head>
<body>
<p id="arr"></p>
<input type="button" value="배열 보이기" onclick="showArray();" />
<hr />
<p id="obj1"></p>
<input type="button" value="배열 보이기1" onclick="showObj1();" />
<hr />
<p id="obj2"></p>
<input type="button" value="객체 보이기2" onclick="showObj2();" />
<hr />
<p id="obj3"></p>
<input type="button" value="객체 보이기3" onclick="showObj3();" />
<hr />
</body>
</html>