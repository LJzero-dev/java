package ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import svc.JstlSvc;
import vo.MemberInfo;
import vo.PageInfo;

@Controller
public class JstlCtrl {	
	private JstlSvc jstlSvc;
		
	public void setJstlSvc(JstlSvc jstlSvc) {
		this.jstlSvc = jstlSvc;
	}
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
	@GetMapping("/jstlEx2")
	public String jstlEx2() {
		return "jstl/jstlEx2";
	}
	@GetMapping("/jstlEx3")
	public String jstlEx3() {
		return "jstl/jstlEx3";
	}
	@GetMapping("/jstlEx4")
	public String jstlEx4() {
		return "jstl/jstlEx4";
	}
	@GetMapping("/jstlEx5")
	public String jstlEx5(Model model) {	//	'test01' ~ 'test06'까지의 문자열을 담은 List tmpList를 생성
		List<String> tmpList = new ArrayList<String>();
		for (int i = 1; i <= 6; i++) {
			tmpList.add("test0" + i);
		}
		model.addAttribute("tmpList", tmpList);
		return "jstl/jstlEx5";
	}
	@GetMapping("/jstlFunc")
	public String jstlFunc() {
		return "jstl/jstlFunc";
	}
	@GetMapping("/jstlFmt")
	public String jstlFmt() {
		return "jstl/jstlFmt";
	}
	@GetMapping("/jstlSql1")
	public String jstlSql1() {
		return "jstl/jstlSql1";
	}
	@GetMapping("/jstlSql2")
	public String jstlSql2() {
		return "jstl/jstlSql2";
	}
	@GetMapping("/jstlSql3")
	public String jstlSql3(Model model, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		PageInfo pi = new PageInfo(request.getParameter("schtype"), request.getParameter("keyword"));
		model.addAttribute("memberList", jstlSvc.getMemberList(pi));
		model.addAttribute("pi", pi);
		return "jstl/jstlSql3";
	}
}