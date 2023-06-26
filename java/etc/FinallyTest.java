class FinallyTest {
	public static void main(String[] args) {
		boolean isDiv = divier(4, 2);
		if (isDiv)	System.out.println("연산 성공");
		else		System.out.println("연산 실패");
		boolean isDiv2 = divier(4, 0);
		if (isDiv2)	System.out.println("연산 성공");
		else		System.out.println("연산 실패");
	}
	public static boolean divier(int n1, int n2){
		try {
			int result = n1 / n2;
			System.out.println("나눗셈 결과 : " + result);
			return true;
		} catch (ArithmeticException e) {
			e.printStackTrace();						//	예외 발생된 내역 확인
			return false;
		} finally {										//	예외 발생 및 return 실행 여부와 상관없이 무조건 동작하는 영역
			System.out.print("finally 영역 실행");
		}
	}
}
