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
public class MemberCtrl {	// ȸ�� ���� ��� ��ɿ� ���� ��Ʈ�ѷ�	
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
			out.println("alert('�̹� �α��� �Ǿ��ֽ��ϴ�.');");
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
			out.println("alert('ȸ�� ���Կ� �����߽��ϴ�.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}		
		return "redirect:/loginSpr";
	}
	
	@PostMapping("/dupId")
	@ResponseBody	// �ڹٰ�ü�� http ����� ��ü�� ��ȯ�Ͽ� Ŭ���̾�Ʈ�� ���� �񵿱� ���(ajax)�� �������� Ŭ���̾�Ʈ�� ����޼����� ���� �� �����͸� ��Ƽ� ���� �ش� ������ �ǹ� 
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
			out.println("alert('�α��� �� �̿� ��Ź�帳�ϴ�.');");
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
			out.println("alert('�������濡 ������ �߻��߽��ϴ�.');");
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