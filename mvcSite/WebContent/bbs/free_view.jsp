<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/_inc/inc_head.jsp" %>
<%
request.setCharacterEncoding("utf-8");
FreeList freeList = (FreeList)request.getAttribute("freeList");
int flidx = freeList.getFl_idx();
String args = (String)request.getAttribute("args");
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
			<td colspan="6" align="center">
				<%
				// 회원글 : 작성자만 수정, 삭제 버튼을 보여줌 - 수정은 수정폼으로, 삭제는 삭제 여부를 물은 뒤 삭제
				// 비회원글 : 모두에게 수정, 삭제 버튼을 보여줌 - 클릭시 비밀번호 입력폼으로 이동
				boolean isPms = false;	// 수정, 삭제 버튼을 보여줄지 여부를 저장할 변수
				String upLink = "", delLink = "";	// 수정, 삭제용 링크를 저장할 변수
				if (freeList.getFl_ismem().equals("n")) {	// 현재 게시글이 비회원 글이면
					isPms = true;
					upLink = "location.href='freeFormPw" + args + "&kind=up&flidx=" + flidx + "'";
					delLink = "location.href='freeFormPw" + args + "&kind=del&flidx=" + flidx + "'";
				} else {	// 현재 게시글이 회원 글이면
					if (isLogin && loginInfo.getMi_id().equals(freeList.getFl_writer())) {	// 현재 사용자가 로그인이 되어 있고, 현 게시글의 작성자일 경우
						isPms = true;
						upLink = "location.href='freeFromUp" + args + "&flidx=" + flidx + "'";
						delLink = "realDel();";
					}
				}
				
				if (isPms) {
				%>
				<script>
				function realDel() {
					if (confirm("정말 삭제하시겠습니다?\n삭제된 글은 다시 복구할 수 없습니다.")) {
						location.href = "freeProcDel?flidx=<%=flidx %>";
					}
				}
				</script>
					<input type="button" value="수정" onclick="<%=upLink %>" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" value="삭제" onclick="<%=delLink %>" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<% } %>
				<input type="button" value="목록" onclick="location.href='freeList<%=args %>'" />
			</td>
		</tr>
	</table>
</body>
</html>