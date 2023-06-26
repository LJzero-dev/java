class Sum {
	int num;
	public Sum() { num = 0; }
	public void addNum(int n) { num += n; }
	public int getNum() { return num; }
}

class AdderThread extends Sum implements Runnable {	//	Thread 클래스를 상속받을 수 없는 상황에서 쓰레드 클래스를
	int start, end;									//	만들려고 한다면 java.lang.runnable 인터페이스를  implements 해야 함
	public AdderThread(int s, int e) {
		start = s; end = e;
	}
	public void run() {								//	Runnable 인터페이스의 abstract 메소드로 반드시 오버라딩하여 구현해야 함
		for (int i = start; i <= end ; i++ ) {
			addNum(i);
		}
	}
}													

class RunnableThread {
	public static void main(String[] args) {		//	at1과 at2는 Runnable 인터페이스를 implemnents한 클래스의 인스턴스이므로 Runnable형 인스턴스 이기도 함
		AdderThread at1 = new AdderThread(1, 50);
		AdderThread at2 = new AdderThread(51, 100);

		Thread tr1 = new Thread(at1);				//	Thread 클래스의 생성자를 이용하여 Runnable의 인스턴스를 매개변수로 하여 Thread의 인스턴스 생성
		Thread tr2 = new Thread(at2);				//	Runnable은 인터페이스므로 인스턴스를 생성할 수 없지만 Runnable을 implements한 클래스로 인스턴스를 생성하면
													//	Runnable형 인스턴스로 사용할 수 있음
		tr1.start();								//	생성된 쓰레드들을 시작함
		tr2.start();
		
		try {
			tr1.join();	tr2.join();					//	해당 쓰레드의 작업이 끝날 때 까지 다른 작업을 대기 시키는 기능
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("1~100 까지의 합 : " + (at1.getNum() + at2.getNum()));
	}
}
