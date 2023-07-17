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
		System.out.println("�� �ο��� : " + memberDao.getCount());
	}

	private static void showAllMembers() {
		// ������ ���鼭 ���(���̵�, �̸�, ����, ��������Ʈ)
		for (MemberInfo mi : memberDao.getMemberList()) {
			System.out.println("���̵� : " + mi.getMi_id() + ", �̸� : " + mi.getMi_name() + ", ���� : " + mi.getMi_gender() + ", ���� ����Ʈ : " + mi.getMi_point());
		}		
		System.out.println();
	}
}