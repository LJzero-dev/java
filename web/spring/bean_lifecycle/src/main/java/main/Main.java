package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import config.AppCtx;
import spr.Client;
import spr.Client2;

public class Main {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);		
		Client client = ctx.getBean(Client.class);	// Client 인스턴스 생성 후 send() 메소드 실행
		client.send();	
		
		Client2 client1 = ctx.getBean(Client2.class);	// Client 인스턴스 생성 후 send() 메소드 실행
		client1.send();
		
		Client client2 = ctx.getBean(Client.class);
		Client client3 = ctx.getBean(Client.class);
		
		System.out.println("client == client2 : " + (client == client2) + "\nclient == client3 : " + (client == client3) + "\nclient2 == client3 : " + (client2 == client3));
		/*
		client == client2 : true
		client == client3 : true
		client2 == client3 : true
		*/
		ctx.close();
	}
}