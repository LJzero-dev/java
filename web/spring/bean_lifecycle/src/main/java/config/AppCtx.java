package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spr.*;

@Configuration
public class AppCtx{
	
	@Bean
	public Client client() {
		Client client = new Client();
		client.setHost("Host");
		return client;
	}
	
	@Bean(initMethod="connect", destroyMethod="close")	// InitializingBean 과 DisposableBean 인터페이스를 implements 하지 않고, 초기화와 소멸 시 동작할 메소드 지정
														//	initMethod 속성에 초기화 메소드명 destroyMethod 속성에 소멸 메소드명을 각각 지정하여사용할 수 있음 (매개변수 사용시 오류발생)
	public Client2 client2() {
		Client2 client2 = new Client2();
		client2.setHost("Host2");
		return client2;
	}
}