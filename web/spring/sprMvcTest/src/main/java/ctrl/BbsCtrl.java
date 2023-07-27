package ctrl;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class BbsCtrl {
	@GetMapping("/bbsFormIn")
	public String bbsFormIn() {
		return "/bbs/bbsFormIn";
	}
	@PostMapping("/bbsProcIn")
	// �޾ƿ��� file��Ʈ���� �̸��� �Ű������� �̸��� ���ƾ� ��
	public String bbsProcIn(MultipartFile[] upLoadFile) {
		String files = "";
		for (MultipartFile file : upLoadFile) {
			
			File saveFile = new File("E:/javatest/web/spring/sprMvcTest/src/main/webapp/resources/img", file.getOriginalFilename());	// ������ ���� ��ü ����
			try {
				file.transferTo(saveFile);
				files += "," + file.getOriginalFilename(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "redirect:/bbsView?files=" + files.substring(1);
	}
	@GetMapping("bbsView")
	public String bbsView(Model model, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		model.addAttribute("files",request.getParameter("files").split(","));
		return "bbs/bbsView";
	}
}
