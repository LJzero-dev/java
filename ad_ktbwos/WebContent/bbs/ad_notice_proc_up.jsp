<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../_inc/inc_head.jsp" %>
<%
if (!isLogin) {	// 로그인이 되어 있지 않다면
	out.println("<script>");
	out.println("alert('로그인 후 다시 시도해주세요.');"); 
	out.println("location.href='../login_form.jsp;");
	out.println("</script>");
	out.close();
}

request.setCharacterEncoding("utf-8");
int cpage = Integer.parseInt(request.getParameter("cpage"));
int idx = Integer.parseInt(request.getParameter("idx"));

String schtype = request.getParameter("schtype");	// 검색조건
String keyword = request.getParameter("keyword");	// 검색어
String args = "?cpage=" + cpage + "&idx=" + idx;
if (schtype != null && !schtype.equals("") && keyword != null && !keyword.equals("")) {
	args += "&schtype=" + schtype + "&keyword=" + keyword;
}

String nl_title = getRequest(request.getParameter("nl_title"));
String nl_content = getRequest(request.getParameter("nl_content"));
try {
	stmt = conn.createStatement();
	sql = "update t_notice_list set " +	
	"nl_title ='" + nl_title + "', " +	"nl_content ='" + nl_content + "'" +
	" where nl_idx = " + idx;
	System.out.println(sql);
	int result = stmt.executeUpdate(sql);
	out.println("<script>");
	if (result == 1) {
		out.println("location.replace('ad_notice_view.jsp" + args + "');");
	}else {
		out.println("alert('공지 글 수정에 실패했습니다.\n다시 시도하세요.');");
		out.println("history.back();");
	}
	out.println("</script>");
	
} catch(Exception e) {
	out.println("공지사항 수정시 문제가 발생했습니다.");
	e.printStackTrace();
} finally {
	try {
		stmt.close();
	} catch(Exception e) {
		e.printStackTrace();
	}
}
%>
<%@ include file="../_inc/inc_foot.jsp" %>