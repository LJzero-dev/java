package spr;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("listPrinter")
public class MemberListPrinter {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberPrinter printer;
	
	public MemberListPrinter() {}	// �Ű������� �ʿ� ���� �⺻ ������
	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
		// this.memberDao = memberDao;	this.printer = printer;
		
	}
	
	public void printAll() {
		Collection<MemberInfo> members = memberDao.selectAll();
		members.forEach(m -> printer.print(m));
		//	Lambda������ members�÷����� ���� �ϳ��� m�� ���� �� printer.print() �޼ҵ��� �Ű������� �־� �����Ŵ
	}
}
