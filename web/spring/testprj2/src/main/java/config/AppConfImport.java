package config;

import java.util.*;
import org.springframework.context.*;
import org.springframework.context.annotation.*;
import config.*;
import spr.*;

@Configuration
@Import({AppConf2.class})	// AppConf2 Ŭ������ import�Ͽ� �Ѳ� ��� �� �� �̻��� ���� Ŭ������ ��ǥ�� �����Ͽ� ������ �� ���� �� : @Import({AppConf1.class, AppConf2.class})
public class AppConfImport {
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}	
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}	
}
