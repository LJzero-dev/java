package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import test.TestCtrl;

@Configuration
public class CtrlConfig {	// ������ ���� ��Ʈ�ѷ����� ������ ������ ��Ͻ�Ű�� Ŭ����
	@Bean
	public TestCtrl testCtrl() {
		return new TestCtrl();
	}
}
