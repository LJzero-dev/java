package svc;

import static db.JdbcUtil.*;	// JdbcUtil 클래스의 모든 멤버들을 자유롭게 사용
import java.util.*;
import java.sql.*;
import dao.*;
import vo.*;

public class MemberProcSvc {	// 회원 가입 및 정보 수정을 위한 Service 클래스
	public int memberInProc(MemberInfo memberInfo, MemberAddr memberAddr) {
		int result = 0;
		Connection conn = getConnection();
		MemberProcDao memberProcDao = MemberProcDao.getInstance();
		memberProcDao.setConnection(conn);
		result = memberProcDao.memberProcIn(memberInfo, memberAddr);
		
		if (result == 3)	commit(conn);	// 사용한 쿼리가 insert, update, delete 일 경우 반드시 트랜잭션을 완료해야 함
		else				rollback(conn);
		close(conn);		
		return result;
	}
}
