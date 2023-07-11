package com.test;

import org.springframework.context.annotation.*;

public class Main2 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		
		Greeter g1 = ctx.getBean("greeter", Greeter.class);
		Greeter g2 = ctx.getBean("greeter", Greeter.class);
		System.out.println("g1 == g2 : " + (g1 == g2));	// g1 == g2 : true
														// 스프링은 기본적으로 싱글톤이므로 한 개의 객체만을 생성함(메모리 효율이 좋다.)
		String msg = g1.greet("스프링");	// 스프링, 안녕하세요.
		System.out.println(msg);
		msg = g2.greet("메이븐");			// 메이븐, 안녕하세요.
		System.out.println(msg);
		ctx.close();
	}
}