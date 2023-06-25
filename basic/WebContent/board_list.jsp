<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<title>Document</title>
		<style>
			#list th,
			#list td {
				height: 30px;
				padding: 8px 3px;
			}

			#list th {
				border-bottom: double black 3px;
			}

			#list td {
				border-bottom: solid black 1px;
			}
		</style>
	</head>

	<body>
		<table width="700" cellspacing="0" cellpadding="0">
			<!-- table tag의 caption은 제목 -->
			<caption>게시판 목록 화면</caption>
			<tr>
				<td colspan="2" align="right">
					<form name="frmSarch" action="" method="get">
						<select name="schtype">
							<option>작성자</option>
							<option>작성일</option>
							<option>제목</option>
						</select>
						<input type="text" name="keyword" placeholder="검색어 입력" />
						<input type="submit" value="검색">
					</form>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<table width="700" cellspacing="0" cellpadding="0" id="list">
						<tr>
							<th width="7%">번호</th>
							<th width="*">제목</th> <!-- * 은 나머지 값 모든 것 -->
							<th width="15%">작성자</th>
							<th width="15%">작성일</th>
							<th width="7%">조회</th>
						</tr>
					<% for (int i = 10; i >= 0; i--) { %>
					<tr align="center" onmouseover="this.bgColor='#efefef';" onmouseout="this.bgColor='';">
					<td><%=i %></td>
					<td align="left">동해물과 백두산이 마르고 닳도록 하느님이 보우...</td>
					<td>홍길동</td>
					<td>23.04.14</td>
					<td>15</td>
				</tr><% } %>						
					</table>
				</td>
			</tr>
			<tr>
				<td width="80%" align="center"><br />
					<!-- &nbsp; 띄어쓰기 &lt; 열기 &gt;닫기 -->
					&lt;&lt;&nbsp;&nbsp;<&nbsp;&nbsp; 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 &nbsp;&nbsp;>
						&nbsp;&nbsp;&gt;&gt;
				</td>
				<td width="*" align="right"><br /><input type="button" value="게시글 등록"></td>
			</tr>
		</table>
	</body>

</html>
