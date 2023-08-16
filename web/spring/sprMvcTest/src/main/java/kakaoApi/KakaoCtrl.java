package kakaoApi;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KakaoCtrl {
	private KakaoSvc kakaoSvc;
	public void setKakaoSvc(KakaoSvc kakaoSvc) {
		this.kakaoSvc = kakaoSvc;
	}
	@GetMapping("/kakaoMap")
	public String kakaoMap() {
		return "/kakao/kakaoMap";
	}
	@GetMapping("/kakaoBook")
	public String kakaoBook() {
		return "/kakao/kakaoBook";
	}
	@GetMapping("/kakaoLogin")
	public String kakaoLogin() {
		return "/kakao/kakaoLogin";
	}
	@GetMapping("/kakaoLoginProc")
	public String kakaoLoginProc(Model model, String code) throws Exception {
		//	code : kakao.com으로 부터 정보를 받기 위한 코드값 
		String accessToken = kakaoSvc.getAccessToken(code);						//	로그인 정보를 받기 위한 코드를 받아옴
		HashMap<String, String> loginInfo = kakaoSvc.getUserInfo(accessToken);	//	실제 데이터를 HashMap 인스턴스로 받아옴

		System.out.println("loginInfo : " + loginInfo);
		System.out.println("nickname : " + loginInfo.get("nickname"));
		System.out.println("gender : " + loginInfo.get("gender"));
		System.out.println("birthday : " + loginInfo.get("birthday"));
		
		model.addAttribute("loginInfo", loginInfo);
		
		return "redirect:/";	//	로그인 처리 후 이동할 페이지 주소
	}
}