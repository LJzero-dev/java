package svc;

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
}
