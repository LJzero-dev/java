<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.parser.JSONParser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
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

%>