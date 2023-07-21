package ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import vo.MemberInfo;

@Controller
public class LoginFormCtrl {
	@GetMapping("/loginForm")
	public String loginForm() {
		return "loginForm";
	}
}