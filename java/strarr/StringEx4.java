class StringEx4 {
	public static void main(String[] args) {
		String str1 = ("880525-1234567");	String str2 = ("890515-22334567");
		String str3 = ("0105253234567");	String str4 = ("0205154234567");

		showBirth(str1);	showBirth(str2);	showBirth(str3);	showBirth(str4);
		showGender(str1);	showGender(str2);	showGender(str3);	showGender(str4);
	}
		public static void showBirth(String str){
		//	주민등록번호를 이용하여 생년월일을 출력하는 메소드
		//	주민등록번호 앞 6자리를 이용하여 "yyyy년 mm월 dd일 생"으로 출력
		int i = 7;
		if (str.indexOf("-") == -1) i = 6;
		if (str.length() == 13)		i = 6;
		char g = str.charAt(i);
		
        StringBuffer sb = new StringBuffer(str);
        String reversedStr = sb.reverse().toString();

		String year = reversedStr.substring(6,7);
		int num = Integer.parseInt(year);
		if (num == 3 || num == 4 || num == 7 || num == 8)	num=20;
		else														num=19;
		System.out.println(num + str.substring(0,2)+"년 " + str.substring(2,4) + "월 " + str.substring(4,6) + "일 생");

		}
		public static void showGender(String str){
		// 주민등록번호를 이용하여 성별을 출력하는 메소드
		// 주민등록번호를 이용하여 "남자" 또는 "여자"로 출력
        StringBuffer sb = new StringBuffer(str);
        String reversedStr = sb.reverse().toString();
		char year = str.charAt(7);
		if (year%2==0)	System.out.println("여자");
		else			System.out.println("남자");
	}
}
