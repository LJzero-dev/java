package assembler;

import spr.*;

public class Assembler {	// 필요한 크랠스의 인스턴스들을 생성하여 리턴하는 메소드들을 가진 클래스
	private MemberDao memberDao;
	private MemberRegisterSvc regSvc;
	private ChangePasswordSvc pwdSvc;
	
	public Assembler() {
		memberDao = new MemberDao();
		regSvc = new MemberRegisterSvc(memberDao);
		pwdSvc = new ChangePasswordSvc();
		pwdSvc.setMemberDao(memberDao);		
	}
	
	public MemberDao getMemberDao() {
		return memberDao;
	}
	
	public MemberRegisterSvc getMemberRegisterSvc() {
		return regSvc;
	}
	
	public ChangePasswordSvc getChangePasswordSvc() {
		return pwdSvc;
	}
}
