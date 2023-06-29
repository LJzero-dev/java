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
	<br /><hr Width="710" align="left" /><br />
	<!-- 댓글 영역 시작 -->
	<%
	loginUrl = "/mvcSite/freeView" + args.replace('&', '~') + "~flidx=" + flidx;
	String msg = " placeholder='로그인 후에 사용하실 수 있습니다.' ";
	String dis = " disabled='disabled'";
	String login = " onclick='goLogin(\"댓글 등록\");' ";
	if (isLogin) {
		msg = "";	dis = "";	login = "";
	}
	%>
<style>
.txt { width:530px; height:60px; }
.btn { width:120px; height:60px; }
.frmUp { display:none;}
.reWriter { width:700px; display:flex; padding:5px; justify-content:spacd-between; border:1px solid black; }
.reContent { width:700px; padding:5px; border:1px solid black; border-top:none; margin-bottom:5px; }
</style>
<script>
function goLogin(msg) {
	if (confirm(msg + " 로그인이 필요합니다.\n로그인 화면으로 이동하시겠습니까?")) {
		location.href = "login_form?url=<%=loginUrl %>";
	}
}
function setCharCount(con, fr_idx) {
	var cnt = con.value.length;
	var obj = document.getElementById("charCnt" + fr_idx);
	obj.innerHTML = cnt;
	if (cnt > 200) {
		alert("댓글은 200자 까지만 입력가능합니다.");
		con.value = con.value.substring(0, 200);
		obj.innerHTML = 200;
	}
}
</script>
	<form name="frmReply" >
		<table width="700" cellpadding="5">
			<tr>
				<td width="550" align="right">
					<textarea name="fr_content" class="txt" <%=msg + login %> onkeyup="setCharCount(this, '');"  ></textarea>
					<br />200자 이내로 입력하세요. (<span id="charCnt">0</span> / 200)
				</td>
				<td width="*" valign="top">
					<input type="submit" value="댓글 등록" class="btn" <%=dis %>/>
				</td>
			</tr>
		</table>
	</form>
	<br /><hr align="left" width="710" />
	<%
	ArrayList<FreeReply> replyList = (ArrayList<FreeReply>)request.getAttribute("replyList");
	if (replyList.size() > 0) {	// 보여줄 댓글 목록이 있으면
		for (FreeReply fr : replyList) {
	%>
	<div class="reWriter">
		<%=fr.getMi_id() %>&nbsp;&nbsp;&nbsp;&nbsp;<%=fr.getFr_date() %>
	</div>
	<div class="reContent">
		<pre><%=fr.getFr_content() %></pre><!-- pre는 태그 먹힘 xmp는 태그 안먹힘 둘다 엔터 표시해줌 -->
	</div>
	<%
		}
	} else {
		out.println("<p>아직 댓글이 없습니다.</p>");
	}
	%>
</body>
</html>