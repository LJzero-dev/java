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
 create table test(
	idx int auto_increment unique,
    num int primary key,
    name varchar(20) not null
); 
-->
<sql:setDataSource var="conn" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/mall?useUnicode=true&characterEncoding=UTF8&verifyServerCertificate=false&useSSL=false&serverTimezone=UTC" user="root" password="1234" />
<!-- 특정 DB(mall)에 연결하는 Connection 객체 conn을 생성하고 연결 완료 -->
<sql:update dataSource="${conn}">
	insert into test (num, name) values (101, '홍길동')
</sql:update>
<sql:update dataSource="${conn}">
	insert into test (num, name) values (102, '전우치')
</sql:update>
<sql:update dataSource="${conn}">
	insert into test (num, name) values (103, '임꺽정')
</sql:update>
<sql:update dataSource="${conn}">
	insert into test (num, name) values (104, '홍길동')
</sql:update>
<!-- conn으로 연결된 DB내의 test테이블에 데이터를 입력 -->

<sql:query var="rs" dataSource="${conn}" >
	select * from test
</sql:query>
<!-- select 쿼리의 결과를 ResultSet rs에 저장 -->

전체 회원 : <br />
<c:forEach var="data" items="${rs.rows}" >
	<c:out value="${data['idx']}" />
	<c:out value="${data['num']}" />
	<c:out value="${data['name']}" /><br />
</c:forEach>
<hr />
<sql:query var="rs2" dataSource="${conn}" >
	select * from test where name = ?
	<sql:param>홍길동</sql:param>
</sql:query>
이름이 '홍길동'인 회원 : <br />
<c:forEach var="data" items="${rs2.rows}" >
	<c:out value="${data['idx']}" />
	<c:out value="${data['num']}" />
	<c:out value="${data['name']}" /><br />
</c:forEach>
</body>
</html>
















