<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%
String driver = "com.mysql.cj.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/mall?useUnicode=true&characterEncoding=UTF8&verifyServerCertificate=false&useSSL=false&serverTimezone=UTC";
Connection conn = null;	// DB와의 연결을 시켜주는 객체 선언
Statement stmt = null;	// DB로 쿼리를 보내는 역할을 하는 객체 선언

try {
	Class.forName(driver);
	conn = DriverManager.getConnection(url, "root", "1234");
	stmt = conn.createStatement();
	
	String sql = "delete from t_admin_info where ai_id = 'admin2'";
	int result = stmt.executeUpdate(sql);
	if (result == 1) {
		out.println("정상적으로 삭제되었습니다.");
	} else {
		out.println("삭제에 실패했습니다.");
	}
	
} catch (Exception e) {
	out.println("관리자 삭제시 문제가 발생했습니다.");
	e.printStackTrace();
} finally {
	try {
		stmt.close();
		conn.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
%>