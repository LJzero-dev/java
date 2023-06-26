class ShowThread extends Thread {							//	Thread 클래스를 상속받음으로써 ShowThread클래스는 쓰레드로 사용할 수 있음
	String name;											//	Main Thread가 아닌 다른 process로 동작한다는 의미
	public ShowThread(String name) { this.name = name; }	//	하위클래스의 생성자로 원래는 상위 클래스인 Thread의 생성자를 호출해야 함
															//	단, Thread클래스의 생성자들 중 기본생정자(매개변수가 없는 생성자)가 있으므로 생략 가능
	public void run() {										//	상위 클래스인 Thread의 run() 메소드를 오버라이딩하는 메소드로 해당 쓰레드에서 할 일을 정의
		for (int i = 0; i < 5 ; i++ ) {						//	특정 쓰레드의 start() 메소드를 호출하면 해당 쓰레드의 run() 메소드가 자동으로 호출됨
			System.out.println("안녕하세요. " + name + "입니다.");
			try {
				sleep(100);									//	일시 멈춤으로 밀리초 단위로 작업
			}												//	현재 실행중인 쓰레드를 0.1초간 멈춤
			catch (InterruptedException e) {				//	상위 클래스인 Thread 메소드로 하위클래스에서 자유롭게 호출 가능
				e.printStackTrace();
			}
		}
	}
}

class FirstThred{
	public static void main(String[] args) {				//	st1과 s2라는 process를 가진 두 개의 쓰레드를 생성
		ShowThread st1 = new ShowThread("1st 쓰레드");		
		ShowThread st2 = new ShowThread("2nd 쓰레드");

		st1.start();										//	st1이라는 쓰레드를 실행시킴(st1 인스턴스의 run() 메소드 호출)
		st2.start();										//	쓰레드는 실행시키는 순서와 상관없이 먼저 CPU를 차지하는 쪽이 먼저 실행됨
	}
}
