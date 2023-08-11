<%@page import="java.util.ArrayList"%>
<%@page import="vo.PageInfo"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
request.setCharacterEncoding("utf-8");
ArrayList<JSONObject> dataList = (ArrayList<JSONObject>)request.getAttribute("dataList");
PageInfo pi = (PageInfo)request.getAttribute("pi");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width="800" cellpadding="5" border="1">
	<tr>
		<th width="30%">국가 영문명</th>
		<th width="20%">ISO 국가코드</th>
		<th width="20%">인구수</th>
		<th width="10%">측정년도</th>
		<th width="10%">측정월</th>
		<th width="*">증감율</th>
	</tr>
	<% 
	if(dataList.size() > 0){
	for(JSONObject jo : dataList) {
	%>
	<tr align="center">
		<td><%=jo.get("country_eng_nm") %></td>
		<td><%=jo.get("country_iso_alp2") %></td>
		<td><%=jo.get("popltn_cnt") %></td>
		<td><%=jo.get("popltn_year") %></td>
		<td><%=jo.get("popltn_month") %></td>
		<td><%=jo.get("popltn_growth") %></td>
	</tr>
<%
	}
} else {
	out.println("<tr><td colspan='6' align='center'>");
	out.println("데이터가 없습니다.</td></tr>");
}
if (dataList.size() > 0) {
	int cpage = pi.getCpage();	int psize = pi.getPsize();
	int bsize = pi.getBsize();	int rcnt = pi.getRcnt();
	int pcnt = rcnt / psize;	if(rcnt % psize > 0)	pcnt++;
	int spage = (cpage - 1) / bsize * bsize + 1;
	out.println("<tr><td colspan='6' align='center'>");
	if (cpage == 1) {
		out.println("[처음]&nbsp;&nbsp;&nbsp;[이전]&nbsp;&nbsp;");
	} else {
		out.println("<a href='openApi1?cpage=1'>[처음]</a>&nbsp;&nbsp;&nbsp;");
		out.println("<a href='openApi1?cpage=" + (cpage - 1) + "'>[이전]</a>&nbsp;&nbsp;");
	}
	for (int i = spage, j = 1 ; i <= pcnt && j <= bsize ; i++, j++) {
		if (i == cpage)
			out.println("&nbsp;<strong>" + i + "</strong>&nbsp;");
		else
			out.println("&nbsp;<a href='openApi1?cpage=" + i + "'>" + i + "</a>&nbsp;");
	}

	if (cpage == pcnt) {
		out.println("&nbsp;&nbsp;[다음]&nbsp;&nbsp;&nbsp;[마지막]");
	} else {
		out.println("&nbsp;&nbsp;<a href='openApi1?cpage=" + (cpage + 1) + "'>[다음]</a>");
		out.println("&nbsp;&nbsp;&nbsp;<a href='openApi1?cpage=" + pcnt + "'>[마지막]</a>");
	}
	out.println("</td></tr>");
}
%>
</table>
</body>
</html>