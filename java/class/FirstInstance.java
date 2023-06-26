class NumberEx{
	int num = 0;	// 멤버변수로 NumberEx 클래스 내에서 자유롭게 사용가능
	public void addNum(int n) {
		num += n;
	}
	public int getNumber() {
		return num;
	}
}

class  FirstInstance{
	public static void main(String[] args) {
		NumberEx nInst;
		// NumberEx형 인스턴스 nInst를 선언(메모리에 공가능ㄹ 잡진 않고 주소만 등록된 상태)
		nInst = new NumberEx();
		// 선언했던 NumberEx형 인스턴스 nInst를 생성(선언시 등록된 주소에 실제 내용을 넣어 공간을 차지)
		System.out.println("메소드 호출 전 : " + nInst.getNumber());
		// nInst.getNumber() : nInst 인스턴스 안에 있는 getNumber() 메소드를 호출(실행)하라는 명령

		nInst.addNum(10);
		System.out.println("메소드 호출 후 : " + nInst.getNumber());
		// nInst.addNum(10); : nInst 인스턴스 안에 있는 addNum() 메소드를 10을 가지고 호출

		NumberEx nInst2 = new NumberEx();
		// NumberEx형 인스턴스 nInst2를 생성
		nInst2.addNum(100);
		System.out.println("nInst2 : " + nInst2.getNumber());	// 100

		int test = 10;
		testMethod(test);
		System.out.println("test : " + test);	// 10
		// 메소드의 인수로 변수(기본 자료형)를 가져갈 경우 변수의 값을 복사해서 가져감(원본 변경 불가)
		
		testMethod2(nInst);
		System.out.println("nInst : " + nInst.getNumber());		// 22
		// 메소드의 인수로 인스턴스를 가져갈 경우 인스턴스의 값에 해당하는 주소값을 가져감
		// 주소를 가져가므로 그 주소에 해당하는 인스턴스의 내용을 편집(원본이 변경됨)
	}
	public static void testMethod(int num) {
		num +=12;
	}
	public static void testMethod2(NumberEx num) {
		num.addNum(12);
	}
}
