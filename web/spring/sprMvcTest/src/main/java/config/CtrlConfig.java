package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ctrl.LoginCtrlMvc;
import ctrl.LoginCtrlSpr;
import ctrl.LogoutCtrl;
import ctrl.MemberCtrl;
import svc.LoginSvcSpr;
import svc.MemberSvc;
import test.TestCtrl;

@Configuration
public class CtrlConfig {
// ������ ���� ��Ʈ�ѷ����� ������ ������ ��Ͻ�Ű�� Ŭ����
	@Autowired
	private LoginSvcSpr loginSvcSpr;
	@Autowired
	private MemberSvc memberSvc;
	
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
}
