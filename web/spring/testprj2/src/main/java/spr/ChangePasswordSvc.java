package spr;


public class ChangePasswordSvc {
	private MemberDao memberDao;
	
	public void changePassword(String uid, String oldPwd, String newPwd) {
		MemberInfo mi = memberDao.selectByUid(uid);
		if (mi == null) throw new MemberNotFuondException();
		
		mi.changePwd(oldPwd, newPwd);
		
		memberDao.update(mi);		
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}	
}
