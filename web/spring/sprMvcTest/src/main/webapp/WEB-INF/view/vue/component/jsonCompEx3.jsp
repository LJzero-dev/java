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
	<div v-for="item in dataArray" :key="item.title" >
		<my-quiz :object="item"></my-quiz>
	</div>
	<br />
	<input type="button" v-if="showBtn" v-on:click="answerQuestion" value="정답 제출" />
	<br />
	<p  v-if="showResult">총점 : {{score}}</p>
	<p><input type="file" v-on:change="loadData" /></p>
</div>
<script>
var MyQuiz = {
		props : ["object"],
		template : `
		<div style="width:600px; backgroundColor:#ffddaa;">
		<p style="backgroundColor:#ffa05e;">
		문제 {{object.no}}. {{object.question}} (배점 : {{object.point}})
		</p>
		정답 : 
		<label><input type="radio" v-model="object.user_answer" value="true" /> O</label>
		<label><input type="radio" v-model="object.user_answer" value="false" /> X</label>
		</div>
		`
}

new Vue({
	el : "#app",
	data : {
		dataArray : [],
		showBtn : false,
		showResult : false,
		score : 0
	},
	components : {
		"my-quiz" : MyQuiz
	},
	methods : {
		loadData(e) {
			var file = e.target.files[0];
			if (file) {
				var reader = new FileReader();
				var vm = this;
				
				reader.readAsText(file);
				
				reader.onload = function(e) {
					vm.dataArray = JSON.parse(e.target.result);
				}
				this.showBtn = true;	//	퀴즈가 로딩되면 [정답 제출] 버튼이 보이게 해줌
			}
		},
		answerQuestion() {	//	[정답 제출] 버튼 클릭 시 채점을 하는 메소드
			var s = 0;
			for(var i = 0; i < this.dataArray.length; i++) {
				if(this.dataArray[i].answer == this.dataArray[i].user_answer) {
					s += this.dataArray[i].point;
				}
			}
			this.score = s;
			this.showResult = true;	//	[정답 제출] 버튼이 클릭되면 채점 후 총점을 보이게 해줌
		}
	}
});
</script>
</body>
</html>