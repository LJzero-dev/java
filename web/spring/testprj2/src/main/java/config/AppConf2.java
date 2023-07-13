package config;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import spr.*;

public class AppConf2 {
	@Autowired	// 스프링의 자동주입으로 해당 타입의 빈을 찾아서 필드에 할당
	private MemberDao memberDao;	// @Autowird 애노테이션을 사용했으므로 MemberDao 탕비의 빈을 찾아 memberDao 필드에 할당함
	@Autowired 						// AppConf1 클래스에서 MemberDao 타입의 빈을 설정했으므로 AppConf2 클래스의 memberDao 필드에는 AppConf1 클래스에서 설정한 빈이 할당됨
	private MemberPrinter memberPrinter;
	
	@Bean
	public MemberRegisterSvc memberRegSvc() {
		return new MemberRegisterSvc(memberDao);
	}	
	@Bean
	public ChangePasswordSvc changePwdSvc() {
		ChangePasswordSvc pwdSvc = new ChangePasswordSvc();
		pwdSvc.setMemberDao(memberDao);
		return pwdSvc;
	}
	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter(memberDao, memberPrinter);		
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter(); 
		infoPrinter.setMemberDao(memberDao);
		infoPrinter.setPrinter(memberPrinter);
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