package spr;

public class MemberPrinter {
	public void print(MemberInfo mi) {
		System.out.printf("ȸ�� ���� : �ε���=%d, ���̵�=%s, �̸�=%s, �̸���=%s, �����=%tF\n", mi.getIdx(), mi.getUid(), mi.getName(), mi.getEmail(), mi.getRegDate());
	}
}
