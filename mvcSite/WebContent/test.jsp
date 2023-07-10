<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>
<body>
<%
/* 	String tmp = "11:22";
	String[] arr = tmp.split(":");
	for(String str : arr) {
		out.println(str + "<br />");
	} */
%>
<script>
function a() {
	$.ajax({
		type : "get",
		url : "/mvcSite/test",
		dataType : "html",
		success: function(data) {
        	$("#listDiv").html(data);
          }
	});
}
</script>
<button id="listButton" onclick="a();">추가</button>
<div id="listDiv" style="width:80px; height:80px; background-color:green;">
aa
</div>
</body>
</html>