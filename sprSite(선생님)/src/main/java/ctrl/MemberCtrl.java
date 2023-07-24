package ctrl;

import java.io.*;
import javax.servlet.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import svc.*;
import vo.*;

@Controller
public class MemberCtrl {
// 회원관련 모든 기능에 대한 컨트롤러
	private MemberSvc memberSvc;

	public void setMemberSvc(MemberSvc memberSvc) {
		this.memberSvc = memberSvc;
	}

	@GetMapping("/memberJoin")
	public String joinForm() {
		return "member/joinForm";
	}

	@PostMapping("/memberJoin")
	public String joinProc(HttpServletRequest request, 
		HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		MemberInfo mi = new MemberInfo();
		mi.setMi_id(request.getParameter("mi_id"));
		mi.setMi_pw(request.getParameter("mi_pw"));
		mi.setMi_name(request.getParameter("mi_name"));
		mi.setMi_gender(request.getParameter("mi_gender"));
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		mi.setMi_birth(year + "-" + month + "-" + day);
		String p2 = request.getParameter("p2");
		String p3 = request.getParameter("p3");
		mi.setMi_phone("010-" + p2 + "-" + p3);
		String e1 = request.getParameter("e1");
		String e3 = request.getParameter("e3");
		mi.setMi_email(e1 + "@" + e3);
		mi.setMi_isad(request.getParameter("mi_isad"));

		int result = memberSvc.memberInsert(mi);
		if (result != 1) {
			response.setContentType("text/html; charset=utf-8");
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
	@ResponseBody	// 자바객체를 http 응답용 객체로 변환하여 클라이언트에 전송
	// 비동기 통신(ajax)시 서버에서 클라이언트로 응답메세지를 보낼 때 데이터를 담아서 보낼 해당 본문을 의미
	public String dupId(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		String uid = request.getParameter("uid").trim().toLowerCase();
		int result = memberSvc.chkDupId(uid);

		return result + "";
	}

	@GetMapping("/memberUp")
	public String updateForm() {
		return "member/updateForm";
	}

	@PostMapping("/memberUp")
	public String updateProc(HttpServletRequest request, 
		HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		MemberInfo loginInfo = (MemberInfo)session.getAttribute("loginInfo");

		MemberInfo mi = new MemberInfo();
		mi.setMi_id(loginInfo.getMi_id());
		String p2 = request.getParameter("p2");
		String p3 = request.getParameter("p3");
		mi.setMi_phone("010-" + p2 + "-" + p3);
		String e1 = request.getParameter("e1");
		String e3 = request.getParameter("e3");
		mi.setMi_email(e1 + "@" + e3);
		mi.setMi_isad(request.getParameter("mi_isad"));

		int result = memberSvc.memberUpdate(mi);
		if (result != 1) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('정보 수정에 실패했습니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		} else {
		// 정보 수정 성공시 세션에 들어있는 로그인 정보도 수정함
			loginInfo.setMi_phone("010-" + p2 + "-" + p3);
			loginInfo.setMi_email(e1 + "@" + e3);
			loginInfo.setMi_isad(request.getParameter("mi_isad"));
		}

		return "redirect:/";
	}
}
