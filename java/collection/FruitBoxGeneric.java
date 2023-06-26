class Orange {
	int sugar;
	public Orange(int s) { sugar = s; }
	public void showSugar() { System.out.println("당도 : " + sugar); }
}

class Apple {
	int weight;
	public Apple(int w) { weight = w; }
	public void showWeight() { System.out.println("무게 : " + weight); }
}

class FruitBox<T> {		//	FruitBox 클래스의 인스턴스 생성을 위해 선언할 때 <T>에 해당하는 자료형 클래스를 입력하라는 의미
	T item;				//	<T>는 기본적으로 Object를 의미하므로 어떤 종류의 클래스를 입력해도 됨 - T 대신 들어갈 자료형을 지정하는 것
	public void store(T item) { this.item = item; }
	public T pullOut() { return item; }
}

class FruitBoxGeneric {
	public static void main(String[] args) {			//	FruitBox의 인스턴스 생성 시 <T>대신 Orange클래스를 넣음
		FruitBox<Orange> box1 = new FruitBox<Orange>();	//	반드시 Orange클래스에 해당하는 데이터 만을 사용해야 한다는 제약조건 성립
		box1.store(new Orange(10));						//	Orange인스턴스가 아닌 다른 자로형을 넣으면 오류 발생
		Orange org1 = box1.pullOut();					//	box1 인스턴스 생성 시 제네릭으로 Orange를 지정했기 떄문에 따로 형변환 불필요
		org1.showSugar();
									
														//	제네릭으로 Apple클래스를 지정하여 출력 - 무게 20
		FruitBox<Apple> box2 = new FruitBox<Apple>();	//	FruitBox의 인스턴스 생성 시 <T>대신 Apple클래스를 넣어 Apple인스턴스만 사용하겠다는 의미
		box2.store(new Apple(20));
		Apple apple1 = box2.pullOut();
		apple1.showWeight();

		FruitBox box3 = new FruitBox();					//	FruitBox의 인스턴스 생성 시 제네릭으로 지정하지 않았으므로 <T>는 Object로 인식됨
		box3.store(new Apple(30));						//	제네릭으로 특정 자료형을 지정하지 않았으므로 String같은 전혀 상관없는 자료형의 인스턴스도 들어감
		Apple apple2 = (Apple)box3.pullOut();					//	그렇게 되면 컴파일시에는 오류가 없으나 실행 시 ClassCastException 예외가 발생할 수 있음
		apple2.showWeight();							//	제네릭으로 특정 자료형을 지정하지 않았으므로 pullOut()으로 받아온 객체를 형변환해서 사용해야 함
	}
}