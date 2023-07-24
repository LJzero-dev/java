package svc;

import dao.*;
import vo.*;

public class MemberSvc {
	private MemberDao memberDao;

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public int memberInsert(MemberInfo mi) {
		int result = memberDao.memberInsert(mi);
		return result;
	}

	public int chkDupId(String uid) {
		int result = memberDao.chkDupId(uid);
		return result;
	}

	public int memberUpdate(MemberInfo mi) {
		int result = memberDao.memberUpdate(mi);
		return result;
	}
}
