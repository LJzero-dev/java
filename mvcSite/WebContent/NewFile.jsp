<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/_inc/inc_head.jsp" %>
<%
request.setCharacterEncoding("utf-8");
ArrayList<ProductCtgrBig> bigList = (ArrayList<ProductCtgrBig>)request.getAttribute("bigList");
ArrayList<ProductCtgrSmall> smallList = (ArrayList<ProductCtgrSmall>)request.getAttribute("smallList"); 

%>
	

</body>
</html>