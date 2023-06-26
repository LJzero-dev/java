class BoxingUnboxing {
	public static void main(String[] args) {
		Integer iValue = new Integer(10);
		Double dValue = new Double(3.14);										//	boxing으로 기본 자료형 데이터를 인스턴스로 만듦
		System.out.println("iValue : " + iValue + ", dValue : " + dValue);		//	iValue : 10, dValue : 3.1410
		Integer iValue2 = new Integer(iValue.intValue() + 10);
		Double dValue2 = new Double(dValue.doubleValue() + 1.2);
		System.out.println("iValue2 : " + iValue2 + ", dValue2 : " + dValue2);	//	iValue2 : 20, dValue2 : 4.34

		Integer iValue3 = 10;		Double dValue3 = 3.14;						//	auto boxing으로 new 명령을 사용하지 않고 기본 자료형 데이터를 직접 넣어 boxing함
		System.out.println("iValue3 : " + iValue3 + ", dValue3 : " + dValue3);	//	iValue3 : 10, dValue3 : 3.14

		int n1 = iValue + 10;		double d1 = dValue + 1.2;					//	auto unboxing으로 기본 자료형 변수에 넣을 수 있음
		System.out.println("n1 : " + n1 + ", d1 : " + d1);						//	n1 : 20, d1 : 4.34

		String str = "123";
		Integer strInt11 = new Integer(str);									//	문자열도 Integer형 인스턴스로 생성할 수 있음(단, 숫자처럼 생긴 문자열만 가능)
		int strInt12 = strInt11 + 10;
		System.out.println("strInt12 : " + strInt12);							//	strInt2 : 133

		Integer strInt21 = Integer.valueOf(str);								//	static 메소드인 valueOf()를 사용하면 new 없이 문자열을 Integer형 인스턴스로 생성할 수 있음
		int strInt22 = strInt21 + 10;
		System.out.println("strInt22 : " + strInt22);							//	strInt2 : 133

		int strInt31 = Integer.parseInt(str);									//	문자열을 int형 데이터로 생성
		int strInt32 = strInt31 + 10;
		System.out.println("strInt32 : " + strInt32);							//	strInt32 : 133

//		Integer strInt4 = "123";												//	문자열 자체를 Integer형 인스턴스에 넣는 것은 불가
	}
}
