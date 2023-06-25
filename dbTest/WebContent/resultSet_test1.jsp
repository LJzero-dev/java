<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%
String driver = "com.mysql.cj.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/mall?useUnicode=true&characterEncoding=UTF8&verifyServerCertificate=false&useSSL=false&serverTimezone=UTC";
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;

try {
	Class.forName(driver);
	conn = DriverManager.getConnection(url, "root", "1234");
	stmt = conn.createStatement();
	
	
	String sql = "select mi_id, mi_name, mi_gender, mi_birth, mi_point, mi_date, mi_status from t_member_info";
	
	stmt = conn.createStatement();
	rs = stmt.executeQuery(sql);
	
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
<h2>회원 목록</h2>
<table border="1" cellpadding="5">
<tr>
<th>번호</th><th>아이디</th><th>이름</th><th>성별</th><th>생일</th><th>포인트</th><th>가입일</th><th>상태</th>
</tr>
<%
int num = 1;
String birth = null;
if (rs.next()) {
	do {
		birth = rs.getString("mi_birth").substring(0,4) + "년 " + rs.getString("mi_birth").substring(5,7) + "월 " + rs.getString("mi_birth").substring(8) + "일";
		/*
		String status = "정상 회원";
		if (rs.getString("mi_status").equals("b")) {
			status = "휴면 계정";
		} else if(rs.getString("mi_status").equals("c")) {
			status = "탈퇴 회원";
		}
		*/
%>
	<tr align="center">
	<td><%=num %></td>
	<td><%=rs.getString("mi_id") %></td>
	<td><%=rs.getString("mi_name") %></td>
	<td><%=rs.getString("mi_gender") %>자</td>
	<td><%=birth %></td>
	<td><%=rs.getString("mi_point") %></td>
	<td><%=rs.getString("mi_date") %></td>
	<td><%=rs.getString("mi_status").equals("a") ? "정상 회원" : rs.getString("mi_status").equals("b") ? "휴면 계정" : "탈퇴 회원" %></td>
	</tr>	
<%
		num++;
	} while (rs.next());
} else {
	out.println("<tr><td colspan='8' align='center'>결과가 없습니다.</td></tr>");
}
%>
</table>
</body>
</html>
<%
try {
	rs.close(); 
	stmt.close();
	conn.close();
} catch (Exception e) {
	e.printStackTrace();
}
%>