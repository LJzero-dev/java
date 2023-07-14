package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import spr.Client;
import spr.Client2;

@Configuration
public class AppCtxPrototype {
	@Bean
	@Scope("prototype")	// 생성되는 빈 객체를 singleton이 아닌 prototype으로 지정	새로운 빈 객체가 만들어 질 때 마다 다른 객체가 생성됨(사용빈도는 낮음)
	public Client client() {
		Client client = new Client();
		return client;
	}
	@Bean(initMethod="connect", destroyMethod="close")
	@Scope("singleton")	// 생성되는 빈 객체를 singleton으로 지정(기본값이므로 생략가능)	빈 객체를 여럿 생성해도 모두 같은 객체임
	public Client2 client2() {
		Client2 client2 = new Client2();
		client2.setHost("Host2");
		return client2;
	}
}