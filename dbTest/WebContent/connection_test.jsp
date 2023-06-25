<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
Connection conn = null;
String driver = "com.mysql.cj.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/mall?useUnicode=true&characterEncoding=UTF8&verifyServerCertificate=false&useSSL=false&serverTimezone=UTC";
boolean isConnect = false;

try {
	Class.forName(driver);
	conn = DriverManager.getConnection(url, "root", "1234");
	isConnect = true;
} catch (Exception e) {
	isConnect = false;
	e.printStackTrace();
} finally {
	try {
		conn.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>DB연결 <%=(isConnect) ? "성공" : "실패" %></h2>
</body>
</html>