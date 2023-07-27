<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Number Format</h2>
<h3>parseNumber : 789.970</h3>
<c:set var="amount" value="789.970" />
<fmt:parseNumber var="j" type="number" value="${amount}" />
amount : ${j}<br />
<fmt:parseNumber var="j" type="number" integerOnly="true" value="${amount}" />
amount : ${j}<br />
<hr />
<h3>numberFormat : 9850.14115</h3>
<c:set var="amount" value="9850.14115" />
<p>type="currency" :<fmt:formatNumber value="${amount}" type="currency"/></p>
<p>type="currency" groupingUsed="true" :<fmt:formatNumber value="${amount}" type="currency" groupingUsed="true"/></p>
<p>type="currency" groupingUsed="true" maxIntegerDigits="3" :<fmt:formatNumber value="${amount}" type="currency" groupingUsed="true" maxIntegerDigits="3"/></p>
<p>type="currency" groupingUsed="true" maxFractionDigits="6" :<fmt:formatNumber value="${amount}" type="currency" groupingUsed="true" maxFractionDigits="6"/></p>
<p>type="currency" groupingUsed="true" pattern="###.###$" :<fmt:formatNumber value="${amount}" type="currency" groupingUsed="true" pattern="###.###$"/></p>

<!-- numberFormat : 9850.14115
type="currency" :￦9,850

type="currency" groupingUsed="true" :￦9,850

type="currency" groupingUsed="true" maxIntegerDigits="3" :￦850

type="currency" groupingUsed="true" maxIntegerDigits="6" :￦9,850

type="currency" groupingUsed="true" pattern="###.###$" :9850.141$ -->
<hr />
<h2>Date Format</h2>
<c:set var="now" value="<%=new java.util.Date() %>" />
<!-- jstl에서는 time 패키지를 지원하지 않아 Date클래스를 사용해야 함 -->
<p>normal : <fmt:formatDate value="${now}" /></p>
<p>timeStyle-default : <fmt:formatDate value="${now}" type="both" dateStyle="default"  /></p>
<p>timeStyle-short : <fmt:formatDate value="${now}" type="both" dateStyle="short"  /></p>
<p>timeStyle-medium : <fmt:formatDate value="${now}" type="both" dateStyle="medium"  /></p>
<p>timeStyle-long : <fmt:formatDate value="${now}" type="both" dateStyle="long"  /></p>
<p>timeStyle-full : <fmt:formatDate value="${now}" type="both" dateStyle="full"  /></p>
<p>timeStyle-pattern : <fmt:formatDate value="${now}" type="both" pattern="yyyy년 MM월 dd일 hh시mm분ss초"  /></p>

<!-- normal : 2023. 7. 26

timeStyle-default : 2023. 7. 26 오전 10:51:46

timeStyle-short : 23. 7. 26 오전 10:51:46

timeStyle-medium : 2023. 7. 26 오전 10:51:46

timeStyle-long : 2023년 7월 26일 (수) 오전 10:51:46

timeStyle-full : 2023년 7월 26일 수요일 오전 10:51:46

timeStyle-pattern : 2023년 07월 26일 10시51분46초 -->

</body>
</html>