package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import spr.Client;
import spr.Client2;

@Configuration
public class AppCtxPrototype {
	@Bean
	@Scope("prototype")	// �����Ǵ� �� ��ü�� singleton�� �ƴ� prototype���� ����	���ο� �� ��ü�� ����� �� �� ���� �ٸ� ��ü�� ������(���󵵴� ����)
	public Client client() {
		Client client = new Client();
		return client;
	}
	@Bean(initMethod="connect", destroyMethod="close")
	@Scope("singleton")	// �����Ǵ� �� ��ü�� singleton���� ����(�⺻���̹Ƿ� ��������)	�� ��ü�� ���� �����ص� ��� ���� ��ü��
	public Client2 client2() {
		Client2 client2 = new Client2();
		client2.setHost("Host2");
		return client2;
	}
}