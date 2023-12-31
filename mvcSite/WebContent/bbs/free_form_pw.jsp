<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/_inc/inc_head.jsp" %>
<%
request.setCharacterEncoding("utf-8");
int flidx = Integer.parseInt(request.getParameter("flidx"));
String args = (String)request.getAttribute("args"), kind = (String)request.getAttribute("kind");

String action = kind.equals("up") ? "freeFromUp" : "freeProcDel";	// 서브밋될 경로
%>
<style>
#box { width:200px; height:100px; margin:30px auto 0; border:1px solid black; text-align:center; font-size:12px; }
#fl_pw { margin-bottom:10px; }
</style>
<script>
function chkVal(frm) {
	var fl_pw = frm.fl_pw.value;
	var isSubmit = true;
	if (fl_pw == "") {
		alert("비밀번호를 입력하세요.");
		frm.fl_pw.focus();	return false;
	}
	<% if (kind.equals("del")) {%>
		if (confirm("정말 삭제하시겠습니까?"))	return true;
		else									return false;
	<% } %>	
	return true;
}
</script>
<h2>비밀번호 입력 폼</h2>
<form name="frmPw" action="<%=action %>" method="post" onsubmit="return chkVal(this);">
	<input type = "hidden" name="args" value="<%=args %>" />
	<input type = "hidden" name="kind" value="<%=kind %>" />
	<input type = "hidden" name="flidx" value="<%=flidx %>" />
	<input type = "hidden" name="ismem" value="n" />
	<div id="box">
		<p>비밀번호를 입력하세요.</p>
		<input type="password" name="fl_pw" id="fl_pw" /><br />
		<input type="button" value="취 소" onclick="history.back();" />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" value="확 인" />
	</div>
</form>
<script>
document.frmPw.fl_pw.focus();
</script>
</body>
</html>