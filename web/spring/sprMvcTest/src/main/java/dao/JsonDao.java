package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import vo.MemberInfo;

public class JsonDao {
	private JdbcTemplate jdbc;	
	public JsonDao(DataSource dataSource) {
		this.jdbc = new JdbcTemplate(dataSource);
	}
	public List<MemberInfo> getMemberList(String where) {
		List<MemberInfo> results = jdbc.query("select mi_id, concat(mi_name, '(', mi_gender, ')') miname, mi_birth, mi_phone, mi_point from t_member_info where mi_status = 'a' " + where,(ResultSet rs, int rowNum) -> {
				MemberInfo mi = new MemberInfo();
				mi.setMi_id(rs.getString("mi_id"));			mi.setMi_name(rs.getString("miname"));	mi.setMi_birth(rs.getString("mi_birth"));	mi.setMi_phone(rs.getString("mi_phone"));	mi.setMi_point(rs.getInt("mi_point"));  	           
	            return mi;
		});		
		return results;
	}	
}