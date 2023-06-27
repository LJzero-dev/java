<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/_inc/inc_head.jsp" %>
<%
request.setCharacterEncoding("utf-8");
ArrayList<FreeList> freeList = (ArrayList<FreeList>)request.getAttribute("freeList");
PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
int bsize = pageInfo.getBsize(), cpage = pageInfo.getCpage(), psize = pageInfo.getPsize(), pcnt = pageInfo.getPcnt(), rcnt = pageInfo.getRcnt();

%>
</body>
</html>