package ctrl;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import svc.JsonSvc;
import vo.PageInfo;

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
	@GetMapping(value ="/useJson", produces = "application/text; charset=utf8")
	@ResponseBody	// �ڹ��� ��ü�� http ����� ��ü�� ��ȯ�Ͽ� Ŭ���̾�Ʈ�� ����
	public String useJson() {
		String[] arr = {"ȫ�浿", "����ġ", "�Ӳ���"};
		org.json.JSONArray result = new org.json.JSONArray(arr);	//	JSONArray�� List�� �����(Ư��, ArrayList)		
		return result.toString();
	}
	@GetMapping("/jsonFile")
	public String jsonFile() {
		return "/json/jsonFile";
	}
	@GetMapping("/jsonArray1")
	public String jsonArray1() {
		return "/json/jsonArray1";
	}
	@PostMapping("/jsonArray2")
	public String jsonArray2(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		String jsonStr = request.getParameter("jsonArr");
		JSONParser p = new JSONParser();	//	Ư�� ���ڿ� ���� JSON��ü�� ��ȯ�� �� ����ϴ� �ν��Ͻ�
		JSONArray jsonArr = new JSONArray();
		jsonArr = (JSONArray) p.parse(jsonStr);	// json������ ���ڿ�(jsonStr)�� JSONArray�� ��ȯ�Ͽ� ����	//	JSONArray�� �迭���� List�� �����(Ư��, ArrayList)
		for (int i = 0; i < jsonArr.size(); i++) {
			JSONObject jo = (JSONObject)jsonArr.get(i);	//	JsonArr�� ����ִ� ��Ҹ� JSONObject�� �ν��Ͻ��� ��ȯ
			System.out.println("id : " + jo.get("id") + " / addr : " + jo.get("addr"));	//	JSONObject�� ��(Map)�̹Ƿ� Ű�� �̿��Ͽ� �����͸� ������
		}		
		request.setAttribute("jsonStr", jsonStr.replaceAll("\"", "\'"));	//	json������ ���ڿ��� request�� ����
		return "/json/jsonArray2";
	}
	@GetMapping("/jasonArrayDb1")
	public String jasonArrayDb1(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		String schtype = request.getParameter("schtype"), keyword = request.getParameter("keyword"), where = "";
		if (schtype == null || keyword == null) {
			schtype = "";	keyword = "";
		} else if(!schtype.equals("") && !keyword.equals("")) {
			URLEncoder.encode(keyword);
			keyword = keyword.trim();
			where = " and mi_" + schtype + " like '%" + keyword +  "%' ";
		}			
		PageInfo pi = new PageInfo();
		pi.setSchtype(schtype);	pi.setKeyword(keyword);
		request.setAttribute("memberList", jsonSvc.getMemberList(where));
		request.setAttribute("pi", pi);
		return "/json/jasonArrayDb1";
	}
	@PostMapping("/jsonArrayDb2")
	public String jsonArrayDb2(HttpServletRequest request) throws Exception {
		request.getParameter("miid");
		System.out.println(request.getParameter("miid") + "aa");
		return "/json/jsonArrayDb2";
	}
}