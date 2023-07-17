package spr;

import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import vo.MemberInfo;

public class MemberDao {
	private JdbcTemplate jdbcTemplate;
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public int getCount() {
		return jdbcTemplate.queryForObject("select count(*) from t_member_info", Integer.class);
	}
	public List<MemberInfo> getMemberList() {
		List<MemberInfo> result = jdbcTemplate.query("select * from t_member_Info", (ResultSet rs, int rowNum) -> {
			MemberInfo mi = new MemberInfo();
			mi.setMi_id(rs.getString("mi_id"));
			mi.setMi_pw(rs.getString("mi_pw"));
            mi.setMi_name(rs.getString("mi_name"));
            mi.setMi_gender(rs.getString("mi_gender"));
            mi.setMi_birth(rs.getString("mi_birth"));
            mi.setMi_phone(rs.getString("mi_phone"));
            mi.setMi_email(rs.getString("mi_email"));
            mi.setMi_isad(rs.getString("mi_isad"));
            mi.setMi_point(rs.getInt("mi_point"));
            mi.setMi_status(rs.getString("mi_status"));
            mi.setMi_date(rs.getString("mi_date"));
            mi.setMi_lastlogin(rs.getString("mi_lastlogin"));
			return mi;
		});
		return result;
	}
}
