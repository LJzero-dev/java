package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class ApiExplorer {
    public static void main(String[] args) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1262000/CountryPopulationService2/getCountryPopulationList2"); /*URL*/
        // URL을 만들기 위한 StringBuilder 생성
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=eK%2Bh7ZUqemVimmd2QHIY39z3iyTO6LPrfEsKz6ztWfVpnpcSVP9Iws9Q9G0avyhKEid0se7AOr8lSHas4L0yLQ%3D%3D"); /*Service Key*/
        
        //	Open API의 요청 규격에 맞는 쿼리스트링
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        // urlBuilder.append("&" + URLEncoder.encode("cond[country_nm::EQ]","UTF-8") + "=" + URLEncoder.encode("가나", "UTF-8")); /*국가명*/
        // urlBuilder.append("&" + URLEncoder.encode("cond[country_iso_alp2::EQ]","UTF-8") + "=" + URLEncoder.encode("GH", "UTF-8")); /*ISO 2자리코드*/
        urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*XML 또는 JSON*/
        //	URL 객체 생성
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        //	Open API에서 보낸 데이터를 받아 저장할 객체 선언
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        //	받아온 데이터 전체를 문자열로 저장할 객체
        String line;
        //	받아온 데이터를 한 줄씩 문자열로 받아 저장할 객체
        while ((line = rd.readLine()) != null) {
        	//	읽어들인 한 줄의 문자열을 line에 저장(더이상 읽어들일 데이터가 없으면 null)
            sb.append(line);
            //	읽어들인 한 줄의 문자열을 차례대로 sb에 누적저장
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
    }
}