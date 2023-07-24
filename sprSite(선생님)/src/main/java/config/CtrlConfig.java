package config;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import ctrl.*;
import test.*;
import svc.*;

@Configuration
public class CtrlConfig {
// 구현해 놓은 컨트롤러들을 스프링 빈으로 등록시키는 클래스
	@Autowired
	private LoginSvcSpr loginSvcSpr;

	@Autowired
	private MemberSvc memberSvc;

	@Autowired
	private ScheduleSvc scheduleSvc;

	@Bean
	public TestCtrl testCtrl() {
		return new TestCtrl();
	}
/*
	@Bean
	public IndexCtrl indexCtrl() {
		return new IndexCtrl();
	}*/

	@Bean
	public LoginCtrlMvc loginCtrlMvc() {
		return new LoginCtrlMvc();
	}

	@Bean
	public LoginCtrlSpr loginCtrlSpr() {
		LoginCtrlSpr loginCtrlSpr = new LoginCtrlSpr();
		loginCtrlSpr.setLoginSvcSpr(loginSvcSpr);
		return loginCtrlSpr;
	}

	@Bean
	public LogoutCtrl logoutCtrl() {
		return new LogoutCtrl();
	}

	@Bean
	public MemberCtrl memberCtrl() {
		MemberCtrl memberCtrl = new MemberCtrl();
		memberCtrl.setMemberSvc(memberSvc);
		return memberCtrl;
	}

	@Bean
	public ScheduleCtrl scheduleCtrl() {
		ScheduleCtrl scheduleCtrl = new ScheduleCtrl();
		scheduleCtrl.setScheduleSvc(scheduleSvc);
		return scheduleCtrl;
	}
}
