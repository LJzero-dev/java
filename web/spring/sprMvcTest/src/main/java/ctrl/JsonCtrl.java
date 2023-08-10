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
	@ResponseBody	// 자바의 객체를 http 응답용 객체로 변환하여 클라이언트에 전송
	public String noJson() {
		String[] arr = {"홍길동", "전우치", "임꺽정"};
		String result = "";
		for(String str : arr) {
			result += "," + str;
		}
		return result.substring(1);
	} 
	@GetMapping(value ="/useJson", produces = "application/text; charset=utf8")
	@ResponseBody	// 자바의 객체를 http 응답용 객체로 변환하여 클라이언트에 전송
	public String useJson() {
		String[] arr = {"홍길동", "전우치", "임꺽정"};
		org.json.JSONArray result = new org.json.JSONArray(arr);	//	JSONArray는 List에 가까움(특히, ArrayList)		
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
		JSONParser p = new JSONParser();	//	특정 문자열 등을 JSON객체로 변환할 때 사용하는 인스턴스
		JSONArray jsonArr = new JSONArray();
		jsonArr = (JSONArray) p.parse(jsonStr);	// json형식의 문자열(jsonStr)을 JSONArray로 변환하여 저장	//	JSONArray는 배열보다 List에 가까움(특히, ArrayList)
		for (int i = 0; i < jsonArr.size(); i++) {
			JSONObject jo = (JSONObject)jsonArr.get(i);	//	JsonArr에 들어있는 요소를 JSONObject형 인스턴스로 변환
			System.out.println("id : " + jo.get("id") + " / addr : " + jo.get("addr"));	//	JSONObject는 멥(Map)이므로 키를 이용하여 데이터를 추출함
		}		
		request.setAttribute("jsonStr", jsonStr.replaceAll("\"", "\'"));	//	json형식의 문자열을 request에 저장
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