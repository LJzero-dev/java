package com.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;	//	자바 설정 정보를 읽어와 빈 객체를 생성하고, 관리

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		// AppContext 클래스를 생성자 파라미터로 전달 AppContext에 정의한 @Bean 설정 정보를 읽어와 Greeter 객체를 생성하고 초기화함
		Greeter g = ctx.getBean("greeter", Greeter.class);	//	getBean() 메소드는 AnnotationConfigApplicationContext 클래스가 자바 설정을 읽어와 생성한 빈 객체를 검색할때 사용함
															//	첫번째 파라미터 : @Bean 애노테이션의 메소드 이름인 빈 객체의 이름
															//	두번째 파라미터 : 검색할 빈 객체의 타입
		String msg = g.greet("스프링");						//	스프링, 안녕하세요.
		System.out.println(msg);
		ctx.close();
	}
}