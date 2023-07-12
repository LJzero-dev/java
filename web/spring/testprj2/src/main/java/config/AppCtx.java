package config;

import org.springframework.context.annotation.*;
import spr.*;

@Configuration
public class AppCtx {
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterSvc memberRegSvc() {
		return new MemberRegisterSvc(memberDao());
	}
	
	@Bean
	public ChangePasswordSvc changePwdSvc() {
		ChangePasswordSvc pwdSvc = new ChangePasswordSvc();
		pwdSvc.setMemberDao(memberDao());
		return pwdSvc;
	}
}
