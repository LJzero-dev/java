package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kakaoApi.KakaoCtrl;
import kakaoApi.KakaoSvc;
import svc.JstlSvc;

@Configuration
public class KakaoConfig {
	@Bean
	public KakaoCtrl kakaoCtrl() {
		return new KakaoCtrl();
	}
	@Bean
	public KakaoSvc kakaoSvc() {
		return new KakaoSvc();
	}
}