<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
session.removeAttribute("loginInfo");	// loginInfo 라는 속성을 삭제
										// 로그인 정보 외에 남겨둬야 하는 세션 정보가 있을 경우 removeAttribute() 사용
// session.invalidate();				// 모든 세션 정보를 삭제(삭제 후 세션을 새롭게 부여)										
response.sendRedirect("sessMain.jsp");
%>