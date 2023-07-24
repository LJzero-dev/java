<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL Test View</title>
</head>
<body>
<h2>EL Test View</h2>
sessTest : <%=session.getAttribute("sessTest") %><br />
이름 : <%=request.getParameter("uname") %><br /><hr />
<!-- EL을 이용하여 특정 영역의 값을 출력 -->
sessTest : ${sessionScope.sessTest}<br />
<!-- EL에 있는 내장객체들 중 sessionScope안에 들어있는 sessTest라는 attribute의 값을 추출하여, 출력 --> 
이름 : ${param.uname}
<hr />
</body>
</html>