<%@page import="vo.MemberInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.time.*" %>
<%
request.setCharacterEncoding("utf-8");
MemberInfo mi = (MemberInfo)session.getAttribute("loginInfo");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#agreement { width:500px; height:100px; overflow:auto; }
.pline { width:500px }
#fontBlue { font-weight:bold; color:blue; }
#fontRed { font-weight:bold; color:red; }
</style>
<script src="${pageContext.request.contextPath}/resources/js/date_change.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.6.4.js"></script>
<script>
	$(document).ready(function() {
		$("#e2").change(function() {
			if ($(this).val == "") {
				$("#e2").val("");
			} else if ($(this).val() == "direct") {
				$("#e3").val("");	$("#e3").focus();
			} else {
				$("#e3").val($(this).val());
			}
		});
	});
</script>
</head>
<body>
<h2>회원 정보 변경 폼</h2>
<form name="frmJoin" action="memberUp" method="post">
	<p class="pline">아이디 : <%=mi.getMi_id() %></p>
	<p class="pline">이름 : <%=mi.getMi_name() %></p>
	<p class="pline">성별 : <%=mi.getMi_gender() %></p>
	<p class="pline">생년월일 : <%=mi.getMi_birth() %></p>
	<p class="pline">휴대폰 : 010 - 
		<input type="text" name="p2" size="4" maxlength="4" value="<%=mi.getMi_phone().substring(4,8) %>" /> - 
		<input type="text" name="p3" size="4" maxlength="4" value="<%=mi.getMi_phone().substring(9,13) %>" />
	</p>
	<p class="pline">이메일 : 
		<input type="text" name="e1" id="e1" size="10" value="<%=mi.getMi_email().substring(0,mi.getMi_email().indexOf('@')) %>" /> @ 
		<select name="e2" id="e2">
			<option value="">도메인 선택</option>
			<option value="naver.com" <%=(mi.getMi_email().substring(mi.getMi_email().indexOf("@") + 1).equals("naver.com") ? "selected='selected'" : "") %> >네이버</option>
			<option value="nate.com" <%=(mi.getMi_email().substring(mi.getMi_email().indexOf("@") + 1).equals("nate.com") ? "selected='selected'" : "") %> >네이트</option>
			<option value="gmail.com" <%=(mi.getMi_email().substring(mi.getMi_email().indexOf("@") + 1).equals("gmail.com") ? "selected='selected'" : "") %> >지메일</option>
			<option value="direct">직접 입력</option>
		</select>
		<input type="text" name="e3" id="e3" size="10" value="<%=mi.getMi_email().substring(mi.getMi_email().indexOf('@') + 1) %>" />
	</p>
	<p class="pline">광고 수신 : 
		<input type="radio" name="mi_isad" value="y" id="adY" <%=(mi.getMi_isad().equals("y") ? "checked='checked'" : "") %>/>
		<label for="adY">받음</label>&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="radio" name="mi_isad" value="n" id="adN" <%=(mi.getMi_isad().equals("n") ? "checked='checked'" : "") %>/>
		<label for="adN">안받음</label>
	</p>
	<p class="pline" align="center">
		<input type="submit" value="정보 변경" />
	</p>
</form>
</body>
</html>