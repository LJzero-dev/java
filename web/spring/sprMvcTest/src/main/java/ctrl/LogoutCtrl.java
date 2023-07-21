package ctrl;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import config.CtrlConfig.LoginRequired;
import vo.MemberInfo;

@Controller
public class LogoutCtrl {
	@LoginRequired
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception  {
		session.invalidate();
		return "redirect:/";
	}
}
