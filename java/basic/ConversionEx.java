class ConversionEx {
	public static void main(String[] args){
		byte b1 = 10;	// byte형 변수 b1을 선언하고, 10을 저장
		short s1 = b1;	// 작은 크기의 데이터는 큰 크기의 자료형에 저장될 수 있음(자동 형변환)
		System.out.println("s1 : " + s1);	//	s1 : 10
		s1 = 'a';
		System.out.println("s1 : " + s1);	//	s1 : 97

		float f1 = 3.14F;
		double d1 = f1;
		System.out.println("d1 : " + d1);	//	d1 : 3.140000104904175

		f1 = 20;
		// 정수를 실수형 변수에 넣을 수 있으나 반대로 실수를 정수형 변수에 넣을 수 없음
		System.out.println("f1 : " + f1);	//	f1 : 20.0
	}
}
