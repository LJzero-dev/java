class VariableEx{
	public static void main(String[] args){
		int num1 = 10;	// int 형 변수 num1을 선언 및 생성 후 10을 저장
		int num2 = 20, num3 = num1 + num2;
		//	같은 자료형의 변수일 경우 2개 이상을 동시에 선언할 수 있음
		System.out.println("num1 : " + num1 + "\nnum2 : " + num2 + "\nnum3 : " + num3);
		// nun1 : 10 num2 : 20 num3 : 30

		char c1 = 'a';	// char형이므로 작은 따옴표로 문자를 묶음
		char c2 = 65;	// char형 변수에 정수가 저장되면 그 정수에 해당하는 유니코드 문자로 변환됨
		System.out.println("c1 : " + c1);
		System.out.println("c2 : " + c2);
		// c1 : a,c2 : A

		int n1 = 'A', n2 ='a', n3 = '0', n4 = '가', n5 = '힣';
		// int형 변수에는 char형 값이 들어갈 수 있으며, 유니코드값으로 저장됨
		System.out.println("n1 : " + n1 + "\nn2 : " + n2 + "\nn3 : " + n3 + "\nn4 : " + n4 + "\nn5 : " + n5);
		// A : 65, a : 97, 0 : 48, 가 : 44032, 힣 : 55203

		long num4 = 10000000000L;
		//	정수형 리터럴(손으로 타이핑한) 값 사용시 int의 범위를 벗어나는 경우 접미사로 엘(l)을 붙여서 long형 이라는 표시를 함
		//	접미사에 사용된 영문자 l은 대소문자 구분이 없으나 보통 대문자를 사용
		System.out.println("num4 : " + num4);	//	num4 : 10000000000

		double d1 = 3.14;
		float f1 = 3.14F;
		// 실수의 기본형은 double이므로 실수의 리터럴 값을 float에 저장하려면 접미사 에프(F)를 붙여야 함
		System.out.println("d1 : " + d1);	// d1 : 3.14
		System.out.println("f1 : " + f1);	// f1 : 3.14
	}
}
