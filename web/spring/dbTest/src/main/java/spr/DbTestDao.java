package spr;

import java.sql.Connection;
import java.sql.ResultSet;
import javax.sql.DataSource;


public class DbTestDao {
	private DataSource dataSource;
	public DbTestDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public int getCount() {	// ��ü ȸ�� ���� ���Ͽ� �����ϴ� �޼ҵ�
		Connection conn = null;
		ResultSet rs = null; 
		try {
			conn = dataSource.getConnection();
			rs = conn.createStatement().executeQuery("select count(*) from t_member_info");	rs.next();
			return rs.getInt(1);
		} catch (Exception e) {
			System.out.println("DbTestDao�� getCount() ����");
			e.printStackTrace();
		} finally {
			try {				
				rs.close();	conn.close();				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
}