package spr;

public class MemberSummaryPrinter extends MemberPrinter {
	@Override
	public void print(MemberInfo mi) {
		System.out.println("ȸ������ - ���̵� : " + mi.getUid() + ", �̸� : " + mi.getName() + "\n");
	}
}
