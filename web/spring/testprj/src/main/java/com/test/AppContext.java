package com.test;

import org.springframework.context.annotation.*;
//	pom.xml�� org.springframework <dependency>�� �߰��� �� ����ؾ� ��
//	���������� �Է��ص� �ȵ� ��� [alt + f5]�� ���� ������Ʈ ��ü�� ������Ʈ �ؾ���

@Configuration
public class AppContext {
	@Bean	// @bean �ֳ����̼��� ������ �ش� �޼ҵ忡�� ������ ��ü�� �������� �����ϴ� �� ��ü�� ��ϵ�
	public Greeter greeter() {
		Greeter g = new Greeter();
		g.setFormat("%s, �ȳ��ϼ���.");
		return g;
	}
}