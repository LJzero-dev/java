package svc;

import static db.JdbcUtil.*;	// JdbcUtil Ŭ������ ��� ������� �����Ӱ� ���
import java.util.*;
import java.sql.*;
import dao.*;
import vo.*;

public class FreeProcSvc {
	public int getFreeListCount(String where) {
		int rcnt = 0;
		Connection conn = getConnection();
		FreeProcDao freeProcDao = FreeProcDao.getInstance();
		freeProcDao.setConnection(conn);
		
		rcnt = freeProcDao.getFreeListCount(where);
		close(conn);
		
		return rcnt;
	}
	
	public ArrayList<FreeList> getFreeList(String where, int cpage, int psize) {
		ArrayList<FreeList> freeList = new ArrayList<FreeList>();
		Connection conn = getConnection();
		FreeProcDao freeProcDao = FreeProcDao.getInstance();
		freeProcDao.setConnection(conn);
		
		freeList = freeProcDao.getFreeList(where, cpage, psize);
		
		return freeList;
	}
}
