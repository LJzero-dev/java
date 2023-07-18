package ctrl;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import svc.LoginSvcMvc;
import vo.MemberInfo;

@Controller
public class LoginCtrlMvc {
	@GetMapping("/loginMvc")
	public String loginMvc() {
		return "loginFormMvc";
	}
	@PostMapping("/loginMvc") 
	public String logimMvc(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String uid = request.getParameter("uid").trim().toLowerCase();
		String pwd = request.getParameter("pwd").trim();
		
		LoginSvcMvc loginSvcMvc = new LoginSvcMvc();
		MemberInfo loginInfo = loginSvcMvc.getLoginInfo(uid,pwd);
		
		if (loginInfo == null) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('아이디와 암호를 확인하세요.');");
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
