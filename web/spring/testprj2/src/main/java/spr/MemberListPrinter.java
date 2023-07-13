package spr;

import java.util.*;

public class MemberListPrinter {
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
		this.memberDao = memberDao;	this.printer = printer;
	}
	
	public void printAll() {
		Collection<MemberInfo> members = memberDao.selectAll();
		members.forEach(m -> printer.print(m));
		//	Lambda식으로 members컬렉션의 값을 하나씩 m에 넣은 후 printer.print() 메소드의 매개변수로 넣어 실행시킴
	}
}
