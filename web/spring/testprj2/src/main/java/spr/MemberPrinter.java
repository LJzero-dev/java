package spr;

public class MemberPrinter {
	public void print(MemberInfo mi) {
		System.out.printf("회원 정보 : 인덱스=%d, 아이디=%s, 이름=%s, 이메일=%s, 등록일=%tF\n", mi.getIdx(), mi.getUid(), mi.getName(), mi.getEmail(), mi.getRegDate());
	}
}
