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
	<input type="file" v-on:change="onFileChange" />
	<!-- file 컨트롤이 바뀌면(v-on:change) onFileChange 메소드 호출 -->
	<p>읽어 들인 데이터 : {{loadData}}</p>
</div>
<script>
new Vue({
	el : "#app",
	data : {
		loadData : ""
	},
	methods : {
		onFileChange(e) {	//	file 컨트롤로 새 파일을 불러올 경우 동작하는 메소드
			var file = e.target.files[0];	//	읽어온 파일을 file에 저장
			if (file) {	//	file이 있으면
				var reader = new FileReader();
				var vm = this;	//	reader.onload를 사용할 경우 this.을 바로 쓰지 않고 다른 변수에 담아 처리해야 함
				reader.readAsText(file);	//	특정 파일을 텍스트 형식으로 읽어들이는 기능으로 결과를 FileReader.result 프로퍼티에 저장함
				//	두번째 인수로 인코딩을 지정할 수 있으며, 색략시 'UTF-8'로 지정됨
				
				reader.onload = function(e) {	//	FileReader.onload : readAsText() 메소드로 파일 읽기가 성공적으로 완료되었을 때 실행되는 이벤트 핸들러
					vm.loadData = JSON.parse(e.target.result);	//	readAsText()를 통해 텍스트로 읽어들인 내용을 json형식의 객체로 만들어 저장
				}
			}
		}
	}
});
</script>
</body>
</html>