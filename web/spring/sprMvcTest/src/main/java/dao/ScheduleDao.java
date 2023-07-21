package dao;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import vo.ScheduleInfo;

public class ScheduleDao {
	private JdbcTemplate jdbcTemplate;	
	public ScheduleDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public int scheduleInsert(ScheduleInfo si) {
		return jdbcTemplate.update("insert into t_schedule_info values (?, ?, ?, ?, ?, now())",
				jdbcTemplate.queryForObject("select count(*)+1 from t_schedule_info", Integer.class),si.getMi_id(),si.getSi_date(),si.getSi_time(),si.getSi_content());
	}
}