package spr;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Component;

@Component("infoPrinter")	// 클래스명을 그대로 빈의 이름으로 사용하지 않고 원하는 이름(infoPrinter)을 직접 지정
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