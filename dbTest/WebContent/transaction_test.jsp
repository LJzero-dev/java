<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%
String driver = "com.mysql.cj.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/mall?useUnicode=true&characterEncoding=UTF8&verifyServerCertificate=false&useSSL=false&serverTimezone=UTC";
Connection conn = null;
Statement stmt = null;

try {
	Class.forName(driver);
	conn = DriverManager.getConnection(url, "root", "1234");	
	
	String sql = "update t_member_info set mi_email = 'aa@aa.com' where mi_id = 'test3'";

	conn.setAutoCommit(false);	// 트랜잭션의 시작
	
	stmt = conn.createStatement();
	int result = stmt.executeUpdate(sql);
	if (result == 1) {
		conn.commit();
		out.print("쿼리를 commit() 시켯습니다");
	} else {
		conn.rollback();
		out.print("쿼리를 rollback() 시켯습니다");
	}	
	
	conn.setAutoCommit(true);	// 트랜잭션의 종료
	
} catch (Exception e) {
	out.println("트랜잭션 사용시 문제가 발생했습니다.");
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