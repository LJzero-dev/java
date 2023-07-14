package spr;


public class Client2 {
private String host;
	
	public void setHost(String host) {
		this.host = "host";
	}	
	public void send() {
		System.out.println("Client2.send() to " + this.host);
	}
	public void connect() throws Exception {
		System.out.println("Client2.connect() 초기화 메소드 실행");
	}
	public void close() throws Exception {
		System.out.println("Client2.close() 소멸 메소드 실행");
	}
}
