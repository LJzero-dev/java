package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ctrl.LoginCtrlMvc;
import ctrl.LoginCtrlSpr;
import svc.LoginSvcSpr;
import test.TestCtrl;

@Configuration
public class CtrlConfig {
// 구현해 놓은 컨트롤러들을 스프링 빈으로 등록시키는 클래스
	@Autowired
	private LoginSvcSpr loginSvcSpr;	
	
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
}
