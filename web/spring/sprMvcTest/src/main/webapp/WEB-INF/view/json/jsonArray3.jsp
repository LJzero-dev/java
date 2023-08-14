<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.json.simple.*" %>
<%@ page import="org.json.simple.parser.*" %>
<%
// 2 depth 위치를 가지는 제이슨 형태에 배열이 존재하는 경우
/*
{
	"resultData":{
		"jsonList":[
			{
				"key1":"value1",
				"key2":"value2"
			},
			{
				"key3":"value3",
				"key4":"value4"
			}
		],
		"listCount":2
	},
	"resultCode":"200",
	"resultContent":"정상응답"
}
*/
String jsonStr = "{" + 
"	\"resultData\":{" + 
"		\"jsonList\":[" + 
"			{" + 
"				\"key1\":\"value1\"," + 
"				\"key2\":\"value2\"" + 
"			}," + 
"			{" + 
"				\"key3\":\"value3\"," + 
"				\"key4\":\"value4\"" + 
"			}" + 
"		]," + 
"		\"listCount\":2" + 
"	}," + 
"	\"resultCode\":\"200\"," + 
"	\"resultContent\":\"정상응답\"" + 
"}";

// 최상위 json
JSONParser p = new JSONParser();
JSONObject depth1Obj = new JSONObject();	// 최초 깊이 1의 제이슨 객체
depth1Obj = (JSONObject)p.parse(jsonStr);
out.println("전체 데이터 : " + depth1Obj.toJSONString() + "<hr />");

JSONObject depth2Obj = (JSONObject)depth1Obj.get("resultData");
// 깊이 1의 데이터들 중 resultData에 속하는 깊이 2의 제이슨 객체
JSONArray jsonArr = new JSONArray();	// 깊이 3에 위치하는 배열을 저장할 객체
jsonArr = (JSONArray)depth2Obj.get("jsonList");

out.println("<hr />jsonList의 데이터들<br />");
JSONObject tmp = new JSONObject();
// jsonArr에 있는 제이슨 객체를 저장할 임시 제이슨 객체
for (int i = 0 ; i < jsonArr.size() ; i++) {
	tmp = (JSONObject)jsonArr.get(i);
	out.println((i + 1) + "번째 데이터 : " + tmp.toJSONString() + "<br />");
}
%>
