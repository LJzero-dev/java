package config;

import org.springframework.context.annotation.*;
import spr.*;

public class AppConf1 {
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}	
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
}
