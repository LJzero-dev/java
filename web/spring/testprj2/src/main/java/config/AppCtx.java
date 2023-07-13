package config;

import org.springframework.context.annotation.*;
import spr.*;

@Configuration	// ������ (��ü)���� Ŭ������ ����ϰڴٴ� �ǹ�
public class AppCtx {
	
	@Bean	// �ش� �޼ҵ尡 ������ ��ü�� ���������� �����ϴ� ������ �����Ѵٴ� �ǹ� �޼ҵ��� �̸��� ��ü�� �̸����� ����
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
