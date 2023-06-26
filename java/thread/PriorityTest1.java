class MessageThread extends Thread {
	String msg;
	public MessageThread(String msg) { this.msg = msg; }
	public void run() {
		for (int i = 0 ; i < 10 ; i++ ) {
			System.out.print(msg + " (" + getPriority() + ") ");	//	getPriority() : 해당 쓰레드의 우선순위를 int형으로 리턴하는 메소드
		}
		System.out.println();
	}
}

class PriorityTest1 {
	public static void main(String[] args) {
		MessageThread mt1 = new MessageThread("1st");
		MessageThread mt2 = new MessageThread("2nd");
		MessageThread mt3 = new MessageThread("3rd");

		mt1.start();	mt2.start();	mt3.start();
	}
}
