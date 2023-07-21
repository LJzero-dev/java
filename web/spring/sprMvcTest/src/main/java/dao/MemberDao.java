package dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import vo.MemberInfo;

public class MemberDao {
	private JdbcTemplate jdbcTemplate;	
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public int memberInsert(MemberInfo mi) {
		return jdbcTemplate.update("insert into t_member_info values (?, ?, ?, ?, ?, ?, ?, ?, 1000, 'a', now(), null)",mi.getMi_id(), mi.getMi_pw(), mi.getMi_name(), mi.getMi_gender(), mi.getMi_birth(), mi.getMi_phone(), mi.getMi_email(), mi.getMi_isad());		
	}
	public String chkDupId(String uid) {
		return jdbcTemplate.queryForObject("select count(*) from t_member_info where mi_id = '" + uid + "'", String.class);
	}
	public int memberUp(String mi_id, String mi_phone, String mi_email, String mi_isad) {
		return jdbcTemplate.update("update t_member_info set mi_phone = '" + mi_phone + "', mi_email = '" + mi_email + "', mi_isad = '" + mi_isad + "' where mi_id = '" + mi_id + "'");
	}
}
