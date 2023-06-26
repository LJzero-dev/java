class MethodReturn1{
	public static void main(String[] args){
		int result = adder(4,5);
		// 4와 5를 인수로 하여 adder() 메소드를 실행한 결과값을 받아와 result 변수에 저장
		System.out.println("4와 5의 합 : " + result);
		System.out.println("3.5의 제곱 : " + square(3.5));
		System.out.println("3.5의 제곱 : " + Math.pow(3.5,0.5));
		
	}
	public static int adder(int n1, int n2){
		return n1 + n2;
	}
	public static double square(double n1){
		return n1*n1;
	}
}
