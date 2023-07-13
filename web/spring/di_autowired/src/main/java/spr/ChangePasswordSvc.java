package spr;

import org.springframework.beans.factory.annotation.*;

public class ChangePasswordSvc {
	@Autowired
	private MemberDao memberDao;
	
	public void changePassword(String uid, String oldPwd, String newPwd) {
		MemberInfo mi = memberDao.selectByUid(uid);
		if (mi == null) throw new MemberNotFuondException();	//	����ڰ� �Է��� ���̵� �ش��ϴ� ȸ���� ������ ���� �߻�
		
		mi.changePwd(oldPwd, newPwd);
		
		memberDao.update(mi);		
	}
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
}
