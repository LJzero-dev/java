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

	public String chkDupId(String uid) {
		return memberDao.chkDupId(uid);
	}

	public int updateForm(String mi_id, String mi_pohne, String mi_email, String mi_isad) {
		return memberDao.memberUp(mi_id, mi_pohne, mi_email, mi_isad);
	}
}
