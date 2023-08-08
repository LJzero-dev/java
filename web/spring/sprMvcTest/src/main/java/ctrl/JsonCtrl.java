package ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import svc.JsonSvc;

@Controller
public class JsonCtrl {
	private JsonSvc jsonSvc;
	
	public void setJsonSvc(JsonSvc jsonSvc) {
		this.jsonSvc = jsonSvc;
	}
	@GetMapping("/jsonIndex")
	public String jstlIndex() {
		return "/json/jsonIndex";
	}
	@GetMapping("/jsObject")
	public String jsObject() {
		return "/json/jsObject";
	}
	@GetMapping("/test01Stringify")
	public String test01Stringify() {
		return "/json/test01Stringify";
	}
	@GetMapping("/test02Parse")
	public String test02Parse() {
		return "/json/test02Parse";
	}
	@GetMapping("/whyJson")
	public String whyJson() {
		return "/json/whyJson";
	}
	@GetMapping(value ="/noJson", produces = "application/text; charset=utf8")
	@ResponseBody	// �ڹ��� ��ü�� http ����� ��ü�� ��ȯ�Ͽ� Ŭ���̾�Ʈ�� ����
	public String noJson() {
		String[] arr = {"ȫ�浿", "����ġ", "�Ӳ���"};
		String result = "";
		for(String str : arr) {
			result += "," + str;
		}
		return result.substring(1);
	} 
}