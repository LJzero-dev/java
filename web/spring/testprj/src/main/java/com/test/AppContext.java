package com.test;

import org.springframework.context.annotation.*;
//	pom.xml에 org.springframework <dependency>를 추가한 후 사용해야 함
//	정상적으로 입력해도 안될 경우 [alt + f5]를 눌러 프로젝트 전체를 업데이트 해야함

@Configuration
public class AppContext {
	@Bean	// @bean 애노테이션이 붙으면 해당 메소드에서 생성한 객체를 스프링이 관리하는 빈 객체로 등록됨
	public Greeter greeter() {
		Greeter g = new Greeter();
		g.setFormat("%s, 안녕하세요.");
		return g;
	}
}