import java.util.regex.*;

class RegularExp2 {
	public static void main(String[] args) {
		String[] data = {"bat", "baby", "bonus", "cA", "ca", "co", "c.", "c0", "car", "combat", "count", "date", "disc"};
		String[] pattern = {".*", "c[a-z]", "c[a-zA-Z]", "c[a-zA-Z0-9]", "c.", "c.*", "c\\.", "c\\w", "c\\d", "c.*t", "[b|c].*", ".*a.+", "[b|c].{2}"};

		for (int i = 0 ; i < pattern.length ; i++ ) {
			Pattern p = Pattern.compile(pattern[i]);
			System.out.print("\n Pattern : " + pattern[i] + " 결과 : ");
			for (int j = 0 ; j <data.length ; j++ ) {
				Matcher m = p.matcher(data[j]);
				if (m.matches()) System.out.print(data[j] + ", ");
			}
		}
		/*
 .*(최소 한글자 이상의 문자열) 결과 : bat, baby, bonus, cA, ca, co, c., c0, car, combat, count, date, disc,
 c[a-z] (첫글자 'c'와 영문 소문자 하나로 총 2글자인 문자열) 결과 : ca, co,
 c[a-zA-Z] (첫글자 'c'와 영문 소문자나 대문자 하나로 총 2글자인 문자열) 결과 : cA, ca, co,
 c[a-zA-Z0-9] (첫글자 'c'와 영문 또는 숫자 하나로 총 2글자인 문자열) 결과 : cA, ca, co, c0,
 c. (첫글자 'c'와 글자 하나로 총 2글자인 문자열) 결과 : cA, ca, co, c., c0,
 c.* (첫글자 'c'와 뒤에 최소 한글자 이상으로 이루어진 문자열) 결과 : cA, ca, co, c., c0, car, combat, count,
 c\. (첫글자 'c'와 점으로 총 2글자인 문자열) 결과 : c.,
 c\w (첫글자 'c'와 영문 또는 숫자 하나로 총 2글자인 문자열) 결과 : cA, ca, co, c0,
 c\d (첫글자 'c'와 숫자 하나로 총 2글자인 문자열) 결과 : c0,
 c.*t (첫글자 'c'와 마지막't' 사이에 한글자 이상의 문자열 ) 결과 : combat, count,
 [b|c].* (첫글자가 'b','c'이고 뒤에 최소 한글자 이상으로 이루어진 문자열) 결과 : bat, baby, bonus, cA, ca, co, c., c0, car, combat, count,
 .*a.+ (최소 2글자 이상이며 중간에 'a'를 포함한 문자열) 결과 : bat, baby, car, combat, date,
 [b|c].{2} ('b'나 'c'로 시작하며 뒤에 2글자가 더 붙은 문자열) 결과 : bat, car,
		*/
	}
}
