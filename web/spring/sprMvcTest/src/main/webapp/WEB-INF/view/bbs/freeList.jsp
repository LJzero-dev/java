<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
body, th, td, div, p { font-size:12px; }
a:link { text-decoration:none; color:black; }
a:visited { text-decoration:none; color:black; }
a:hover { text-decoration:underline; color:red; }
#list th, #list td { padding:8px 3px; }
#list th { border-bottom:double black 3px; }
#list td { border-bottom:dotted black 1px; }
</style>
</head>
<body>
<h2>자유 게시판 목록</h2>
<table width="700" border="0" cellpadding="0" cellspacing="0" id="list">
	<tr height="30">
		<th width="10%">번호</th><th width="*">제목</th><th width="15%">작성자</th><th width="15%">작성일</th><th width="10%">저회</th>
	</tr>
	<c:if test="${freeList.size() > 0}">
		<c:forEach items="${freeList}" var="fl" varStatus="status">
			<tr height="30">
				<td align="center">${pi.getNum() - status.index}</td>
				<td><a href="freeView?flidx=${fl.getFl_idx()}${pi.getArgs()}">${fl.getFl_title()}</a></td>
				<td align="center">${fl.getFl_writer()}</td>
				<td align="center">${fl.getFl_date()}</td>
				<td align="center">${fl.getFl_read()}</td>
			</tr>
		</c:forEach>
	</c:if>
	<c:if test="${freeList.size() == 0}">
		<tr height="50">
			<td colspan="5" align="center">검색 결과가 없습니다.</td>
		</tr>
	</c:if>
</table>
<table width="700" cellpadding="5">
<tr>
<td width="600">
<c:if test="${freeList.size() > 0}">
   <c:if test="${pi.getCpage() == 1}">
      [처음]&nbsp;&nbsp;&nbsp;[이전]&nbsp;&nbsp;
   </c:if>
   <c:if test="${pi.getCpage() > 1}">
      <a href="freeList?cpage=1${pi.getSchargs()}">[처음]</a>&nbsp;&nbsp;&nbsp;
      <a href="freeList?cpage=${pi.getCpage() - 1}${pi.getSchargs()}">[이전]</a>&nbsp;&nbsp;
   </c:if>

   <c:forEach var="i" begin="${pi.getSpage()}" 
   end="${pi.getSpage() + pi.getBsize() - 1 < pi.getPcnt() ? 
   pi.getSpage() + pi.getBsize() - 1 : pi.getPcnt()}">
      <c:if test="${i == pi.getCpage()}">
         &nbsp;<strong>${i}</strong>&nbsp;
      </c:if>
      <c:if test="${i != pi.getCpage()}">
         &nbsp;<a href="freeList?cpage=${i}${pi.getSchargs()}">${i}</a>&nbsp;
      </c:if>
   </c:forEach>

   <c:if test="${pi.getCpage() == pi.getPcnt()}">
      &nbsp;&nbsp;[다음]&nbsp;&nbsp;&nbsp;[마지막]
   </c:if>
   <c:if test="${pi.getCpage() < pi.getPcnt()}">
      &nbsp;&nbsp;<a href="freeList?cpage=${pi.getCpage() + 1}${pi.getSchargs()}">[다음]</a>
      &nbsp;&nbsp;&nbsp;<a href="freeList?cpage=${pi.getPcnt()}${pi.getSchargs()}">[마지막]</a>
   </c:if>
</c:if>
</td>
<td width="*">
   <input type="button" value="글 등록" onclick="location.href='freeFormIn';" />
</td>
</tr>
<tr><td colspan="2" align="center">
	<form name="frmSch">
		<fieldset>
			<legend>게시판 검색</legend>			
				<select name="schtype">
					<option value="" >검색 조건</option>
					<option value="title" <c:if test="${pi.getSchtype() == 'title'}"> selected="selected" </c:if>>제목</option>
					<option value="content" <c:if test="${pi.getSchtype() == 'content'}"> selected="selected" </c:if>>내용</option>
					<option value="writer" <c:if test="${pi.getSchtype() == 'writer'}"> selected="selected" </c:if>>작성자</option>
					<option value="tc" <c:if test="${pi.getSchtype() == 'tc'}"> selected="selected" </c:if>>제목+내용</option>
				</select>
				<input type="text" name="keyword" value="${pi.getKeyword()}" />
				<input type="submit" value="검색" />
				<input type="button" value="전체글" onclick="location.href='freeList';" />
		</fieldset>
	</form>
</td></tr>
</table>
</body>
</html>