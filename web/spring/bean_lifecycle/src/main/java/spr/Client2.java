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
		System.out.println("Client2.connect() �ʱ�ȭ �޼ҵ� ����");
	}
	public void close() throws Exception {
		System.out.println("Client2.close() �Ҹ� �޼ҵ� ����");
	}
}
