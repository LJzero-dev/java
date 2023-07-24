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
</body>
</html>