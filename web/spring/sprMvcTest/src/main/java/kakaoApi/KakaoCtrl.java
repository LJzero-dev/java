package kakaoApi;

import org.springframework.stereotype.Controller;
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
}