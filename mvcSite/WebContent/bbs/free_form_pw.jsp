<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/_inc/inc_head.jsp" %>
<%
request.setCharacterEncoding("utf-8");
%>
<style>
#box { width:200px; height:100px; margin:30px auto 0; border:1px solid black; text-align:center; font-size:12px; }
#fl_pw { margin-bottom:10px; }
</style>
<h2>비밀번호 입력 폼</h2>
<form name="frmPw" action="" method="post">
	<div id="box">
		<p>비밀번호를 입력하세요.</p>
		<input type="password" name="fl_pw" id="fl_pw" /><br />
		<input type="button" value="취 소" onclick="history.back();" />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" value="확 인" />
	</div>
</form>
</body>
</html>