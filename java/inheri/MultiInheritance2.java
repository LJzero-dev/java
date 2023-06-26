interface TV {
	void onTV();
}

class TVImpl {
	public void onTV() { System.out.println("영상 출력 중"); }
}

interface Computer {
	void dataReceive();
}

class ComputerImpl {
	public void dataReceive() { System.out.println("영상 데이터 수신 중"); }
}

class IPTV implements TV , Computer{		//	자바에서는 다중상속을 지원하지 않으므로 에러 발생	한가지 클래스를 인터페이스로 변경시켜 작업
	ComputerImpl com = new ComputerImpl();
	TVImpl tv = new TVImpl();
	public void onTV(){
		tv.onTV();
	}
	public void dataReceive() {
		com.dataReceive();
	}
	public void powerOn(){
		tv.onTV();
	}
}

class MultiInheritance2 {
	public static void main(String[] args) {
		IPTV iptv = new IPTV();
		iptv.powerOn();
		
		TV tv = iptv;							//	IPTV의 상위클래스인 TV형 인스턴스에 IPTV의 인스턴스가 저장됨
		Computer com = iptv;					//	IPTV에서 구현(implements)한 Computer형 인스턴스에 IPTV의 인스턴스가 저장됨
	}											//	Computer는 interFace이지만 상위클래스인것 처럼 동작할 수 있음
}
