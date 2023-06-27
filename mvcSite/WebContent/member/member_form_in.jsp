<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/_inc/inc_head.jsp" %>
<%
LocalDate today = LocalDate.now();
int cyear = today.getYear();
int cmonth = today.getMonthValue();
int cday = today.getDayOfMonth();
int last = today.lengthOfMonth();

String[] arrDomain = {"naver.com", "nate.com", "gmail.com"};
%>
<style>
#agreement { width:400px; height:100px; overflow:auto; }
</style>
<script src="/mvcSite/js/date_change.js"></script>
<script>
$(document).ready(function() {
	$("#e2").change(function() {
		if ($(this).val() == "") {
			$("#e3").val("");
		} else if ($(this).val() == "direct") {
			$("#e3").val("");
			$("#e3").focus();
		} else {
			$("#e3").val($(this).val());
		}
	});
});
function chkDupId() {
	// 팝업
	awin = window.open("member/dup_id_form.jsp", "aa", "width=300, height=200, left=50, top=50");
}

</script>
<h2>회원 가입 폼</h2>
<form name="frmJoin" action="memberProcIn" method="post">
<div id="agreement">
 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용<br /> 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용<br /> 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용<br /> 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용<br />
 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용<br /> 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용<br /> 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용<br /> 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용<br />
 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용<br /> 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용<br /> 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용<br /> 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용<br />
 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용<br /> 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용<br /> 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용<br /> 약관 내용 약관 내용 약관 내용 약관 내용 약관 내용<br />
</div>
<input type="radio" name="agree" value="y" id="agreeY" />
<label for="agreeY">동의함</label>&nbsp;&nbsp;&nbsp;&nbsp;
<input type="radio" name="agree" value="n" id="agreeN" checked="checked" />
<label for="agreeN">동의 안함</label>&nbsp;&nbsp;&nbsp;&nbsp;
<hr />
<div>
	<label for="mi_id">아이디 : </label>
	<input type="text" name="mi_id" id="mi_id" maxlength="20" readonly="readonly" />
	<input type="button" value="중복검사" onclick="chkDupId();">
	<br />
	<label for="mi_pw">비밀번호 : </label>
	<input type="password" name="mi_pw" id="mi_pw" maxlength="20" />
	<br />
	<label for="mi_pw2">비밀번호 확인 : </label>
	<input type="password" name="mi_pw2" id="mi_pw2" maxlength="20" />
	<br />
	<label for="mi_name">이름 : </label>
	<input type="text" name="mi_name" id="mi_name" maxlength="20" />
	<br /> 성별 :
	<input type="radio" name="mi_gender" value="남" id="genderM" checked="checked" />
	<label for="genderM">남자</label>&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="radio" name="mi_gender" value="여" id="genderF" />
	<label for="genderF">여자</label>
	<br />생년월일 : 
	<select name="by" onchange="resetday(this.value, this.form.bm.value, this.form.bd);">
<% for (int i = 1930; i <= cyear; i++) { %>
		<option <% if (i == cyear) { %>selected="selected"<% } %>><%=i %></option>
<% } %>
	</select>년
	<select name="bm" onchange="resetday(this.form.by.value, this.value, this.form.bd);">
<%
for (int i = 1; i <= 12; i++) { 
	String bm = i + "";
	if (i < 10) bm = "0" + i;
%>
		<option <% if (i == cmonth) { %>selected="selected"<% } %>><%=bm %></option>
<% } %>
	</select>월
	<select name="bd" >
<%
for (int i = 1; i <= last; i++) { 
	String bd = i + "";
	if (i < 10) bd = "0" + i;
%>
		<option <% if (i == cday) { %>selected="selected"<% } %>><%=bd %></option>
<% } %>
	</select>일
	<br />휴대폰 : 010 - 
	<input type="text" name="p2" size="4" maxlength="4" onkeyup="onlyNum(this);" /> - 
	<input type="text" name="p3" size="4" maxlength="4" onkeyup="onlyNum(this);" />
	<br />이메일 : 
	<input type="text" name="e1" size="10" /> @ 
	<select name="e2" id="e2">
		<option value="">도메인 선택</option>
<% for (int i = 0; i < arrDomain.length; i++) { %>
		<option><%=arrDomain[i] %></option>
<% } %>
		<option value="direct">직접 입력</option>
	</select>
	<input type="text" name="e3" id="e3" size="10">
	<br />광고 수신 : 
	<input type="radio" name="mi_isad" value="y" id="adY" checked="checked" />
	<label for="adY">수신</label>&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="radio" name="mi_isad" value="n" id="adN" />
	<label for="adN">미수신</label>
	<br /><hr />
	우편번호 : <input type="text" name="ma_zip" size="5" maxlength="5" />
	<br />주소1 : <input type="text" name="ma_addr1" size="40" />
	<br />주소1 : <input type="text" name="ma_addr2" size="40" />
	<br /><hr />
	<input type="submit" value="회원 가입" />
</div>
</form>
</body>
</html>