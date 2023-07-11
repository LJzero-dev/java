package com.test;

import org.springframework.context.annotation.*;

public class Main2 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		
		Greeter g1 = ctx.getBean("greeter", Greeter.class);
		Greeter g2 = ctx.getBean("greeter", Greeter.class);
		System.out.println("g1 == g2 : " + (g1 == g2));	// g1 == g2 : true
														// �������� �⺻������ �̱����̹Ƿ� �� ���� ��ü���� ������(�޸� ȿ���� ����.)
		String msg = g1.greet("������");	// ������, �ȳ��ϼ���.
		System.out.println(msg);
		msg = g2.greet("���̺�");			// ���̺�, �ȳ��ϼ���.
		System.out.println(msg);
		ctx.close();
	}
}