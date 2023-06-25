<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="beanTest" class="test.BeanTest" scope="page"></jsp:useBean>
<!-- test패키지에 있는 BeanTest클래스의 인스턴스 beanTest를 생성하여 page영역(현재 페이지)에서 사용하겠다는 의미 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>자바빈 사용예제</h2>
이름 : <%=beanTest.getName() %><br />
성별 : <%=beanTest.getGender() %>
<hr />
<!-- name을 '성춘향', gender를 '여자'로 변경 후 출력 -->
<% 
// beanTest.setName("성춘향");	beanTest.setGender("여자");
%>
<jsp:setProperty name="beanTest" property="name" value="성춘향" />
<jsp:setProperty name="beanTest" property="gender" value="여자" />
이름 : <jsp:getProperty name="beanTest" property="name" /><br />
성별 : <jsp:getProperty name="beanTest" property="gender" />

<%//beanTest.getName() %><br />
<%//beanTest.getGender() %>
</body>
</html>