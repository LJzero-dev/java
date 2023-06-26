class MethodDef1{
	public static void main(String[] args){
		System.out.println("프로그램의 시작");		

		testMethod(33); // 33이라는 값을 가지고 testMethod()를 호출

		System.out.println("프로그램의 시작");
	}

	public static void testMethod(int age){
		System.out.println("제 나이는 " +  age + "세 입니다.");
	}
}
