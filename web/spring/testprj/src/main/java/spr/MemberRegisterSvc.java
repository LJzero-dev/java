package spr;

import java.time.*;

public class MemberRegisterSvc {
	private MemberDao memberDao;
	
	public MemberRegisterSvc(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public int regist(RegisterRequest req) {
		MemberInfo mi = memberDao.selectByUid(req.getUid());
		if (mi != null) throw new DuplicateMemberException("dup Id : " + req.getUid());	// 가입하려는 회원의 아이디와 동일한 아이디를 가진 회원이 있으면, 예외 발생
		MemberInfo newMember = new MemberInfo(req.getUid(), req.getPwd(), req.getName(), req.getEmail(), LocalDateTime.now());
		memberDao.insert(newMember);
		return newMember.getIdx();
	}
}