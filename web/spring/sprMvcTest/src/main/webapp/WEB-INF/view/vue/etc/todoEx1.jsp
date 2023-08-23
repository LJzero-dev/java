<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/style.css" />
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<style>
.donestyle { text-decoration:line-through; color:lightgray; }
</style>
</head>
<body>
<div id="app">
	<div v-for="todo in todos">
		<label>
			<input type="checkbox" v-model="todo.done" />
			<span :class="{donestyle:todo.done}">{{todo.text}}</span>
		</label>
	</div>
	
	<!-- 추가할 todo를 입력하고 엔터를 치면 추가되게 작업 -->
	<input type="text" placeholder="할일을 입력하고 엔터" v-model.trim="todo" v-on:keyup.enter="addToDo(todo);"/>
	<p><input type="button" v-on:click="cleanToDo" value="처리완료 삭제" /></p>
	
	<p>{{remaining}} / {{todos.length}}건 처리</p>
</div>
<script>
new Vue({
	el : "#app",
	data : {
		todos : [
			{done : false, text : "회의참석"},
			{done : false, text : "사이트 작업"},
			{done : false, text : "회식"}
		],
		addText : ""
	},
	methods : {
		addToDo(val){
			if(this.todo){
				this.todos.push({done : false, text : val});
				this.todo = "";
			}
		},
		cleanToDo() {
/*			
			for(var i = 0; i < this.todos.length; i++){
				if(this.todos[i].done) {
					this.todos.splice(i,1);
				}
			}
*/
		this.todos = this.todos.filter(function(val) {
				return val.done == false;
			});
		}
	},
	computed : {
		remaining() {			
/*			
			var cnt = 0;
			for (var i = 0; i < this.todos.length; i++) {
				if (this.todos[i].done)	cnt++;
			}
			return cnt;
*/			
			return this.todos.filter(function(val) {	
				return val.done;
			}).length;
		}
	}
});
</script>
</body>
</html>