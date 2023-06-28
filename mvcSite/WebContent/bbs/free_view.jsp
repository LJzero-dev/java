<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/_inc/inc_head.jsp" %>
<%
request.setCharacterEncoding("utf-8");
String args = (String)request.getAttribute("args");
FreeList freeList = (FreeList)request.getAttribute("freeList");
%>
<h2>자유 게시판 글 보기 폼</h2>
	<table width="600" cellpadding="5" >
		<tr>
			<th width="10%">작성자</th><td width="15%"><%=freeList.getFl_writer() %></td>
			<th width="10%">조회수</th><td width="10%"><%=freeList.getFl_read() %></td>
			<th width="10%">작성일</th><td width="*"><%=freeList.getFl_date() %></td>				
		</tr>		
		<tr>
			<th>제목</th><td colspan="5"><%=freeList.getFl_title() %></td>
		</tr>		
		<tr>
			<th>내용</th><td colspan="5"><%=freeList.getFl_content().replace("\r\n", "<br />") %></td>
		</tr>
		<tr>
			<td colspan="6" align="center"></td>
		</tr>
	</table>
</body>
</html>