package svc;

import static db.JdbcUtil.*;	// JdbcUtil Ŭ������ ��� ������� �����Ӱ� ���
import java.util.*;
import java.sql.*;
import dao.*;
import vo.*;

public class FreeReplyProcSvc {
	public ArrayList<FreeReply> getReplyList(int flidx) {
		ArrayList<FreeReply> replyList = new ArrayList<FreeReply>();
		Connection conn = getConnection();
		FreeReplyProcDao freeReplyProcDao = FreeReplyProcDao.getInstance();
		freeReplyProcDao.setConnection(conn);
		
		replyList = freeReplyProcDao.getReplyList(flidx);
		close(conn);	
		
		
		return replyList;
	}
}
