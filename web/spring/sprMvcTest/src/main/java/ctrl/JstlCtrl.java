package ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JstlCtrl {	
	@GetMapping("/jstlIndex")
	public String jstlIndex() {
		return "/jstl/jstlIndex";
	}
	@GetMapping("/elEx1")
	public String elEx1() {
		return "/jstl/elEx1";
	}
	@PostMapping("/elEx2")
	public String elEx2() {
		return "/jstl/elEx2";
	}
	@GetMapping("/elOperator")
	public String elOperator() {
		return "jstl/elOperator";
	}
	@GetMapping("/jstlEx1")
	public String jstlEx1() {
		return "jstl/jstlEx1";
	}
}