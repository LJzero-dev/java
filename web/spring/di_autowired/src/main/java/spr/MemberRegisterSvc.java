package spr;

import java.time.*;

import org.springframework.beans.factory.annotation.*;

public class MemberRegisterSvc {
	@Autowired
	private MemberDao memberDao;
	
	public MemberRegisterSvc(MemberDao memberDao) {
		// this.memberDao = memberDao;
		// @Autowired�� ����ϹǷ� ���� ���������� ���� �ʾƵ� ��
	}
	
	public int regist(RegisterRequest req) {
		MemberInfo mi = memberDao.selectByUid(req.getUid());
		if (mi != null) throw new DuplicateMemberException("dup Id : " + req.getUid());	// �����Ϸ��� ȸ���� ���̵�� ������ ���̵� ���� ȸ���� ������, ���� �߻�
		MemberInfo newMember = new MemberInfo(req.getUid(), req.getPwd(), req.getName(), req.getEmail(), LocalDateTime.now());
		memberDao.insert(newMember);
		return newMember.getIdx();
	}
}