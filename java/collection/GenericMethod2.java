class Aa {
	public String toString() { return "class Aa"; }
}

class Bb {
	public String toString() { return "class Bb"; }
}

class InstanceTypeShow2 {
	public <T, U> void showInstType(T inst1, U inst2) {
		System.out.println(inst1);
		System.out.println(inst2);
	}
}

class GenericMethod2 {
	public static void main(String[] args) {
		Aa a = new Aa();	Bb b = new Bb();
		InstanceTypeShow2 show = new InstanceTypeShow2();

		show.<Aa, Bb>showInstType(a, b);	//	showInstType() 메소드의 인수로 사용할 자료형을 각각 Aa와 Bb로 지정한 후 호출
											//	제네릭으로 인수의 자료형을 지정할 경우 인수의 순서를 맞춰서 작업해야 함

		show.showInstType(b, a);			//	메소드의 제네릭에서는 인수의 자료형을 컴파일러가 알아서 파악하여 따로 지정하지 않아도 됨
	}										//	제네릭 생략 시 인수의 순서를 신경써서 작업해야 함
}
