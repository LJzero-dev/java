package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import vo.MemberInfo;

public class LoginDaoSpr {
	private JdbcTemplate jdbcTemplate;
		
	public LoginDaoSpr(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public MemberInfo getLoginInfo(String uid, String pwd) {
		/*List<MemberInfo> result = jdbcTemplate.query("select * from t_member_info where mi_id = ? and mi_pw = ?", new RowMapper<MemberInfo>() {
					@Override
					public MemberInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
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
					}
			},uid,pwd
		);
		return result.isEmpty() ? null : result.get(0);
		*/
		List<MemberInfo> result = jdbcTemplate.query(
				"select * from t_member_info where mi_id = ? and mi_pw = ?", (ResultSet rs, int rowNum) -> {
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
				},uid,pwd
			);
		return result.isEmpty() ? null : result.get(0);
	}
}
