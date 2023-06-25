<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%
String driver = "com.mysql.cj.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/mall?useUnicode=true&characterEncoding=UTF8&verifyServerCertificate=false&useSSL=false&serverTimezone=UTC";
Connection conn = null;	// DB와의 연결을 시켜주는 객체 선언
CallableStatement cstmt = null;

try {
	Class.forName(driver);
	conn = DriverManager.getConnection(url, "root", "1234");
	String sql = "{call sp_free_manage(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
	
	cstmt = conn.prepareCall(sql);
	cstmt.setString(1, "i");
	cstmt.setInt(2, 3);
	cstmt.setString(3, "y");
	cstmt.setString(4, "test1");
	cstmt.setString(5, "");
	cstmt.setString(6, "3번째 글입니다.");
	cstmt.setString(7, "3번째 글 내용입니다.");
	cstmt.setString(8, "127.0.0.1");
	cstmt.setString(9, "y");
	
	int result = cstmt.executeUpdate();
	if (result == 1) {
		out.println("정상적으로 등록되었습니다.");
	} else {
		out.println("등록에 실패했습니다.");
	}
	
} catch (Exception e) {
	out.println("자유게시판 글 등록시 문제가 발생했습니다.");
	e.printStackTrace();
} finally {
	try {
		cstmt.close();
		conn.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
%>