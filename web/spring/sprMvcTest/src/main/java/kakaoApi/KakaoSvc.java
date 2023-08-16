package kakaoApi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class KakaoSvc {
	public String getAccessToken(String code) {
		String access_token = "", refresh_token = "", reqURL = "https://kauth.kakao.com/oauth/token";		
		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("POST");	//	요청시 post 방식사용
			conn.setDoOutput(true);			//	post방식을 사용하기 위한 셋팅
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));	//	post요청에 필요한 파라미터 생성
			StringBuilder sb = new StringBuilder();
			sb.append("grant_type=authorization_code");
			sb.append("&client_id=624cb3948cd9654bb651d235429b049c");
			sb.append("&redirect_uri=http://localhost:8087/sprMvcTest/kakaoLoginProc");
			sb.append("&code=" + code);
			bw.write(sb.toString());
			bw.flush();					//	conn 객체에 저장된 url로 bw의 파라미터들을 가지고 실행
			
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);	//	값이 200이면 성공
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));	//	요청을 통해 얻은 JSON형식의 Response 메시지 읽어오기
			String line = "", result = "";
			while ((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println("result : " + result);
			//	result : {"access_token":"kO0YA1SuT_Uk2M_sRknMmq35ju_ED0DSfjwn-bovCiolDgAAAYn8Vs0n","token_type":"bearer","refresh_token":"Y8XMZ6HXLgKV8DVQ93YA3vXe7SqCjm4Dlxduj9JuCiolDgAAAYn8Vs0l","expires_in":21599,"scope":"age_range birthday account_email gender profile_nickname","refresh_token_expires_in":5183999}
			JSONParser p = new JSONParser();	//	JSON파싱 및 JSONObject객체 생성
			JSONObject jo = (JSONObject)p.parse(result);
			access_token = (String)jo.get("access_token");	//	실제 데이터를 가져올 수 있는 코드값0
			refresh_token = (String)jo.get("refresh_token");
			br.close();	bw.close();
		} catch(Exception e){
			System.out.println("KakaoSvc 클래스의 getAccessToken() 메소드 오류");
			e.printStackTrace();
		}
		return access_token;
	}

	public HashMap<String, String> getUserInfo(String accessToken) {
		//	요청하는 클라리언트마다 가진 정보가 다를 수 있기에 HashMap타입으로 리턴
		HashMap<String, String> loginInfo = new HashMap<String, String>();
		String reqURL = "https://kapi.kakao.com/v2/user/me";
		
		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			
			conn.setRequestProperty("Authorization", "Bearer " + accessToken);
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));	//	요청을 통해 얻은 JSON형식의 Response 메시지 읽어오기
			String line = "", result = "";
			while ((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println("result : " + result);
			//	result : {"id":2967106839,"connected_at":"2023-08-16T02:40:16Z","properties":{"nickname":"이준영"},"kakao_account":{"profile_nickname_needs_agreement":false,"profile":{"nickname":"이준영"},"has_email":true,"email_needs_agreement":false,"is_email_valid":true,"is_email_verified":true,"email":"ljy326@naver.com","has_age_range":true,"age_range_needs_agreement":false,"age_range":"30~39","has_birthday":true,"birthday_needs_agreement":false,"birthday":"0326","birthday_type":"SOLAR","has_gender":true,"gender_needs_agreement":false,"gender":"male"}}
			JSONParser p = new JSONParser();
			JSONObject jo = (JSONObject)p.parse(result);
			JSONObject properties = (JSONObject)jo.get("properties");
			JSONObject kakao_account = (JSONObject)jo.get("kakao_account");
			
			String nickname = properties.get("nickname").toString();
			String gender = kakao_account.get("gender").toString();
			String birthday = kakao_account.get("birthday").toString();
			/*String email = kakao_account.get("email").toString();*/
			//	이메일은 없을 수도 있으므로 가져올 수 없음
			loginInfo.put("nickname", nickname);	//	받아온 로그인 정보들을 HashMap인 loginInfo에 저장
			loginInfo.put("gender", gender);
			loginInfo.put("birthday", birthday);
			
		} catch (Exception e) {
			System.out.println("KakaoSvc 클래스의 getUserInfo() 메소드 오류");
			e.printStackTrace();			
		}
		
		return loginInfo;
	}
}