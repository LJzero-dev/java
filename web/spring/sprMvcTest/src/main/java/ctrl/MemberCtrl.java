package ctrl;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import svc.MemberSvc;
import vo.MemberInfo;

@Controller
public class MemberCtrl {	// 회원 관련 모든 기능에 대한 컨트롤러	
	private MemberSvc memberSvc;	
	public void setMemberSvc(MemberSvc memberSvc) {
		this.memberSvc = memberSvc;
	}
	
	@GetMapping("/memberJoin")
	public String JoinForm(HttpSession session,  HttpServletResponse response) throws Exception  {
		if (session.getAttribute("loginInfo") != null) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('이미 로그인 되어있습니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		return "/member/joinForm";
	}
	
	@PostMapping("/memberJoin")
	public String joinProc(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=utf-8");
		MemberInfo mi = new MemberInfo();
		mi.setMi_id(request.getParameter("mi_id"));
		mi.setMi_pw(request.getParameter("mi_pw"));
		mi.setMi_name(request.getParameter("mi_name"));
		mi.setMi_gender(request.getParameter("mi_gender"));
		mi.setMi_birth(request.getParameter("year") + "-" + request.getParameter("month") + "-" + request.getParameter("day"));
		mi.setMi_phone("010-" + request.getParameter("p2") + "-" + request.getParameter("p3"));
		mi.setMi_email(request.getParameter("e1") + "@" + request.getParameter("e3"));
		mi.setMi_isad(request.getParameter("mi_isad"));		
		if (memberSvc.memberInsert(mi) != 1) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원 가입에 실패했습니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}		
		return "redirect:/loginSpr";
	}
	
	@PostMapping("/dupId")
	@ResponseBody	// 자바객체를 http 응답용 객체로 변환하여 클라이언트에 전송 비동기 통신(ajax)시 서버에서 클라이언트로 응답메세지를 보낼 때 데이터를 담아서 보낼 해당 본문을 의미 
	public String dupId(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		return memberSvc.chkDupId(request.getParameter("uid").trim().toLowerCase());		 
	}	
	
	@GetMapping("/memberUp")
	public String updateForm(HttpSession session,  HttpServletResponse response) throws Exception  {
		if (session.getAttribute("loginInfo") == null) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인 후 이용 부탁드립니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}		
		return "/member/updateForm";
	}
	
	@PostMapping("/memberUp")
	public String updateForm(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");		
		if (session.getAttribute("loginInfo") == null && 
			memberSvc.updateForm(((MemberInfo)session.getAttribute("loginInfo")).getMi_id(), ("010-" + request.getParameter("p2") + "-" + request.getParameter("p3")), (request.getParameter("e1") + "@" + request.getParameter("e3")), request.getParameter("mi_isad")) != 1) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('정보변경에 문제가 발생했습니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		} else {
			((MemberInfo)session.getAttribute("loginInfo")).setMi_phone(("010-" + request.getParameter("p2") + "-" + request.getParameter("p3")));
			((MemberInfo)session.getAttribute("loginInfo")).setMi_email((request.getParameter("e1") + "@" + request.getParameter("e3")));
			((MemberInfo)session.getAttribute("loginInfo")).setMi_isad(request.getParameter("mi_isad"));			
		}
		return "redirect:/";
	}
}