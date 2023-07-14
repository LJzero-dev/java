package spr;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class MemberDao {
	private JdbcTemplate jdbcTemplate;
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public int getCount() {
		return jdbcTemplate.queryForObject("select count(*) from t_member_info", Integer.class);
	}
	
	// 한 명의 회원 정보를 리턴하는 메소드
	
	// 모든 회원정보들을 리턴하는 메소드
	
	// 한 명의 회원정보를 받아와 회원 가입시키는 메소드
	
	// 한 명의 회원정보(암호, 전화, 메일)를 받아와 정보 변경 시키는 메소드
}
