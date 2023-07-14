package config;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import spr.*;

@ComponentScan(basePackages = {"spr"})	// spr과 그 하위 패키지를 스캔 대상으로 지정
@Configuration	// 스프링 (객체)설정 클래스로 사용하겠다는 의미
public class AppCtx {
	/*
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
		// pwdSvc.setMemberDao(memberDao());
		// ChangePasswordSvc 클래스의 memberDao 인스턴스에 @Autowired를 사용했으므로 자동으로 주입되기 때문에 setter를 호출 하지 않아도 됨 
		return pwdSvc;
	}
	*/

	// 특정 애노테이션(@Primary, @Qualifier)을 사용하지 않으면 memberPrinter1과 memberPrinter2는 오류가 발생하게 됨 상위 클래스인 MemberPrinter로 하위클래스인 MemberSummaryPrinter가 들어갈 수 있어서 자동주입에 사용할 빈이 어떤 것인지 한정 지을 수 없어, 오류 발생
	
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
	/*
	@Bean
	public MemberListPrinter listPrinter() {
		// return new MemberListPrinter(memberDao(), memberPrinter());		
		return new MemberListPrinter();
		// memberDao와 printer 인스턴스에 @Autowired를 사용해서 따로 인스턴스를 가져갈 필요가 없음
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter(); 
		// infoPrinter.setMemberDao(memberDao());
		// infoPrinter.setPrinter(memberPrinter());
		// @Autowired로 자동주입 하기 때문에 setter를 호출할 필요 없음
		return infoPrinter ;
	}
	*/
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(3);
		versionPrinter.setMinorVersion(3);
		return versionPrinter;
	}
}
