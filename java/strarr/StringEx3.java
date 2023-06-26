class StringEx3 {
	public static void main(String[] args) {
		String str1 = "test@abc.com";		String str2 = "testabc.com";
		String str3 = "test@abccom";		String str4 = "test.abc@com";

		emailTest(str1);	emailTest(str2);	emailTest(str3);	emailTest(str4);
	}
	public static void emailTest(String email) {
		/*
		if (email.indexOf("@")==-1){
			System.out.println("email" + email + "은(는) \'@\'가 없습니다.");
		} else if (email.indexOf(".")==-1){
			System.out.println("email" + email + "은(는) \'.\'이 없습니다.");
		} else if (email.indexOf("@")>email.indexOf(".")){
			System.out.println("email" + email + "은(는) \'@\'가 \'.\' 보다 뒤에 있습니다.");
		} else {
			System.out.println("email" + email + "은(는) 이메일이 맞습니다");
		}
		*/
		int at = email.indexOf("@");
		int dot = email.indexOf(".");

		if (at==-1){			System.out.println("email" + email + "은(는) \'@\'가 없습니다.");
		} else if (dot==-1){	System.out.println("email" + email + "은(는) \'.\'이 없습니다.");
		} else if (at>dot){		System.out.println("email" + email + "은(는) \'@\'가 \'.\' 보다 뒤에 있습니다.");
		} else					System.out.println("email" + email + "은(는) 이메일이 맞습니다");
		

		
		



	/* 받아온 email을 검사하여 이메일 주소가 맞는지 출력
	1. 반드시 '@'가 있어야 함 : indexOf()로 -1이 아닌지 여부
	2. 반드시 '.'이 있어야 함 : indexOf()로 -1이 아닌지 여부
	3. 반드시 '@'가 '.'보다 앞에 있어야 함 : indexOf()로 위치값 비교
	4. 출력할 메시지
	 - email + "은(는) '@'가 없습니다."
	 - email + "은(는) '.'이 없습니다."
	 - email + "은(는) '@'가 '.'보다 뒤에 있습니다."
	 - email + "은(는) 이메일이 맞습니다."
	*/
	}
}
