import java.util.regex.*;

class RegularExp1 {
	public static void main(String[] args) {
		String[] data = {"bat", "baby", "bonus", "cA", "ca", "co", "c.", "c0", "car", "combat", "count", "date", "disc"};

		Pattern p = Pattern.compile("c[a-z]*");	//	문자열을 검사할 패턴 생성 : c[a-z]* -> c로 시작하고 모든 글자가 영문 소문자인 단어를 의미

		String tmp = "";
		for (int i = 0 ; i < data.length ; i++ ) {
			Matcher m = p.matcher(data[i]);			//	dayta 배열의 i인덱스에 해당하는 문자열이 p패턴에서 지정한 정규식 패턴과 매칭하는지 검사하여 m에 저장
			if (m.matches()) tmp += ", " + data[i];	//	문자열(data[i]과 패턴(p)이 일치하면
		}
		if (tmp.equals("")) {		//	패턴과 일치하는 단어가 없으면
			System.out.println("패턴에 맞는 단어가 없습니다.");
		} else {
		System.out.println(tmp.substring(2));			
		}

		//	StringBuilder를 이용하여 메모리를 관리하는 방식
		StringBuilder sb = new StringBuilder();
		for (int i = 0 ; i < data.length ; i++ ) {
			Matcher m = p.matcher(data[i]);			//	dayta 배열의 i인덱스에 해당하는 문자열이 p패턴에서 지정한 정규식 패턴과 매칭하는지 검사하여 m에 저장
			if (m.matches()) sb.append(", " + data[i]);	//	문자열(data[i]과 패턴(p)이 일치하면
		}
		if (sb.equals("")) {					//	패턴과 일치하는 단어가 없으면
			System.out.println("패턴에 맞는 단어가 없습니다.");
		} else {
			String tmp2 = new String(sb);
		System.out.println(tmp2.substring(2));			
		}		
	}
}
