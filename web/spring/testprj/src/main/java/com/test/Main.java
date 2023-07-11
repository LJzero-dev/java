package com.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;	//	�ڹ� ���� ������ �о�� �� ��ü�� �����ϰ�, ����

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		// AppContext Ŭ������ ������ �Ķ���ͷ� ���� AppContext�� ������ @Bean ���� ������ �о�� Greeter ��ü�� �����ϰ� �ʱ�ȭ��
		Greeter g = ctx.getBean("greeter", Greeter.class);	//	getBean() �޼ҵ�� AnnotationConfigApplicationContext Ŭ������ �ڹ� ������ �о�� ������ �� ��ü�� �˻��Ҷ� �����
															//	ù��° �Ķ���� : @Bean �ֳ����̼��� �޼ҵ� �̸��� �� ��ü�� �̸�
															//	�ι�° �Ķ���� : �˻��� �� ��ü�� Ÿ��
		String msg = g.greet("������");						//	������, �ȳ��ϼ���.
		System.out.println(msg);
		ctx.close();
	}
}