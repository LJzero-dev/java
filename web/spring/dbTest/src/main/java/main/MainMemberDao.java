package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import spr.MemberDao;

public class MainMemberDao {
	private static MemberDao memberDao;
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		memberDao = ctx.getBean(MemberDao.class);
		showAllCount();		showAllMembers();		ctx.close();
	}
	
	private static void showAllCount() {
		System.out.println("ÃÑ ÀÎ¿øÀº : " + memberDao.getCount());
	}

	private static void showAllMembers() {
		System.out.println();
	}
}