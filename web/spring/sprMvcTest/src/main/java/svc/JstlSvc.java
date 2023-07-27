package svc;

import java.util.List;

import dao.JstlDao;
import vo.MemberInfo;
import vo.PageInfo;

public class JstlSvc {
	private JstlDao jstlDao;
	
	public void setJstlDao(JstlDao jstlDao) {
		this.jstlDao = jstlDao;
	}
	
	public List<MemberInfo> getMemberList(PageInfo pi) {
		return jstlDao.getMemberList(pi);
	}
}
