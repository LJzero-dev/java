/*
각 쓰레드 별로 다른 우선순위를 주어 동작시키고 그 우선순위를 출력
*/
class MessageThread2 extends Thread {
	String msg;	int prio;
	public MessageThread2(String msg, int prio) {
		this.msg = msg;	this.prio = prio;
		
		try {
			setPriority(prio);	//	setPriority() : Thread 클래스의 메소드로 해당 쓰레드의 우선 순위를 지정
		}						//	우선순위를 지정해도 상황에 따라 우선순위를 무시하고 낮은 우선순위의 쓰레드가 먼저 실행 될 수 있음
		catch ( Exception e ) {	//	그러므로 순서를 지켜야 하는 프로그램에서는 쓰레드를 사용하면 안됨
			e.printStackTrace();
		}
	}
	public void run() {
		for (int i = 0 ; i < 10 ; i++ ) {
			System.out.print(msg + " (" + getPriority() + ") ");
		}
		System.out.println();
	}
}

class PriorityTest2 {
	public static void main(String[] args) {
		MessageThread2 mt1 = new MessageThread2("1st", Thread.MAX_PRIORITY);	//	MAX_PRIORITY : 10의 int 값으로 가장 높은 우선순위값
		MessageThread2 mt2 = new MessageThread2("2nd", Thread.NORM_PRIORITY);	//	NORM_PRIORITY : 5의 int 값으로 평균  우선순위값(기본값)
		MessageThread2 mt3 = new MessageThread2("3rd", Thread.MIN_PRIORITY);	//	MIN_PRIORITY : 1의 int 값으로 가장 낮은 우선순위값
		
		
		mt1.start();	mt2.start();	mt3.start();
	}
}
