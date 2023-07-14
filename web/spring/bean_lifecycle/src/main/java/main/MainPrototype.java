package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import config.AppCtxPrototype;
import spr.*;

public class MainPrototype {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtxPrototype.class);

		Client c1 = ctx.getBean(Client.class);
		Client c2 = ctx.getBean(Client.class);
		System.out.println("c1 == c2 : " + (c1 == c2));	//	c1 == c2 : false
														//	Client �� ��ü�� @Scopoe�� prototype�̹Ƿ� �� �� ��ü�� ���� �ٸ�
		Client2 c3 = ctx.getBean(Client2.class);
		Client2 c4 = ctx.getBean(Client2.class);
		System.out.println("c3 == c4 : " + (c3 == c4));	//	c3 == c4 : true
		ctx.close();									//	Client2 �� ��ü�� @Scopoe�� singleton�̹Ƿ� �� �� ��ü�� ���� ����
	}
}