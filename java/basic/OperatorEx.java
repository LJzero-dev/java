class OperatorEx{
	public static void main(String[] args){
		int n1 = 7, n2 = 3, n3;
		System.out.println("7 / 3 = " + n1 / n2); // 7 / 3 = 2
		System.out.println("7 % 3 = " + n1 % n2); // 7 % 3 = 1

		double d1 = 3.0;
		System.out.println("7 / 3.0 = " + n1 / d1); // 7 / 3.0 = 2.3333333333333335
		System.out.println("7 % 3.0 = " + n1 % d1); // 7 % 3.0 = 1.0
		//	산술연산 시 피연산자 중 하나라도 실수일 경우 결과값은 실수로 나옴
		//	실수의 연산은 정확한 결과값을 얻을 수 없으므로 BigDecimal 클래스 사용

		n1 = 5;		n2 = ++n1;		n3 = --n1;
		// prefix 방식으로 증감연산 사용(먼저 증감 한 후 사용==대입)
		System.out.println("n1 : " + n1 + "\nn2 : " + n2 + "\nn3 : " + n3 );
		// n1 : 5, n2 : 6, n3 : 5

		n1 = 5;		n2 = n1++;		n3 = n1--;
		// prefix 방식으로 증감연산 사용(먼저 사용 한 후 증감==대입)
		System.out.println("n1 : " + n1 + "\nn2 : " + n2 + "\nn3 : " + n3 );
		// n1 : 5, n2 : 5, n3 : 6
		// 증감 연산자를 prefix나 postfix 방식으로 나누어 사용하는 것이 헷갈리면 증감과 사용 부분을 분리하여 작업할 수 있음
		// n2 = ++n1; => n1++;	n2 = n1;

		n1 = 0;		n2 = 0;		boolean result;

		result = (n1 += 10) < 0 && (n2 += 10) > 0;
		// && 연산이므로 앞의 조건이 false이면 뒤의 조건에 상관없이 결과가 false이므로 뒤쪽 조건은 실행하지 않음
		System.out.println("result : " + result);	//	result : false
		System.out.println("n1 : " + n1 + "\nn2 : " + n2);	//	n1 : 10, n2 : 0

		result = (n1 += 10) > 0 || (n2 += 10) > 0;
		// && 연산이므로 앞의 조건이 true이면 뒤의 조건에 상관없이 결과가 true이므로 뒤쪽 조건은 실행하지 않음
		System.out.println("result : " + result);	//	result : true
		System.out.println("n1 : " + n1 + "\nn2 : " + n2);	//	n1 : 20, n2 : 0

		// 논리식 내부에서는 값을 변경하는 수식을 사용하지 않는 편이 좋다.
		n1 = 0;		n2 = 0;
		n1 += 10;	n2 += 10;
		
		result = n1 < 0 && n2 > 0;
		System.out.println("result : " + result);	//	result : false
		System.out.println("n1 : " + n1 + "\nn2 : " + n2);	//	n1 : 10, n2 : 10

		n1 += 10;	n2 += 10;
		result = n1 > 0 || n2 < 0;
		System.out.println("result : " + result);	//	result : true
		System.out.println("n1 : " + n1 + "\nn2 : " + n2);	//	n1 : 20, n2 : 20
	}
}
