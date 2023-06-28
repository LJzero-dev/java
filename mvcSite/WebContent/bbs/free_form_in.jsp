<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/_inc/inc_head.jsp" %>
<h2>자유 게시판 글 등록 폼</h2>
<form name="frm" action="freeProcIn" method="post">
	<table width="600" cellpadding="5">
		<% if (!isLogin) {	// 비회원이 글을 등록할 경우(작성자와 비밀번호 입력란이 보임) %>
			<tr>
				<th width="15%">작성자</th>
				<th width="35%"><input type="text" name="fl_writer" maxlength="20" /></th>
				<th width="15%">비밀번호</th>
				<th width="35%"><input type="password" name="fl_pw" maxlength="20" /></th>				
			</tr>
		<% } %>
		<tr>
			<th width="15%">글제목</th>
			<th colspan="3"><input type="text" name="fl_title" size="63" maxlength="100" /></th>
		</tr>
		<tr>
			<th>글내용</th>
			<th colspan="3"><textarea name="fl_content" rows="10" cols="65"></textarea></th>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<input type="submit" value="글 등록" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" value="다시 입력" />
			</td>
		</tr>
	</table>
</form>
</body>
</html>