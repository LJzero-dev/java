package svc;

import java.util.List;

import dao.FreeDao;
import vo.FreeList;

public class FreeSvc {
	private FreeDao freeDao;
	
	public void setFreeDao(FreeDao freeDao) {
		this.freeDao = freeDao;
	}

	public int getFreeListCount(String where) {
		return freeDao.getFreeListCount(where);
	}

	public List<FreeList> getFreeList(String where, int cpage, int psize) {		
		return freeDao.getFreeList(where, cpage, psize);
	}

	public FreeList getFreeInfo(int flidx) {
		return freeDao.getFreeInfo(flidx);
	}
}