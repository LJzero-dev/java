package dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class JsonDao {
	private JdbcTemplate jdbc;	
	public JsonDao(DataSource dataSource) {
		this.jdbc = new JdbcTemplate(dataSource);
	}

}
