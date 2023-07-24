package dao;

import java.sql.ResultSet;
import java.util.List;

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
	public List<ScheduleInfo> getScheduleList(String uid, int y, int m) {
		// 지정한 연월에 해당하는 일정들의 목록을 List<ScheduleInfo>로 리턴하는 메소드
				String sql = "select * from t_schedule_info where " + 
				" mi_id = '" + uid + "' and si_date like '" + y + "-" + 
				(m < 10 ? "0" + m : m) + "%' order by si_date, si_time";
				List<ScheduleInfo> scheduleList = jdbcTemplate.query(sql, 
				(ResultSet rs, int rowNum) -> {
					ScheduleInfo si = new ScheduleInfo(
					rs.getInt("si_idx"), rs.getString("mi_id"), 
					rs.getString("si_date"), rs.getString("si_time"), 
					rs.getString("si_content"), rs.getString("si_regdate"));
					return si;
				});

				return scheduleList;
			}
}