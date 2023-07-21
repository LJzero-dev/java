<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.time.*" %>
<%@ page import="java.util.*" %>
<%@ page import="vo.*" %>
<%
request.setCharacterEncoding("utf-8");

CalendarInfo ci = (CalendarInfo)request.getAttribute("ci");
// 달력 출력을 위한 정보(현재 연월일, 검색 연월, 말일 등) 

int sy = ci.getSchYear(), sm = ci.getSchMonth();
int sWeek = ci.getsWeek();	// 1일의 요일 및 시작 번호(1~7, 1:월요일), 말일(루프의 조건으로 사용)
int eDay = ci.getSchLast();

int maxYear = ci.getCurYear() + 10, minYear = 2000;
int nextYear = sy, nextMonth = sm + 1;
if (nextMonth == 13) { nextMonth = 1;	nextYear++;}	// 12월 에서 '다음달' 버튼 클릭 시 월은 1월로 연도를 1 증가시킴
int prevYear = sy, prevMonth = sm - 1;
if (prevMonth == 0) { prevMonth = 12;	prevYear--;}	// 1월 에서 '이전달' 버튼 클릭 시 월은 12월로 연도를 1 감소시킴

String link = "location.href='schedule?schYear=";
String prevYearLink = link + (sy - 1) + "&schMonth=" + sm + "';";
if (sy - 1 < minYear)	prevYearLink = "alert('이전 연도가 없습니다.');";
String prevMonthLink = link + prevYear + "&schMonth=" + prevMonth + "';";
if (prevYear < minYear && prevMonth == 12)	prevMonthLink = "alert('이전 연도가 없습니다.');";

String nextYearLink = link + (sy + 1) + "&schMonth=" + sm + "';";
if (sy + 1 > maxYear)	nextYearLink = "alert('다음 연도가 없습니다.');";
String nextMonthLink = link + nextYear + "&schMonth=" + nextMonth + "';";
if (nextYear > maxYear && nextMonth == 1)	nextMonthLink = "alert('다음 연도가 없습니다.');";

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
a { color:black; text-decoration:none; }
a:visited { color:black; text-decoration:none; }

.calendar, .calendar th, .calendar td { border:1px black solid; }
.calendar { border-collapse:collapse; }
.calendar td { height:70px; }
.txtRed { color:red; font-weight:bold; }
.txtBlue { color:blue; font-weight:bold; }
#txtToday { background:#efefef; }
#searchBox { width:700px; text-align:center; }
</style>
</head>
<body>
	<div id="searchBox">
		<h2>일정 관리 - <%=sy %>년 <%=sm %>월</h2>
		<form name="frm">
			<input type="button" value="작년" onclick="<%=prevYearLink %>" />
			<input type="button" value="이전달" onclick="<%=prevMonthLink %>" />
			<select name="schYear" onchange="this.form.submit();">
				<% for (int i = minYear; i <= maxYear; i++) { %>
					<option <%=(sy == i) ? "selected='selected'" : "" %>><%=i %></option>
				<% } %>
			</select>년
			<select name="schMonth" onchange="this.form.submit();">
				<% for (int i = 1; i <= 12; i++) { %>
					<option <%=(sm == i) ? "selected='selected'" : "" %> ><%=i %></option>
				<% } %>
			</select>월
			<input type="button" value="오늘" onclick="location.href='schedule';" />
			<input type="button" value="다음달" onclick="<%=nextMonthLink %>" />
			<input type="button" value="내년" onclick="<%=nextYearLink %>" />
		</form><br />
	</div>
	<table width="700" class="calendar">
		<tr height="30">
			<th width="100">월</th><th width="100">화</th><th width="100">수</th><th width="100">목</th><th width="100">금</th><th width="100" class="txtBlue" >토</th><th width="100" class="txtRed">일</th>
		</tr>
		<%
		if (sWeek != 1) {	// 1일이 월요일이 아니면(시작위치가 처음이 아니면)
			out.println("<tr>");
			for (int i = 1; i < sWeek; i++)	out.println("<td></td>");
		}
		for (int i = 1, n = sWeek; i <= eDay; i++, n++) {	// i == 날짜의 일(Day)을 표현하기 위한 변수	// n == 일주일이 지날 때 마다 다음 줄로 내리기 위한 변수
			String txtClass = "", txtID = "";
			if (n % 7 == 1) out.println("<tr>");			// 요일 번호가 1(월요일) 이면 <tr>을 열어줌
			if (n % 7 == 6) txtClass = " class='txtBlue' ";
			else if (n % 7 == 0) txtClass = " class='txtRed' ";
			String args = "?y=" + sy + "&m=" + sm + "&d=" + i;
			out.println("<td  valign='top'>" + "<a href='scheduleInForm" + args + "'" + txtClass +  ">" + i + "</a></td>");
			if (n % 7 == 0) {
				out.println("</tr>");
			} else if (i == eDay) {
				for (int j = n % 7; j < 7; j++)	out.println("<td></td>");
				out.println("</tr>");
			}
		}
		%>
	</table><span style="color:red; font-weight:bold;"></span>
</body>
</html>