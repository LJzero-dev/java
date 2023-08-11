package ctrl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
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
		request.setCharacterEncoding("utf-8");
		JSONParser p = new JSONParser();
		JSONArray jsonArr = new JSONArray();
		jsonArr = (JSONArray)p.parse(request.getParameter("jsonStr"));
		for (int i = 0; i < jsonArr.size(); i++) {
			JSONObject jo = (JSONObject)jsonArr.get(i);
		}
		return "/json/jsonArrayDb2";
	}
	@GetMapping("/jsonArray3")
	public String jsonArray3() {
		return "/json/jsonArray3";
	}
	@GetMapping("/addrOpenApi")
	public String addrOpenApi() {
		return "/json/addrOpenApi";
	}
	@GetMapping("/openApi1")
	public String openApi1(HttpServletRequest request) throws Exception {
		int cpage = 1, psize = 10, rcnt = 0, bsize = 10;
		//	현재 페이지 번호, 페이지 크기, 데이터 개수, 블록 크기
		if(request.getParameter("cpage") != null) cpage = Integer.parseInt(request.getParameter("cpage"));
		if(request.getParameter("psize") != null) cpage = Integer.parseInt(request.getParameter("psize"));
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1262000/CountryPopulationService2/getCountryPopulationList2"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=eK%2Bh7ZUqemVimmd2QHIY39z3iyTO6LPrfEsKz6ztWfVpnpcSVP9Iws9Q9G0avyhKEid0se7AOr8lSHas4L0yLQ%3D%3D"); /*Service Key*/        
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(String.valueOf(cpage), "UTF-8")); /*������ ��ȣ*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(String.valueOf(psize), "UTF-8")); /*�� ������ ��� ��*/
        // urlBuilder.append("&" + URLEncoder.encode("cond[country_nm::EQ]","UTF-8") + "=" + URLEncoder.encode("����", "UTF-8")); /*������*/
        // urlBuilder.append("&" + URLEncoder.encode("cond[country_iso_alp2::EQ]","UTF-8") + "=" + URLEncoder.encode("GH", "UTF-8")); /*ISO 2�ڸ��ڵ�*/
        urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*XML �Ǵ� JSON*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        JSONParser p = new JSONParser();
        JSONObject jo = (JSONObject)p.parse(sb.toString());
        rcnt = Integer.parseInt(jo.get("totalCount").toString());
		JSONArray dataList = (JSONArray)jo.get("data");
		PageInfo pi = new PageInfo();
		pi.setCpage(cpage);	pi.setPsize(psize);	pi.setRcnt(rcnt);	pi.setBsize(bsize);
		request.setAttribute("pi", pi);	//	페이징을 위한 정보를 PageInfo형 인스턴스 pi에 저장
		request.setAttribute("dataList", dataList);
		return "/json/openApi1";
	}
	@GetMapping("/openApi2")
	public String openApi2(HttpServletRequest request) throws Exception {
	        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1262000/CountryCovid19SafetyServiceNew/getCountrySafetyNewsListNew"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=eK%2Bh7ZUqemVimmd2QHIY39z3iyTO6LPrfEsKz6ztWfVpnpcSVP9Iws9Q9G0avyhKEid0se7AOr8lSHas4L0yLQ%3D%3D"); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*XML �Ǵ� JSON*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*�� ������ ��� ��*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*������ ��ȣ*/
	        // urlBuilder.append("&" + URLEncoder.encode("cond[country_nm::EQ]","UTF-8") + "=" + URLEncoder.encode("����", "UTF-8")); /*�ѱ� ������*/
	        // urlBuilder.append("&" + URLEncoder.encode("cond[country_iso_alp2::EQ]","UTF-8") + "=" + URLEncoder.encode("GH", "UTF-8")); /*ISO 2�ڸ��ڵ�*/
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();
	        JSONParser p = new JSONParser();
	        JSONObject jo = (JSONObject)p.parse(sb.toString());
			JSONArray dataList = (JSONArray)jo.get("data");
			request.setAttribute("dataList", dataList);
        return "/json/openApi2";
	}
}