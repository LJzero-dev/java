package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import spr.MemberDao;
import vo.MemberInfo;

public class MainMemberDao {
	private static MemberDao memberDao;
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		memberDao = ctx.getBean(MemberDao.class);
		showAllCount();		showAllMembers();		ctx.close();
	}
	
	private static void showAllCount() {
		System.out.println("총 인원은 : " + memberDao.getCount());
	}

	private static void showAllMembers() {
		// 루프를 돌면서 출력(아이디, 이름, 성별, 보유포인트)
		for (MemberInfo mi : memberDao.getMemberList()) {
			System.out.println("아이디 : " + mi.getMi_id() + ", 이름 : " + mi.getMi_name() + ", 성별 : " + mi.getMi_gender() + ", 보유 포인트 : " + mi.getMi_point());
		}		
		System.out.println();
	}
}