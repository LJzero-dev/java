//	멤버변수 int num = 0 선언한 후 num의 값을 1증가 시킨 후 출력 test() 메소드 생성

class NonSingleton {
	private int num = 0;

	public void test() {
		num++;
		System.out.println("NonSingleton class's num : " + num);
	}
}

class SingletonClass {
	private int num = 0;
	private static SingletonClass sc = null;

	private SingletonClass() {}

	public static SingletonClass getInstance() {	//	SingletonClass의 인스턴스를 생성하여 리턴하는 메소드로 인스턴스 없이 접근 가능하도록 static으로 선언하여 사용
		if (sc == null)	{
			sc = new SingletonClass();
		}
		return sc;
	}

	public void test() {
		num++;
		System.out.println("SingletonClass class's num : " + num);
	}
}

class SingletonTest {
	public static void main(String[] args) {	//	NonSingleton 클래스의 인스턴스를 3개 생성한 후 각각의 인스턴스로 test() 메소드 실행
		NonSingleton ns1 = new NonSingleton();	  ns1.test(); 	  //	NonSingleton class's num : 1
		NonSingleton ns2 = new NonSingleton();	  ns2.test(); 	  //	NonSingleton class's num : 1
		NonSingleton ns3 = new NonSingleton();	  ns3.test(); 	  //	NonSingleton class's num : 1

		SingletonClass sc1 = SingletonClass.getInstance();	sc1. test();	//	SingletonClass class's num : 1
		SingletonClass sc2 = SingletonClass.getInstance();	sc2. test();	//	SingletonClass class's num : 2
		SingletonClass sc3 = SingletonClass.getInstance();	sc3. test();	//	SingletonClass class's num : 3
		
	}
}
