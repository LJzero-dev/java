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
	public String vueIndex() {	return "/vue/vueIndex";	}
	@GetMapping("/basicIndex")
	public String basicIndex() {	return "/vue/basic/basicIndex";	}
	@GetMapping("/propertyPrint")
	public String propertyPrint() {	return "/vue/basic/propertyPrint";	}
	@GetMapping("/dataPrint")
	public String dataPrint() {	return "/vue/basic/dataPrint";	}
	@GetMapping("/arrayPrint")
	public String arrayPrint() {return "/vue/basic/arrayPrint";	}
	@GetMapping("/objectPrint")
	public String objectPrint() {	return "/vue/basic/objectPrint";	}
	@GetMapping("/jsDataPrint")
	public String jsDataPrint() {	return "/vue/basic/jsDataPrint";	}
	@GetMapping("/allDataPrint")
	public String allDataPrint() {	return "/vue/basic/allDataPrint";	}
	
	
	@GetMapping("/directiveIndex")
	public String directiveIndex() {	return "/vue/directive/directiveIndex";	}
	@GetMapping("/vBindEx1")
	public String vBindEx1() {	return "/vue/directive/vBindEx1";	}
	@GetMapping("/vBindEx2")
	public String vBindEx2() {	return "/vue/directive/vBindEx2";	}
	@GetMapping("/vBindEx3")
	public String vBindEx3() {	return "/vue/directive/vBindEx3";	}
	@GetMapping("/textEx")
	public String textEx() {	return "/vue/directive/textEx";	}
	@GetMapping("/checkboxEx")
	public String checkboxEx() {	return "/vue/directive/checkboxEx";	}
	@GetMapping("/radioEx")
	public String radioEx() {	return "/vue/directive/radioEx";	}
	@GetMapping("/comboEx")
	public String comboEx() {	return "/vue/directive/comboEx";	}
	@GetMapping("/countEx")
	public String countEx() {	return "/vue/directive/countEx";	}
	@GetMapping("/arrayEx")
	public String arrayEx() {	return "/vue/directive/arrayEx";	}
	@GetMapping("/lazyEx")
	public String lazyEx() {	return "/vue/directive/lazyEx";	}
	@GetMapping("/numberEx")
	public String numberEx() {	return "/vue/directive/numberEx";	}
	@GetMapping("/trimEx")
	public String trimEx() {	return "/vue/directive/trimEx";	}
	@GetMapping("/evtClickEx")
	public String evtClickEx() {	return "/vue/directive/evtClickEx";	}
	@GetMapping("/evtKeyupEx")
	public String evtKeyupEx() {	return "/vue/directive/evtKeyupEx";	}
	@GetMapping("/evtCalEx")
	public String evtCalEx() {	return "/vue/directive/evtCalEx";	}
	@GetMapping("/controlEx")
	public String controlEx() {	return "/vue/directive/controlEx";	}
	
	
	@GetMapping("/ifforIndex")
	public String ifforIndex() {	return "/vue/iffor/ifforIndex";	}
	@GetMapping("/ifEx1")
	public String ifEx1() {	return "/vue/iffor/ifEx1";	}
	@GetMapping("/ifEx2")
	public String ifEx2() {	return "/vue/iffor/ifEx2";	}
	@GetMapping("/forEx1")
	public String forEx1() {	return "/vue/iffor/forEx1";	}
	@GetMapping("/forEx2")
	public String forEx2() {	return "/vue/iffor/forEx2";	}
	@GetMapping("/forEx3")
	public String forEx3() {	return "/vue/iffor/forEx3";	}
	@GetMapping("/forEx4")
	public String forEx4() {	return "/vue/iffor/forEx4";	}
}









