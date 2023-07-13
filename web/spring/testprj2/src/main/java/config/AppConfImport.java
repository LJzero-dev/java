package config;

import java.util.*;
import org.springframework.context.*;
import org.springframework.context.annotation.*;
import config.*;
import spr.*;

@Configuration
@Import({AppConf2.class})	// AppConf2 클래스를 import하여 한께 사용 두 개 이상의 설정 클래스도 쉼표로 구분하여 지정할 수 있음 예 : @Import({AppConf1.class, AppConf2.class})
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
