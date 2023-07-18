package ctrl;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import svc.LoginSvcSpr;
import vo.MemberInfo;

@Controller
@RequestMapping("/loginSpr")
public class LoginCtrlSpr {
	private LoginSvcSpr LoginSvcSpr;
	public void setLoginSvcSpr(LoginSvcSpr loginSvcSpr) {
		this.LoginSvcSpr = loginSvcSpr;
	}
	@GetMapping	//	��û(loginSpr)�� get������� �޾��� ���
	public String loginForm() {
		return "loginFormSpr";
	}
	@PostMapping
	public String loginProc(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String uid = request.getParameter("uid").trim().toLowerCase();
		String pwd = request.getParameter("pwd").trim();
		MemberInfo loginInfo = LoginSvcSpr.getLoginInfo(uid,pwd);
		if (loginInfo == null) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('���̵�� ��ȣ�� Ȯ���ϼ���.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();			
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("loginInfo", loginInfo);
		}
		return "redirect:/";
	}
}