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
	
	// �� ���� ȸ�� ������ �����ϴ� �޼ҵ�
	
	// ��� ȸ���������� �����ϴ� �޼ҵ�
	
	// �� ���� ȸ�������� �޾ƿ� ȸ�� ���Խ�Ű�� �޼ҵ�
	
	// �� ���� ȸ������(��ȣ, ��ȭ, ����)�� �޾ƿ� ���� ���� ��Ű�� �޼ҵ�
}
