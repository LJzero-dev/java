package svc;

import java.util.List;

import dao.JsonDao;
import vo.MemberInfo;

public class JsonSvc {
	private JsonDao jsonDao;
	
	public void setJsonDao(JsonDao jsonDao) {
		this.jsonDao = jsonDao;
	}

	public List<MemberInfo> getMemberList(String where) {
		return jsonDao.getMemberList(where);
	}	
}