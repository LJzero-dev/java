package config;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import spr.*;

public class AppConf2 {
	@Autowired	// �������� �ڵ��������� �ش� Ÿ���� ���� ã�Ƽ� �ʵ忡 �Ҵ�
	private MemberDao memberDao;	// @Autowird �ֳ����̼��� ��������Ƿ� MemberDao ������ ���� ã�� memberDao �ʵ忡 �Ҵ���
	@Autowired 						// AppConf1 Ŭ�������� MemberDao Ÿ���� ���� ���������Ƿ� AppConf2 Ŭ������ memberDao �ʵ忡�� AppConf1 Ŭ�������� ������ ���� �Ҵ��
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