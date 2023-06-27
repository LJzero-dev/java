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
		close(conn);
		
		return result;
	}
}
