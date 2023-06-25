<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String kind = request.getParameter("kind");

String schtype = request.getParameter("schtype");
String keyword = request.getParameter("keyword");
String t1 = request.getParameter("t1");
String t2 = request.getParameter("t2");

String name = request.getParameter("name");
String e1 = request.getParameter("e1");
String e2 = request.getParameter("e2");
String email = e1 + "@" + e2;

String g = request.getParameter("gender");
String gender = "성별없음";
if (g != null)	gender = g.equals("m") ? "남자" : "여자";

String[] arrHobby = request.getParameterValues("hobby");
String hobby = "취미없음";
if (arrHobby != null) {
	hobby = "";
	for (int i = 0; i < arrHobby.length ; i++) {
		hobby += ", " + arrHobby[i];
	}
	hobby = hobby.substring(2);
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<% if (kind.equals("a")) { %>
검색조건 : <%=schtype %> / 검색어 : <%=keyword %><br />
t1 : <%=t1 %> / t2 : <%=t2 %>
<%} else if (kind.equals("b")) {%>
이름 : <%=name %> / 이메일 : <%=email %><br />
v1 : <%=t2 %> / v2 : <%=t2 %>

<%} else if (kind.equals("c")) {%>
성별 : <%=gender %> / 취미 : <%=hobby %>
<% } %>
</body>
</html>