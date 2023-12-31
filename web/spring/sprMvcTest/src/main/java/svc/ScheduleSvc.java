package svc;

import java.util.List;

import dao.ScheduleDao;
import vo.ScheduleInfo;

public class ScheduleSvc {
	private ScheduleDao scheduleDao;
	
	public void setMemberDao(ScheduleDao scheduleDao) {
		this.scheduleDao = scheduleDao;
	}

	public int scheduleInsert(ScheduleInfo si) {
		return scheduleDao.scheduleInsert(si);
	}

	public List<ScheduleInfo> getScheduleList(String uid, int y, int m) {
		return scheduleDao.getScheduleList(uid, y, m);
	}
}
