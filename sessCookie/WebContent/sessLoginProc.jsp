<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="test.MemberInfo" %>
<%
/* 로그인에 대한 처리 파일
아이디 : test / 암호 : 1234 / 이름 : 홍길동 / 포인트 : 1500 / 전화 : 010-1234-5678

1. 사용자가 입력한 로그인 정보(아이디, 비밀번호)를 받아와서 실제 회원인지 여부를 검사한 후 그 결과에 따라 동작함
 - 로그인 성공 : 회원 데이터를 추출하여 세션에 저장(회원 정보 저장용 클래스-MemberInfo의 인스턴스로 저장) 후 메인으로 이동
 - 로그인 실패 : 로그인 실패 메시지를 출력한 후 다시 로그인 폼으로 이동
 
 2. 아이디 저장을 체크했을 경우 해당 아이디를 쿠키로 저장(만료기간 : 1년)
  - 로그인에 성공했을 경우에만 아이디를 저장시킴
 */
response.setCharacterEncoding("utf-8");
String uid = request.getParameter("uid");
String pwd = request.getParameter("pwd");
String isSave = request.getParameter("isSave");

out.println("<script>");
if (uid.equals("test") && pwd.equals("1234")) {	// 로그인 성공 시
	MemberInfo mi = new MemberInfo();	// 회원 정보를 저장할 MemberInfo형 인스턴스 생성
	mi.setUid(uid); 	mi.setPwd(pwd);	mi.setName("홍길동"); mi.setPhone("010-1234-5678"); mi.setPoint(1500);
	
	session.setAttribute("loginInfo", mi);
	
	if (isSave != null) {	// 아이디 저장 체크박스를 선택 했다면
		Cookie cookie = new Cookie("saveID", uid);
		cookie.setMaxAge(60 * 60 * 24 * 365);
		response.addCookie(cookie);
	} else {
		//Cookie cookie = new Cookie();
	}
	
	out.println("location.href='sessMain.jsp';");
} else {	// 로그인 실패시
	out.println("alert('로그인 정보가 잘못되었습니다.');");
	out.println("history.back();");
}
out.println("</script>");
%>