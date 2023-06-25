<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String name = request.getParameter("name");
String title = request.getParameter("title");
String file1 = request.getParameter("file1");
String file2 = request.getParameter("file2");
String old1 = request.getParameter("old1");
String old2 = request.getParameter("old2");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>파일 업로드 결과
이름 : <%=name %><br />
제목 : <%=title %><br />
파일1 : <a href="file_download.jsp?file=<%=file1 %>"><%=old1 %></a>
파일1 : <a href="file_download.jsp?file=<%=file2 %>"><%=old2 %></a>
</h2>
</body>
</html>