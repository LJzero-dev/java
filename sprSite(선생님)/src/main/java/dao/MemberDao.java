package dao;

import java.util.*;
import java.sql.*;
import javax.sql.*;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.*;
import vo.*;

public class MemberDao {
	private JdbcTemplate jdbc;

	public MemberDao(DataSource dataSource) {
		this.jdbc = new JdbcTemplate(dataSource);
	}

	public int memberInsert(MemberInfo mi) {
		String sql = "insert into t_member_info values " + 
		"(?, ?, ?, ?, ?, ?, ?, ?, 1000, 'a', now(), null)";
		int result = jdbc.update(sql, mi.getMi_id(), mi.getMi_pw(), 
			mi.getMi_name(), mi.getMi_gender(), mi.getMi_birth(), 
			mi.getMi_phone(), mi.getMi_email(), mi.getMi_isad());

		return result;
	}

	public int chkDupId(String uid) {
		String sql = "select count(*) from t_member_info " + 
		" where mi_id = '" + uid + "' ";
		int result = jdbc.queryForObject(sql, Integer.class);
		return result;
	}

	public int memberUpdate(MemberInfo mi) {
		String sql = "update t_member_info set " + 
			" mi_phone = '"		+ mi.getMi_phone()	+ "', " + 
			" mi_email = '"		+ mi.getMi_email()	+ "', " + 
			" mi_isad = '"		+ mi.getMi_isad()	+ "' " + 
			" where mi_id = '"	+ mi.getMi_id()		+ "' ";
		int result = jdbc.update(sql);

		return result;
	}
}
