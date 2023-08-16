package ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VueCtrl {
	/*
	private VueSvc VueSvc;
	public void setVueSvc(VueSvc VueSvc) {
		this.VueSvc = VueSvc;
	}
	*/
	@GetMapping("/vueIndex")
	public String vueIndex() {
		return "/vue/vueIndex";
	}
	@GetMapping("/basicIndex")
	public String basicIndex() {
		return "/vue/basic/basicIndex";
	}
	@GetMapping("/propertyPrint")
	public String propertyPrint() {
		return "/vue/basic/propertyPrint";
	}
	@GetMapping("/dataPrint")
	public String dataPrint() {
		return "/vue/basic/dataPrint";
	}
	@GetMapping("/arrayPrint")
	public String arrayPrint() {
		return "/vue/basic/arrayPrint";
	}
	@GetMapping("/objectPrint")
	public String objectPrint() {
		return "/vue/basic/objectPrint";
	}
}