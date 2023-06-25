<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.time.*" %>
<%@ page import="java.time.temporal.*" %>
<%@ page import="static java.time.temporal.TemporalAdjusters.*" %>
<%
request.setCharacterEncoding("utf-8");
String tmpYear = request.getParameter("schYear");
String tmpMonth = request.getParameter("schMonth");

int curYear, curMonth, curDay;								// 오늘 날짜의 연월일 값을 저장하기 위한 변수
LocalDate today = LocalDate.now();
curYear = today.getYear();
curMonth = today.getMonthValue();
curDay = today.getDayOfMonth();

int schYear = curYear, schMonth = curMonth;					// 달력 출력용 연월을 저장할 변수
if (tmpYear != null && tmpMonth != null) {					// 달력 출력용 연월을 받아 왔을 경우	
	schYear = Integer.parseInt(tmpYear);					// 달력 출력용 선택한 연도
	schMonth = Integer.parseInt(tmpMonth);					// 달력 출력용 선택한 월
}
LocalDate sdate = LocalDate.of(schYear, schMonth, 1);		//	시작일 LocalDate 객체
int endDay = sdate.with(lastDayOfMonth()).getDayOfMonth();	//	말일
int weekDay = sdate.getDayOfWeek().getValue();				//	시작일의 요일번호
int minYear = 1990, maxYear = curYear + 10;					//	연도 표현 범위

int prevYear = schYear -1, prevMonth = schMonth -1;
int nextYear = schYear +1, nextMonth = schMonth +1;
String prevYLink = "", prevMLink = "", nextYLink = "", nextMLink = "";	//	작년, 이전 달, 내년, 다음 달의 링크를 저장할 변수를 선언

prevYLink = "?schYear=" + prevYear + "&schMonth=" + schMonth;
if (prevYear < minYear) prevYLink = "alert('이전 연도가 없습니다.');";
else	prevYLink = "location.href='calendar.jsp" + prevYLink + "';";


prevMLink = "?schYear=" + schYear + "&schMonth=" + prevMonth;
if (prevMonth < 1) {			// 현재 월이 1월이면서 '이전 달' 버튼을 클릭했을 경우
	if (schYear == minYear) prevMLink = "alert('이전 연도가 없습니다.');";
	else prevMLink = "location.href='calendar.jsp?schYear=" + (schYear - 1) + "&schMonth=12';";
}	
else	prevMLink = "location.href='calendar.jsp" + prevMLink + "';";

nextYLink = "?schYear=" + nextYear + "&schMonth=" + schMonth;
if (nextYear > maxYear) nextYLink = "alert('다음 연도가 없습니다.');";
else	nextYLink = "location.href='calendar.jsp" + nextYLink + "';";

nextMLink = "?schYear=" + schYear + "&schMonth=" + nextMonth;
if (nextMonth > 12) {			// 현재 월이 12월이면서 '다음 달' 버튼을 클릭했을 경우
	if (schYear == maxYear) nextMLink = "alert('다음 연도가 없습니다.');";
	else nextMLink = "location.href='calendar.jsp?schYear=" + (schYear + 1) + "&schMonth=1';";
}	
else	nextMLink = "location.href='calendar.jsp" + nextMLink + "';";

weekDay++;
if (weekDay == 8) weekDay = 1;

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#serchBox { text-align:center; margin:0 0 20px 0; }
#calendar { border-collapse:collapse; }
#calendar th, #calendar td { border:1px solid black; }
#calendar td { height:70px; }
.txtRed { color:red; font-weight:bold; }
.txtBlue { color:blue; font-weight:bold; }
#txtToday { background:pink; }
</style>
</head>
<body>
<div id="serchBox">
	<h2>일정 관리 - <%=schYear %>년<%=schMonth %>월</h2>
	<form><!-- action과 method 속성은 기본값인 현재 파일과get을 사용함 -->
	<input type="button" value="작년" onclick="<%=prevYLink %>" />
	<input type="button" value="이전 달" onclick="<%=prevMLink %>" />&nbsp;&nbsp;&nbsp;
	<select name="schYear" onchange="this.form.submit();">
<% for (int i = minYear; i <= maxYear; i++) { %>
		<option <% if (schYear == i) { %>selected="selected"<% } %>><%=i %></option>
<% } %>
	</select>년
	
		<select name="schMonth" onchange="this.form.submit();">
<% for (int i = 1; i <= 12; i++) { %>
		<option <% if (schMonth == i) { %>selected="selected"<% } %>><%=i %></option>
<% } %>
	</select>월	
	<input type="button" value="오늘" onclick="location.href='calendar.jsp'" />&nbsp;&nbsp;&nbsp;
	<input type="button" value="다음 달" onclick="<%=nextMLink %>" />
	<input type="button" value="내년" onclick="<%=nextYLink %>" />
	</form>
</div>
<table width="700" align="center" id="calendar">
<tr height="30">
<th width="100" class="txtRed">일</th><th width="100">월</th><th width="100">화</th><th width="100">수</th><th width="100">목</th><th width="100">금</th><th width="100" class="txtBlue">토</th></tr>
<%
if (weekDay != 1) {	// 1일이 일요일이 아니면(1일의 시작위치가 맨 앞이 아니면)
	out.println("<tr>");
	for (int i = 1 ; i < weekDay ; i++ ) out.print("<td></td>");	// 1일의 요일 만큼 빈 칸으로 채워 1일의 위치에서 시작하도록 함
}

String txtClass = "", txtID = "";
for (int i = 1 , j = weekDay ; i <= endDay ; i++ , j++ ) {	//	i : 날짜의 일(day)을 표현하기 위한 변수	j : 일주일 지날 때마다 다음줄로 내리기 위한 변수
	txtClass = ""; txtID = "";
	if (j % 7 == 1) {										//	현재 출력하려는 날짜의 요일 번호가 1(일요일)일 경우
		out.println("<tr>");
		txtClass = " class='txtRed'";
	} else if (j % 7 == 0) txtClass = " class='txtBlue'";
	
	out.println("<td " + txtClass + " valign='top'>" + i + "</td>");
	
	if (j % 7 == 0) {
		out.println("</tr>");
	} else if (i == endDay) {	// 말일까지 출력 했으나 말일의 요일번호가 7의 배수가 아니어서 종료가 되지 않았을 경우
		for (int k = j % 7 ; k < 7; k++) out.println("<td></td>");
		out.println("<tr>");
	}
}
%>
</table>
</body>
</html>