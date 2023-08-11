<%@page import="java.util.ArrayList"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); 
JSONArray dataList = (JSONArray)request.getAttribute("dataList");
ArrayList<JSONObject> dataList2 = (ArrayList<JSONObject>)request.getAttribute("dataList"); 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
/* if (dataList.size() > 0){
	for(int i = 0; i < dataList.size(); i++){
		out.println(((JSONObject)dataList.get(0)).get("html_origin_cn"));
	}
} else {
	out.println("데이터가 없습니다");
} */
if (dataList2.size() > 0){
	for(JSONObject jo : dataList2){
		out.println(jo.get("html_origin_cn"));
	}
} else {
	out.println("데이터가 없습니다");
}
%>
</body>
</html>