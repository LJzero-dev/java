<%@page import="vo.PageInfo"%>
<%@page import="java.util.List"%>
<%@page import="vo.MemberInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
List<MemberInfo> memberList = (List<MemberInfo>)request.getAttribute("memberList");
PageInfo pi = (PageInfo)request.getAttribute("pi");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.6.4.js"></script>
<script>
function chkAll(all) {
	var chkArr = document.frm2.miid;
	for (var i = 1; i < chkArr.length; i++) {
		chkArr[i].checked = all.checked;
	}
}
function chkOne(one) {
	var frm = document.frm2;
	var all = frm.all;
	if (one.checked) {
		var arr = document.frm2.miid;
		var isChk = true;
		for (var i = 1; i < arr.length; i++) {
			if (!arr[i].checked) {
				isChk = false;	break;
			}
		}
		all.checked = isChk;
	} else {
		all.checked = false;
	}
}
function chkVal(frm){
	var chkArr = frm.miid;
	var isChk = false;
	var jsonArr = [];
	for(var i = 1; i < chkArr.length; i++){
		if (chkArr[i].checked) {			
			var tmp = chkArr[i].value;	//	test1:홍길동(남)
			var tmp1 = tmp.substring(0, tmp.indexOf(":"));	//	test1
			var tmp2 = tmp.substring(tmp.indexOf(":") + 1);	//	홍길동(남)
			jsonArr.push({"id":tmp1,"name":tmp2});			//	jsonArr 배열에 현재 선택된 체크박스의 값을 추가
			isChk = true;
		}
	}
	if(isChk){
		frm.jsonStr.value = JSON.stringify(jsonArr);
		alert(frm.jsonStr.value);
		return false;
	} else {
		alert("한명 이상의 회원을 선택하세요.");
		return false;
	}
}
</script>
</head>
<body>
<h2>회원 목록</h2>
<form name="frm1">
	<p style="width:700px; text-align:right;">
		<select name="schtype">
			<option value="id" <% if(pi.getSchtype().equals("id")) {%> selected="selected" <% } %>>아이디</option>
			<option value="name" <% if(pi.getSchtype().equals("name")) {%> selected="selected" <% } %>>이름</option>
		</select>
		<input type="text" name="keyword" value="<%=pi.getKeyword() %>" />
		<input type="submit" value="검색" />
	</p>
</form>
<form name="frm2" action="jsonArrayDb2" method="post" onsubmit="return chkVal(this);">
	<p style="width:700px; text-align:right;">
	총 검색된 회원 수 : <%=memberList.size() %>명</p>
	<input type="hidden" name="miid" />
	<input type="hidden" name="jsonStr" value="" />
	<table width="700" cellpadding="5">
		<tr>
			<th width="10%"><input type="checkbox" name="all" checked="checked" onclick="chkAll(this);" title="전체 선택" /></th>
			<th width="20%">아이디</th>
			<th width="20%">이름(성별)</th>
			<th width="20%">생년월일</th>
			<th width="20%">전화번호</th>
			<th width="10%">포인트</th>
		</tr>
		<% 
		if (memberList.size() > 0) {
		for(MemberInfo mi : memberList) {%>
		<tr align="center">
			<td><input type="checkbox" name="miid" value="<%=mi.getMi_id() + ":" + mi.getMi_name() %>" checked="checked" onclick="chkOne(this);" /></td>
			<td><%=mi.getMi_id() %></td>
			<td><%=mi.getMi_name() %></td>
			<td><%=mi.getMi_birth() %></td>
			<td><%=mi.getMi_phone() %></td>
			<td><%=mi.getMi_point() %></td>
		</tr>
		<% } %>
		<tr height="50">
			<td colspan="6" align="center">
				<input type="submit" value="JSON 전송" />				
			</td>
		</tr>
		<%
		} else { %>
		<tr align="center">
			<td colspan="5">검색결과 없음</td>
		</tr>
		<% } %>
	</table>
</form>
</body>
</html>