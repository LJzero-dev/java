<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
mall DB의 t_member_info 테이블에서 아이디, 이름, 생일, 전화번호를 가져와서 출력
단, 데이터가 없을 경우 '등록된 회원이 없습니다.' 라고 출력
rs.rowCount == 0	// 데이터가 없으면
 -->
 <sql:setDataSource var="conn" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/mall?useUnicode=true&characterEncoding=UTF8&verifyServerCertificate=false&useSSL=false&serverTimezone=UTC" user="root" password="1234" />
<sql:query var="rs" dataSource="${conn}" >
	select mi_id, mi_name, mi_birth, mi_phone from t_member_info
</sql:query>
<c:if test="${rs.rowCount == 0}">등록된 회원이 없습니다.</c:if><!-- 받아온 레코드가 없을 경우 -->
<c:if test="${rs.rowCount > 0}">
	총 회원수 : ${rs.rowCount} 명<br />
	<c:forEach var="data" items="${rs.rows}" ><!-- 받아온 레코드가 있을 경우 -->
		<c:out value="${data['mi_id']}" /> |
		<c:out value="${data['mi_name']}" /> |
		<c:out value="${data['mi_birth']}" /> |
		<c:out value="${data['mi_phone']}" /><br />
	</c:forEach>
</c:if>
<hr />
<c:choose>
	<c:when test="${rs.rowCount == 0}">등록된 회원이 없습니다.</c:when>
	<c:otherwise>
		총 회원수 : ${rs.rowCount} 명<br />
		<c:forEach var="data" items="${rs.rows}" ><!-- 받아온 레코드가 있을 경우 -->
			<c:out value="${data['mi_id']}" /> |
			<c:out value="${data['mi_name']}" /> |
			<c:out value="${data['mi_birth']}" /> |
			<c:out value="${data['mi_phone']}" /><br />
		</c:forEach>
	</c:otherwise>
</c:choose>
</body>
</html>