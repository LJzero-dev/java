<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%
String driver = "com.mysql.cj.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/mall?useUnicode=true&characterEncoding=UTF8&verifyServerCertificate=false&useSSL=false&serverTimezone=UTC";
Connection conn = null;	// DB와의 연결을 시켜주는 객체 선언
Statement stmt = null;	// DB로 쿼리를 보내는 역할을 하는 객체 선언
ResultSet rs = null;
ResultSetMetaData rsmd = null;

try {
	Class.forName(driver);
	conn = DriverManager.getConnection(url, "root", "1234");
	stmt = conn.createStatement();
	
	
	String sql = "select mi_id, mi_name, concat(mi_gender,'자') 'gender', concat(left(mi_birth,4), '년 ', mid(mi_birth, 6, 2), '월 ', right(mi_birth, 2), '일') 'birth', mi_email, mi_date from t_member_info";
	
	stmt = conn.createStatement();
	stmt.executeQuery(sql);
	rs = stmt.executeQuery(sql);
	rsmd = rs.getMetaData();
	
} catch (Exception e) {
	out.println("회원 목록 쿼리 실행시 문제가 발생했습니다.");
	e.printStackTrace();
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>받아온 컬럼 개수 : <%=rsmd.getColumnCount() %></h3>
<%
for (int i = 1; i <= rsmd.getColumnCount(); i++) {
	out.println(i + "번째 컬럼 명 : " + rsmd.getColumnName(i) + "/");
	out.println("컬럼 레이블 : " + rsmd.getColumnLabel(i) + "/");
	out.println("컬럼 자료형 : " + rsmd.getColumnTypeName(i) + "<br />");
}
%>
</body>
</html>
<%
try {
	rs.close(); 
	stmt.close();
	conn.close();
} catch (Exception e) {
	e.printStackTrace();
} finally {
	try {
		rs.close();
		stmt.close();
	} catch (Exception e) {
		e.printStackTrace();	
	}
}
%>