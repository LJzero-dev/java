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
	
	@Bean(initMethod="connect", destroyMethod="close")	// InitializingBean �� DisposableBean �������̽��� implements ���� �ʰ�, �ʱ�ȭ�� �Ҹ� �� ������ �޼ҵ� ����
														//	initMethod �Ӽ��� �ʱ�ȭ �޼ҵ�� destroyMethod �Ӽ��� �Ҹ� �޼ҵ���� ���� �����Ͽ������ �� ���� (�Ű����� ���� �����߻�)
	public Client2 client2() {
		Client2 client2 = new Client2();
		client2.setHost("Host2");
		return client2;
	}
}