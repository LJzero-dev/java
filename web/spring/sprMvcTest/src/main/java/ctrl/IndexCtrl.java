package ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import config.CtrlConfig.LoginRequired;

@Controller
public class IndexCtrl {
	@GetMapping("/")
	public String index() {
		return "index";
	}
}
