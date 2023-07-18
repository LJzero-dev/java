package config;

import org.springframework.context.annotation.*;
import ctrl.*;
import test.*;

@Configuration
public class CtrlConfig {
// ������ ���� ��Ʈ�ѷ����� ������ ������ ��Ͻ�Ű�� Ŭ����
	@Bean
	public TestCtrl testCtrl() {
		return new TestCtrl();
	}
	
	@Bean
	public IndexCtrl indexCtrl() {
		return new IndexCtrl();
	}
}
