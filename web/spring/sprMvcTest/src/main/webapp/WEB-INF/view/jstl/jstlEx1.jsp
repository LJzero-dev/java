<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%!
public static class Person {
	int num;
	String uname;
	public int getNum() { return num; }
	public void setNum(int num) { this.num = num; }
	public String getUname() { return uname; }
	public void setUname(String uname) { this.uname = uname; }
}
%>
<%
// Person 클래스의 인스턴스 person을 생성 후 멤버변수 num에 100을 uname에 '홍길동'을 저장한 후 page영역의 attribute로 저장
Person person = new Person();
person.setNum(100);	person.setUname("홍길동");
pageContext.setAttribute("person", person);	// page 영역의 객체명은 page가 아닌 pageContext임
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>인스턴스의 멤버변수 값 변경</h2>
${person.uname}<br />
<c:set target="${person}" property="uname" value="전우치" />
<!-- person 인스턴스의 uname 멤버변수의 값을 '전우치' 로 변경 (클래스내의 setter 메소드를 이용) -->
${person.uname}<br />
<hr />
<h2>&lt;c:set&gt; 기본 사용법</h2>
<c:set var="uname1" value="홍길동" />
<c:set var="uname2" >전우치</c:set>
<!-- scope 속성을 생략했으므로 기본값인 page 영역에 들어감 -->
${pageScope.uname1} / ${pageScope.uname2}<br /> 
${uname1} / ${uname2}<!-- 영역을 생략하고 출력해도 됨 -->
<hr />

<h2>scope 지정</h2>
<c:set var="uname3" value="임꺽정" scope="request" />
\${pageScope.uname3} : ${pageScope.uname3}<br />	<!-- scope를 request로 지정했으므로 pageScope에서는 안보임 -->
\${requestScope.uname3} : ${requestScope.uname3}<br />
\${uname3} : ${uname3}
<hr /> 

<h2>&lt;c:remove&gt; 기본 사용법</h2>
\${uname1} : ${uname1}<br />
&lt;c:remove var="uname1" /> 사용 후 : <c:remove var="uname1"/><br />
\${uname1} : ${uname1}
</body>
</html>