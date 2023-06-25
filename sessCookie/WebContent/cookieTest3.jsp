<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String language = "korean";
String cook = request.getHeader("cookie");
if (cook != null) {	// 쿠키가 있으면
	Cookie[] cookies = request.getCookies();
	for (int i = 0; i < cookies.length; i++) {	// 이름이 'language'인 쿠키를 찾아 그 쿠기의 값을 language변수에 저장한 후 루프를 빠져나옴
		if (cookies[i].getName().equals("language")) {
			language = cookies[i].getValue();
		break;
		}
	}
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if (language.equals("korean")) { %>
<h3>안녕하세요. 이것은 쿠키 예제입니다.</h3>
<% } else { %>
<h3>Hello. This is Cookie example</h3>
<% } %>
<form action="cookieTest4.jsp" method="post">
<input type="radio" name="language" value="korean" id="kor"<% if (language.equals("korean")) { %>checked="checked"<% } %> />
<label for="kor">한국어 페이지 보기</label>
&nbsp;&nbsp;&nbsp;&nbsp;
<input type="radio" name="language" value="english" id="eng"<% if (language.equals("english")) { %>checked="checked"<% } %> />
<label for="eng">영어 페이지 보기</label>
<br /><br />
<input type="submit" value="언어 설정" />
</form>
</body>
</html>