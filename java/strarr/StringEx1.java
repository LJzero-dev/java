class StringEx1{
	public static void main(String[] args) {
		String str1 = "test";
		String str2 = "test";
		String str3 = new String(str2);
		String str4 = new String("test");
		System.out.println(str1 + "/" + str2 + "/" + str3 + "/" + str4);

		if(str1 == str2)			System.out.println("동일 인스턴트 참조");			//	O			//	인스턴스는 '=='로 비교할 경우 안에 있는 데이터가 아닌 주소값으로 비교하므로 정확한 비교가 어려움
		else						System.out.println("다른 인스턴트 참조");							//	그러므로 문자열 인스턴스의 비교는 compareTo()나 equals() 메소드로 해야 함
		if(str2 == str3)			System.out.println("동일 인스턴트 참조");
		else						System.out.println("다른 인스턴트 참조");			//	O	
		if(str1 == str3)			System.out.println("동일 인스턴트 참조");
		else						System.out.println("다른 인스턴트 참조");			//	O	
		if(str3 == str4)			System.out.println("동일 인스턴트 참조");	
		else						System.out.println("다른 인스턴트 참조");			//	O		

									System.out.println();
		
		if(str1.equals(str2))		System.out.println("동일한 문자열");				//	O
		else						System.out.println("다른 문자열");
		if(str2.equals(str3))		System.out.println("동일한 문자열");				//	O
		else						System.out.println("다른 문자열");
		if(str1.equals(str3))		System.out.println("동일한 문자열");				//	O
		else						System.out.println("다른 문자열");
		if(str3.equals(str4))		System.out.println("동일한 문자열");				//	O
		else						System.out.println("다른 문자열");

									System.out.println();
		
		if(str1.compareTo(str2)==0)	System.out.println("동일한 문자열");				//	O
		else						System.out.println("다른 문자열");
		if(str2.compareTo(str3)==0)	System.out.println("동일한 문자열");				//	O
		else						System.out.println("다른 문자열");
		if(str1.compareTo(str3)==0)	System.out.println("동일한 문자열");				//	O
		else						System.out.println("다른 문자열");
		if(str3.compareTo(str4)==0)	System.out.println("동일한 문자열");				//	O
		else						System.out.println("다른 문자열");

		str1 = "C";		str2 = "A";		str3 = "Z";		str4 = "a";

		System.out.println("\"C\".compareTo(\"A\") : " + str1.compareTo(str2));		//	2
		System.out.println("\"C\".compareTo(\"Z\") : " + str1.compareTo(str3));		//	-23
		System.out.println("\"C\".compareTo(\"a\") : " + str1.compareTo(str4));		//	-30
	}
}
