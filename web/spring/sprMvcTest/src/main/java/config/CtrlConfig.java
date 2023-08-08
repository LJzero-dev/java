package config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ctrl.BbsCtrl;
import ctrl.FreeCtrl;
import ctrl.JsonCtrl;
import ctrl.JstlCtrl;
import ctrl.LoginCtrlMvc;
import ctrl.LoginCtrlSpr;
import ctrl.LogoutCtrl;
import ctrl.MemberCtrl;
import ctrl.ScheduleCtrl;
import svc.FreeSvc;
import svc.JsonSvc;
import svc.JstlSvc;
import svc.LoginSvcSpr;
import svc.MemberSvc;
import svc.ScheduleSvc;
import test.TestCtrl;
@Configuration
public class CtrlConfig {
// 구현해 놓은 컨트롤러들을 스프링 빈으로 등록시키는 클래스
	@Autowired
	private LoginSvcSpr loginSvcSpr;
	@Autowired
	private MemberSvc memberSvc;
	@Autowired
	private ScheduleSvc scheduleSvc;
	@Autowired
	private JstlSvc jstlSvc;
	@Autowired
	private FreeSvc freeSvc;
	@Autowired
	private JsonSvc jsonSvc;
	
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
		scheduleCtrl.setSchduleSvc(scheduleSvc);
		return scheduleCtrl;
	}
	@Bean
	public JstlCtrl jstlCtrl() {
		JstlCtrl jstlCtrl = new JstlCtrl();
		jstlCtrl.setJstlSvc(jstlSvc);
		return jstlCtrl;
	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.METHOD)
	public @interface LoginRequired {
	}
	@Bean
	public BbsCtrl bbsCtrl() {
		return new BbsCtrl();
	}
	@Bean
	public FreeCtrl freeCtrl() {
		FreeCtrl freeCtrl = new FreeCtrl();
		freeCtrl.setFreeSvc(freeSvc);
		return freeCtrl;
	}
	@Bean
	public JsonCtrl jsonCtrl() {
		JsonCtrl jsonCtrl = new JsonCtrl();
		jsonCtrl.setJsonSvc(jsonSvc);
		return jsonCtrl;
	}
}
	
