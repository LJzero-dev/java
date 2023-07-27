<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>JSTL에서의 문자열 함수 사용2</h2>
\${fn:length("abcd efg")} : ${fn:length("abcd efg")}
<br /><!-- 8 -->
\${fn:toUpperCase("aBcD eFg")} : ${fn:toUpperCase("aBcD eFg")}
<br /><!-- ABCD EFG -->
\${fn:toLowerCase("aBcD eFg")} : ${fn:toLowerCase("aBcD eFg")}
<br /><!-- abcd efg -->
<hr />
\${fn:substring("aBcD eFg", 2, 6)} : ${fn:substring("aBcD eFg", 2, 6)}
<br /><!-- cD e -->
\${fn:substringBefore("aBcD eFg", "c")} : ${fn:substringBefore("aBcD eFg", "c")}
<br /><!-- aB -->
\${fn:substringAfter("aBcD eFg", "c")} : ${fn:substringAfter("aBcD eFg", "c")}
<br /><!-- D eFg -->
<hr />
\${fn:trim("      aBcD efg      ")} : ${fn:trim("      aBcD efg      ")}
<br /><!-- aBcD efg -->
\${fn:replace("aBcD efg", "c", "z")} : ${fn:replace("aBcD efg", "c", "z")}
<br><!-- aBzD efg -->
\${fn:indexOf("aBcD efg", "e")} : ${fn:indexOf("aBcD efg", "e")}
<br /><!-- 5 -->
<hr />
\${fn:startsWith("aBcD efg", "abc")} : ${fn:startsWith("aBcD efg", "abc")}
<br /><!-- false -->
\${fn:endsWith("aBcD efg", "g")} : ${fn:endsWith("aBcD efg", "g")}
<br><!-- true -->
<hr />
\${fn:contains("aBcD eFg", "cd")} : ${fn:contains("aBcD eFg", "cd")}
<br /><!-- false -->
\${fn:containsIgnoreCase("aBcD eFg", "cd")} : ${fn:containsIgnoreCase("aBcD eFg", "cd")}
<br /><!-- true -->
\${fn:escapeXml("<a> Tag is Link")} : ${fn:escapeXml("<a> Tag is Link")}
<br /><!-- &lt;a&gt; Tag is Link -->
<hr />
<!-- "ab-cd-ef-gh" 문자열을 하이픈을 기준으로 arr배열로 생성 후 출력 -->
<c:set var="arr" value="${fn:split('ab-cd-ef-gh', '-')}" />
<c:forEach items="${arr}" var="v">
	${v}<br />
</c:forEach> 
<!-- arr 배열을 쉼표를 기준으로 하나의 문자열로 생성 후 출력 -->
\${fn:join(arr, ',')} : ${fn:join(arr, ',')} <!-- ab,cd,ef,gh -->



</body>
</html>