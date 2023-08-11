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
        // URL�� ����� ���� StringBuilder ����
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=eK%2Bh7ZUqemVimmd2QHIY39z3iyTO6LPrfEsKz6ztWfVpnpcSVP9Iws9Q9G0avyhKEid0se7AOr8lSHas4L0yLQ%3D%3D"); /*Service Key*/
        
        //	Open API�� ��û �԰ݿ� �´� ������Ʈ��
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*������ ��ȣ*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*�� ������ ��� ��*/
        // urlBuilder.append("&" + URLEncoder.encode("cond[country_nm::EQ]","UTF-8") + "=" + URLEncoder.encode("����", "UTF-8")); /*������*/
        // urlBuilder.append("&" + URLEncoder.encode("cond[country_iso_alp2::EQ]","UTF-8") + "=" + URLEncoder.encode("GH", "UTF-8")); /*ISO 2�ڸ��ڵ�*/
        urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*XML �Ǵ� JSON*/
        //	URL ��ü ����
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        //	Open API���� ���� �����͸� �޾� ������ ��ü ����
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        //	�޾ƿ� ������ ��ü�� ���ڿ��� ������ ��ü
        String line;
        //	�޾ƿ� �����͸� �� �پ� ���ڿ��� �޾� ������ ��ü
        while ((line = rd.readLine()) != null) {
        	//	�о���� �� ���� ���ڿ��� line�� ����(���̻� �о���� �����Ͱ� ������ null)
            sb.append(line);
            //	�о���� �� ���� ���ڿ��� ���ʴ�� sb�� ��������
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
    }
}