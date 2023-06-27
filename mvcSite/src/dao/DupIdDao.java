package dao;

import static db.JdbcUtil.*;	// JdbcUtil 클래스의 모든 멤버들을 자유롭게 사용
import java.util.*;
import java.sql.*;

public class DupIdDao {	// 아이디 중복체크에 관련된 쿼리 작업을 처리하는 클래스
	private static DupIdDao dupIdDao;
	private Connection conn;
	private DupIdDao() {}
	
	public static DupIdDao getInstance() {
		if (dupIdDao == null) dupIdDao = new DupIdDao();
		return dupIdDao;
	}
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	public int chkDupId(String uid) {	// 회원가입시 사용자가 사용할 아이디의 중복 여부를 리턴할 메소드
		ResultSet rs = null;
		int result = 0;
		try {			
			rs = conn.createStatement().executeQuery("select count(*) from t_member_info where mi_id = '" + uid + "'");
			rs.next();	// count() 함수를 사용했기에 데이터가 없을 경우는 없음
			result = rs.getInt(1);			
			
		}catch (Exception e) {
			System.out.println("DupIdDao의 chkDupId() 메소드 오류");
			e.printStackTrace();
		} finally {
			close(rs);
		}		
		return result;
	}
}
