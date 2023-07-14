package spr;

public class MemberSummaryPrinter extends MemberPrinter {
	@Override
	public void print(MemberInfo mi) {
		System.out.println("회원정보 - 아이디 : " + mi.getUid() + ", 이름 : " + mi.getName() + "\n");
	}
}
