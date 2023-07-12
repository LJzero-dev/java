package assembler;

import spr.*;

public class Assembler {	// �ʿ��� ũ������ �ν��Ͻ����� �����Ͽ� �����ϴ� �޼ҵ���� ���� Ŭ����
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
