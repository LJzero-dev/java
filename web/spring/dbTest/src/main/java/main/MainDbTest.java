package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import config.DbConfig;
import spr.DbTestDao;
import spr.MemberDao;

public class MainDbTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DbConfig.class);
		System.out.println("ÃÑ È¸¿ø ¼ö : " + ctx.getBean(DbTestDao.class).getCount() + "¸í");
		
		
	}
}