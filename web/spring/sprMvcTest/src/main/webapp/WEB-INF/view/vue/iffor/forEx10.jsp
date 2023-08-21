<%@page import="com.google.gson.Gson"%>
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.simple.parser.JSONParser"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
ArrayList arr = new ArrayList<String>();
arr.add("abc");	arr.add("aac");	arr.add("zbc");	arr.add("afa");	arr.add("sfc");	arr.add("zza");
out.println("원본 : " + arr);
String jsonarr = new Gson().toJson(arr);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/style.css" />
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<style>
#vfor { text-align:left; }
#vfor th { padding:12px; border-bottom:2px solid darkhray }
#vfor td { padding:12px; }
#vfor tr:nth-of-type(even) { background-color:rgba(0, 0, 255, 0.1); }
</style>
</head>
<body>
<div id="app">
	<ul>
		<li v-for="item in arrTest">{{item}}</li>
	</ul>
	<ul>
		<li v-for="item in arrTest2">{{item}}</li>
	</ul>
	<ul>
		<li v-for="item in arrTest3">{{item}}</li>
	</ul>
</div>
<script>
new Vue({
	el : "#app",
	data : {
		arrTest : [
			<%
			for (int i = 0; i < arr.size(); i++){
				if(i > 0) out.println(",");			
			%>
			"<%=arr.get(i)%>"
			<% } %>
		],
		<%
		String str = "arrTest2 : [\"";
		for(int i = 0; i < arr.size(); i++){
			if(i > 0) str += "\",\" ";
			str += arr.get(i);
		}
		str += "\"]";
		out.println(str + ",");
		%>
		arrTest3 : <%=jsonarr %>
	}
});
</script>
</body>
</html>