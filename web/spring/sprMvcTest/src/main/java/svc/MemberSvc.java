package svc;

import dao.MemberDao;
import vo.MemberInfo;

public class MemberSvc {
	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public int memberInsert(MemberInfo mi) {
		return memberDao.memberInsert(mi);
	}
}
