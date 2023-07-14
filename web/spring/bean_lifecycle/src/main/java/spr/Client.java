package spr;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Client implements DisposableBean, InitializingBean {
	private String host;
	
	public void setHost(String host) {
		this.host = "host";
	}	
	public void send() {
		System.out.println("Client.send() to " + this.host);
	}
	public void afterPropertiesSet() throws Exception {
		System.out.println("Client.afterPropertiesSet() 실행");
	}
	public void destroy() throws Exception {
		System.out.println("Client.destroy() 실행");
	}
}