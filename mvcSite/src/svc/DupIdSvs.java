package svc;

import static db.JdbcUtil.*;	// JdbcUtil 클래스의 모든 멤버들을 자유롭게 사용
import java.util.*;
import java.sql.*;
import dao.*;

public class DupIdSvs {
	public int chkDupId(String uid) {
		int result = 0;
		Connection conn = getConnection();
		DupIdDao dupIdDao = DupIdDao.getInstance();
		dupIdDao.setConnection(conn);
		result = dupIdDao.chkDupId(uid);
		close(conn);
		
		return result;
	}
}
