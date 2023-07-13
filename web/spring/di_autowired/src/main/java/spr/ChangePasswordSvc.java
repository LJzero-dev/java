package spr;

import org.springframework.beans.factory.annotation.*;

public class ChangePasswordSvc {
	@Autowired
	private MemberDao memberDao;
	
	public void changePassword(String uid, String oldPwd, String newPwd) {
		MemberInfo mi = memberDao.selectByUid(uid);
		if (mi == null) throw new MemberNotFuondException();	//	사용자가 입력한 아이디에 해당하는 회원이 없으면 예외 발생
		
		mi.changePwd(oldPwd, newPwd);
		
		memberDao.update(mi);		
	}
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
}
