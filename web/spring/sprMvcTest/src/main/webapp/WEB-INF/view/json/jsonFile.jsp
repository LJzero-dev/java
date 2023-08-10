<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.6.4.js"></script>
<script>
function fileTest() {
	$.getJSON("${pageContext.request.contextPath}/resources/json/test.json", function(data){	//	해당 위치의 json파일을 스캔한 데이터를 함수의 'data' 임수로 넣음		
		for(key in data){
			/* console.log("id : " + data[key].id + " / name : " + data[key].name); */
			$("#jsonData").append("id : " + data[key].id + " / name : " + data[key].name + "<br />");
		}		
	});
}
function ajaxTest(){
	$.ajax({
		url : "${pageContext.request.contextPath}/resources/json/test.json",
		dataType : "json",
		success : function(data){		
			for(key in data){	//	data안의 한 요소를 key에 저장 - {"키1" :"값1","키2":"값2,..."}
				$("#jsonAjax").append("id : " + data[key].id + " / name : " + data[key].name + "<br />");
			}			
		}
	});
}
</script>
</head>
<body>
<input type="button" value="데이터 보기" onclick="fileTest();" />
<div id="jsonData"></div>
<hr />
<input type="button" value="ajax로 보기" onclick="ajaxTest();" />
<div id="jsonAjax"></div>
</body>
</html>