<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/style.css" />
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<style>
.test-comp {
	width:400px; background:#ffffe0; border:darkorange solid; border-radius:8px; padding:10px; 
}
</style>
</head>
<body>
<div id="app">
	<test-component my-name="홍길동"></test-component>
	<test-component my-name="전우치"></test-component>
	<test-component></test-component>
</div>
<script>
var TestComponent = {
	template : '<p class="test-comp"> 나는 {{myName}} 입니다.</p>',
	props : {	//	html 태그에서 값을 받아 프로퍼티에 전달하는 옵션
		myName : String	//	받아올 값의 데이터 타입을 입력
			//	nyMane : javascript 내에서 사용하므로 카멜식 표기이며,
			//	my-name : html 에서 사용하므로 케밥 표기임
	},
	created() {	//	인스턴스가 생성된 직후 실행되는 메소드
		if (this.myName == null) {
			this.myName = "이름없음";
		}
	}
}

new Vue({
	el : "#app",
	components : {
		'test-component' : TestComponent
	}
});
</script>
</body>
</html>