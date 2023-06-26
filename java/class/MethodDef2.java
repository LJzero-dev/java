class MethodDef2{
	public static void main(String[] args){
		double height = 177.1;
		testMethod1(33, height);

		// 두 개의 정수를 받아 두 수의 차의 절대값을 출력해주는 메소드 작성
		printAbs(10, 5);
		printAbs(10, 25);
		printAbs(-2, 7);
	}
	
	public static void printAbs(int n1,int n2){
			int def = 0;	// 두 수의 차를 저장할 변수

			if(n1 > n2)		def = n1 - n2;
			else			def = n2 - n1;

			def = n1 - n2;
			if (def < 0)	def = n2 - n1;

			def = n1 - n2;
			if (def < 0)	def *= -1;
			
			def = n1 > n2 ? n1 - n2 : n2 - n1;
			def = Math.abs(n1-n2);

			System.out.println(n1 + "과 " + n2 + "의 차는 " + def);
		}

	// 나이와 키를 받아 출력 하는 testMethod1()메소드 작성
	public static void testMethod1(int age,double height){
		System.out.println("제 나이는 " +  age + "세 입니다.");
		System.out.println("제 신장은 " +  height + "cm 입니다.");
	}	
}