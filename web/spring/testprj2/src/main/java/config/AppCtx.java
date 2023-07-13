package config;

import org.springframework.context.annotation.*;
import spr.*;

@Configuration	// 스프링 (객체)설정 클래스로 사용하겠다는 의미
public class AppCtx {
	
	@Bean	// 해당 메소드가 생성한 객체를 스프링에서 관리하는 빈으로 설정한다는 의미 메소드의 이름이 객체의 이름으로 사용됨
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
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter(memberDao(), memberPrinter());		
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter(); 
		infoPrinter.setMemberDao(memberDao());
		infoPrinter.setPrinter(memberPrinter());
		return infoPrinter ;
	}
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(3);
		versionPrinter.setMinorVersion(3);
		return versionPrinter;
	}
}
