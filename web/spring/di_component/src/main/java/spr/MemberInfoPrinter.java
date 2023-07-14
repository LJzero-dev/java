package spr;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Component;

@Component("infoPrinter")	// Ŭ�������� �״�� ���� �̸����� ������� �ʰ� ���ϴ� �̸�(infoPrinter)�� ���� ����
public class MemberInfoPrinter {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberPrinter printer;
	
	public void printMemberInfo(String uid) {
		MemberInfo member = memberDao.selectByUid(uid);
		if (member == null) {
			System.out.println("������ ����\n"); return;
		}		
		printer.print(member);
		System.out.println();
	}
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}	
}