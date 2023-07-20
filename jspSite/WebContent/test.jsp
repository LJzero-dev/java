<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.time.*" %>
<%
LocalDate today = LocalDate.now();
int cyear = today.getYear();
int cmonth = today.getMonthValue();
int cday = today.getDayOfMonth();
int last = today.lengthOfMonth();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
#agreement { width:500px; height:100px; overflow:auto; }
.pline { width:500px }
</style>
</head>
<body>
<h2>회원 가입 폼</h2>
<div id="agreement">
약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용<br />
약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용<br />
약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용<br />
약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용<br />
약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용<br />
약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용<br />
약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용<br />
약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용<br />
</div>
<form name="frmJoin" action="memberJoin" method="post">
	<p class="pline" align="center">
		<input type="radio" name="agreement" value="y" id="agreeY" />
		<label for="agreeY">동의함</label>&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="radio" name="agreement" value="y" id="agreeN" />
		<label for="agreeN">비동의함</label>
	</p>
	<hr class="pline" align="left" />
	<p class="pline">아이디 : <input type="text" name="mi_id" /></p>
	<p class="pline">비밀번호 : <input type="password" name="mi_pw" /></p>
	<p class="pline">비밀번호 확인 : <input type="password" name="mi_pw2" /></p>
	<p class="pline">이름 : <input type="text" name="mi_name" /></p>
	<p class="pline">성별 : 
		<input type="radio" name="agreement" value="남" id="male" checked="checked"/>
		<label for="male">남</label>&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="radio" name="agreement" value="여" id="female" />
		<label for="female">여</label>
	</p>
	<p class="pline">생년월일 : 
		<select name="year">
			<% for(int i = 1950; i <= cyear; i++) {%>
				<option <%=i == cyear ? " selected='selected'" : "" %>><%=i %></option>
			<% } %>
		</select>
		<select name="month">
			<% for(int i = 1; i <= 12; i++) { %>
				<option <%=i == cmonth ? " selected='selected'" : "" %>><%=(i < 10 ? "0" + i : i + "") %></option>
			<% } %>
		</select>
		<select name="day">
			<% for(int i = 1; i <= last; i++) { %>
				<option <%=(i == cday) ? " selected='selected'" : "" %>><%=(i < 10 ? "0" + i : i + "") %></option>
			<% } %>
		</select>
	</p>
	<p class="pline">휴대폰 : 010 - 
		<input type="text" name="p2" size="4" maxlength="4" /> - 
		<input type="text" name="p3" size="4" maxlength="4" />
	</p>
	<p class="pline">이메일 : 
		<input type="text" name="e1" size="10" /> @ 
		<select name="e2">
			<option value="">네이버</option>
			<option value="nate.com">네이트</option>
			<option value="gmail.com">지메일</option>
			<option value="direct">직접 입력</option>
		</select>
		<input type="text" name="e3" size="10" />
	</p>
	<p class="pline">
		<input type="radio" name="mi_isad" value="y" id="adY" checked="checked"/>
		<label for="adY">받음</label>&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="radio" name="mi_isad" value="n" id="adN" />
		<label for="adN">안받음</label>
	</p>
	<p class="pline" align="center">
		<input type="submit" value="회원 가입" />
	</p>
</form>
</body>
</html>