<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/_inc/inc_head.jsp" %>
<%
request.setCharacterEncoding("utf-8");
String args = (String)request.getAttribute("args");
FreeList freeInfo = (FreeList)request.getAttribute("freeInfo");
int flidx = freeInfo.getFl_idx();
%>
<h2>자유 게시판 글 수정 폼</h2>
<form name="frm" action="freeProcUp" method="post">
<input type="hidden" name="args" value="<%=args %>">
<input type="hidden" name="flidx" value="<%=flidx %>">
	<table width="600" cellpadding="5">
			<tr>
				<th width="15%">작성자</th>
				<th width="35%"><%=freeInfo.getFl_writer() %></th>
				<th width="15%">작성일</th>
				<th width="35%"><%=freeInfo.getFl_date() %></th>				
			</tr>
		<tr>
			<th width="15%">글제목</th>
			<th colspan="3"><input type="text" name="fl_title" size="63" maxlength="100" value="<%=freeInfo.getFl_title() %>"/></th>
		</tr>
		<tr>
			<th>글내용</th>
			<th colspan="3"><textarea name="fl_content" rows="10" cols="65"><%=freeInfo.getFl_content() %></textarea></th>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<input type="submit" value="글 수정" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" value="다시 입력" />
			</td>
		</tr>
	</table>
</form>
</body>
</html>