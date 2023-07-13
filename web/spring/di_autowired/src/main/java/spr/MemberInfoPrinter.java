package spr;

import org.springframework.beans.factory.annotation.*;

public class MemberInfoPrinter {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberPrinter printer;
	
	public void printMemberInfo(String uid) {
		MemberInfo member = memberDao.selectByUid(uid);
		if (member == null) {
			System.out.println("데이터 없음\n"); return;
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