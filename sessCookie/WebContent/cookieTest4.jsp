<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%

// 받아온 language값을 'language'라는 이름의 쿠키로 저장(만료기간 하루)
Cookie cookie = new Cookie("language", request.getParameter("language"));
cookie.setMaxAge(60 * 60 * 24);
response.addCookie(cookie);
%>
<script>
location.replace("cookieTest3.jsp");
</script>