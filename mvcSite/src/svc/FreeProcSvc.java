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
		close(conn);
		return freeList;
	}

	public int freeInsert(FreeList freeList) {
		int flidx = 0;
		Connection conn = getConnection();
		FreeProcDao freeProcDao = FreeProcDao.getInstance();
		freeProcDao.setConnection(conn);
		flidx = freeProcDao.freeInsert(freeList);
		if (flidx > 0)	commit(conn);
		else			rollback(conn);
		close(conn);
		return flidx;
	}

	public int readUpdate(int flidx) {
		int result = 0;
		Connection conn = getConnection();
		FreeProcDao freeProcDao = FreeProcDao.getInstance();
		freeProcDao.setConnection(conn);
		result = freeProcDao.readUpdate(flidx);
		if (result == 1)	commit(conn);
		else				rollback(conn);
		close(conn);
		return result;
	}

	public FreeList getFreeInfo(int flidx) {
		Connection conn = getConnection();
		FreeProcDao freeProcDao = FreeProcDao.getInstance();
		freeProcDao.setConnection(conn);
		
		FreeList freeList = freeProcDao.getFreeInfo(flidx);
		close(conn);
		return freeList;
	}

	public String getIsMem(int flidx) {
		String ismem = "";
		Connection conn = getConnection();
		FreeProcDao freeProcDao = FreeProcDao.getInstance();
		freeProcDao.setConnection(conn);
		ismem = freeProcDao.getIsMem(flidx);
		close(conn);
		return ismem;
	}


	public FreeList getFreeListInfoUp(String where) {
		Connection conn = getConnection();
		FreeProcDao freeProcDao = FreeProcDao.getInstance();
		freeProcDao.setConnection(conn);
		
		FreeList freeList = freeProcDao.getFreeListInfoUp(where);
				
		close(conn);
		return freeList;
	}

	public int freeUpdate(FreeList freeList) {
		int result = 0;
		Connection conn = getConnection();
		FreeProcDao freeProcDao = FreeProcDao.getInstance();
		freeProcDao.setConnection(conn);
		
		result = freeProcDao.freeUpdate(freeList);
		if (result == 1)	commit(conn);
		else				rollback(conn);
		close(conn);
		return result;
	}

	public int freeDelete(String where) {
		int result = 0;
		Connection conn = getConnection();
		FreeProcDao freeProcDao = FreeProcDao.getInstance();
		freeProcDao.setConnection(conn);
		
		result = freeProcDao.freeDelete(where);
		if (result == 1)	commit(conn);
		else				rollback(conn);
		close(conn);
		return result;
	}
}
