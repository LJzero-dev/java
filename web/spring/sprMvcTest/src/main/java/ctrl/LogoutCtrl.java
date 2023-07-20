package ctrl;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutCtrl {	
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception  {
		session.invalidate();
		return "redirect:/";
	}
}
