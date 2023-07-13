package config;

import org.springframework.beans.factory.annotation.*;
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
		// pwdSvc.setMemberDao(memberDao());
		// ChangePasswordSvc Ŭ������ memberDao �ν��Ͻ��� @Autowired�� ��������Ƿ� �ڵ����� ���ԵǱ� ������ setter�� ȣ�� ���� �ʾƵ� �� 
		return pwdSvc;
	}
/*	
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}

	@Bean
	@Primary
	@Qualifier("printer")	// �ڵ� ������ ������ ���� �� ���� ��� �� �� @Qualifier("�� �̸�")�� �ٿ� �ϳ��� �����ϰ� ��
	public MemberPrinter memberPrinter1() {
		return new MemberPrinter();
	}@Bean
	public MemberPrinter memberPrinter2() {
		return new MemberPrinter();
	}
*/
	// Ư�� �ֳ����̼�(@Primary, @Qualifier)�� ������� ������ memberPrinter1�� memberPrinter2�� ������ �߻��ϰ� �� ���� Ŭ������ MemberPrinter�� ����Ŭ������ MemberSummaryPrinter�� �� �� �־ �ڵ����Կ� ����� ���� � ������ ���� ���� �� ����, ���� �߻�
	@Bean
	@Primary
	@Qualifier("printer")
	public MemberPrinter memberPrinter1() {
		return new MemberPrinter();
	}
	@Bean
	public MemberSummaryPrinter memberPrinter2() {
		return new MemberSummaryPrinter();
	}	
	@Bean
	public MemberListPrinter listPrinter() {
		// return new MemberListPrinter(memberDao(), memberPrinter());		
		return new MemberListPrinter();
		// memberDao�� printer �ν��Ͻ��� @Autowired�� ����ؼ� ���� �ν��Ͻ��� ������ �ʿ䰡 ����
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter(); 
		// infoPrinter.setMemberDao(memberDao());
		// infoPrinter.setPrinter(memberPrinter());
		// @Autowired�� �ڵ����� �ϱ� ������ setter�� ȣ���� �ʿ� ����
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
