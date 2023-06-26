class Aa {
	public void testA()					{ System.out.println("Aa's test");		}
	public void rideMethod()			{ System.out.println("Aa's method");	}
	public void loadMethod()			{ System.out.println("Aa's method");	}
}

class Bb extends Aa {
	public void testb()					{ System.out.println("Bb's test");		}
	public void rideMethod()			{ System.out.println("Bb's method");	}	//	오버라이딩
	public void loadMethod(int n)		{ System.out.println("int method");		}	//	오버로딩
}

class Cc extends Bb {
	public void testC()					{ System.out.println("Cc's test");		}
	public void rideMethod()			{ System.out.println("Cc's method");	}	//	오버라이딩
	public void loadMethod(double n)	{ System.out.println("double method");	}	//	오버로딩
}

class RideAndLoad{
	public static void main(String[] args) {
		Aa ref1 = new Cc();	Bb ref2 = new Cc();	Cc ref3 = new Cc();					//	상위 크래스형으로 인스턴스를 선언한 후 하위클래스형으로 생성할 수 있음
		ref1.rideMethod();	ref2.rideMethod();	ref3.rideMethod();					//	즉, 상위클래스형으로 선언한 인스턴스에는 하위클래스형 인스턴스가 저장될 수 있음			
																					//	JVM에서 실제 인스턴스의 자료형인 하위클래스가 아닌 선언한 상위클래스의 자료형으로 인식하여 상위 클래스의 멤버들만 사용가능
	
		//	Cc's method		Cc's method			Cc's method
		//	상위클래스로 선언하고 하위클래스로 생성한 인스턴스는 기본적으로 상위클래스의 메소드에만 접근 가능하나
		//	오버라이딩된 메소드에는 예외적으로 최하위 클래스의 오버라이딩된 메소드가 실행됨

		ref3.loadMethod();	ref3.loadMethod(1);	ref3.loadMethod(1.2);
		//	void method		int method			double method
		//	최하위 클래스의 인스턴스에서는 상위클래스까지 포함하여 이름이 같은 오버로딩된 메소드들을 사용함

		// Cc클래스의 testC() 메소드를 ref1 인스턴스를 이용하여 실행시킴
		Cc ref4 = (Cc)ref1;
		// ref1을 Cc형 인스턴스로 형변환
		ref4.testC();
	}																				
}																					
/*

ref1.teatA() : 실행가능 / ref1.testb(),ref1.textC() : 실행불가
 - ref1이 Aa클래스형으로 JVM에 인식되므로 Aa클래스의 메소드만 사용 가능

 ref2.testA()와 ref2.testB() : 실행가능 / ref2.testC() : 실행불가
 - ref2가 Bb클래스형으로 JVM에 인식되므로 Bb클래스와 Bb의 상위 클래스인 Aa클래스의 메소드만 실행 가능
 
 ref3.testA()와 ref3.testB() ref3.testC() : 실행가능
 - ref3가 Cc클래스형으로 JVM에 인식되므로 Cc클래스와 Cc의 상위 클래스인 Bb클래스와 Aa클래스의 메소드만 실행 가능

*/