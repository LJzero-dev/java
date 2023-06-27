package svc;

import static db.JdbcUtil.*;	// JdbcUtil Ŭ������ ��� ������� �����Ӱ� ���
import java.util.*;
import java.sql.*;
import dao.*;
import vo.*;

public class MemberProcSvc {	// ȸ�� ���� �� ���� ������ ���� Service Ŭ����
	public int memberInProc(MemberInfo memberInfo, MemberAddr memberAddr) {
		int result = 0;
		Connection conn = getConnection();
		MemberProcDao memberProcDao = MemberProcDao.getInstance();
		memberProcDao.setConnection(conn);
		result = memberProcDao.memberProcIn(memberInfo, memberAddr);
		
		if (result == 3)	commit(conn);	// ����� ������ insert, update, delete �� ��� �ݵ�� Ʈ������� �Ϸ��ؾ� ��
		else				rollback(conn);
		close(conn);
		
		return result;
	}
}
