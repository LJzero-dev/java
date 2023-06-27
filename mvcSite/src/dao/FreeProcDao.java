package dao;

import static db.JdbcUtil.*;	// JdbcUtil 클래스의 모든 멤버들을 자유롭게 사용
import java.util.*;import com.sun.org.apache.regexp.internal.recompile;

import java.sql.*;
import vo.*;


public class FreeProcDao {	// 자유게시판 관련 쿼리 작업(목록, 등록, 수정, 삭제 등)들을 모두 처리하는 클래스
	private static FreeProcDao freeProcDao;
	private Connection conn;
	private FreeProcDao() {}
	
	public static FreeProcDao getInstance() {
		if (freeProcDao == null) freeProcDao = new FreeProcDao();
		return freeProcDao;
	}
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	public int getFreeListCount(String where) {	// 자유게시판에서 검색된 결과의 레코드 개수를 리턴하는 메소드
		Statement stmt = null;
		ResultSet rs = null;
		int rcnt = 0;		
		try {
			String sql = "select count(*) from t_free_list " + where;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) rcnt = rs.getInt(1);
			
		} catch (Exception e) {
			System.out.println("FreeProcDao 클래스 의 getFreeListCount() 메소드 오류");
			e.printStackTrace();
		} finally {
			close(rs);	close(stmt);
		}		
		return rcnt;
	}
	
	public ArrayList<FreeList> getFreeList(String where, int cpage, int psize) {	// 자유게시판에서 검색된 결과의 레코드(게시글) 목록을 ArrayList<FreeList>로 리턴하는 메소드
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<FreeList> freeList = new ArrayList<FreeList>();
		FreeList fl = null;	// FreeList에 저장할 게시글 하나의 정보를 담을 인스턴스
		try {
			String sql = "select fl_idx, fl_ismem, fl_writer, fl_title, fl_reply, fl_read, fl_ip, if(curdate() = date(fl_date), right(fl_date, 8), replace(mid(fl_date, 3, 8),'-', '.')) wdate from t_free_list "
						+ where + " order by fl_idx desc limit " + ((cpage - 1) * psize) + ", " + psize;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				fl = new FreeList();
				fl.setFl_idx(rs.getInt("fl_idx"));		fl.setFl_ismem(rs.getString("fl_ismem"));		fl.setFl_writer(rs.getString("fl_writer"));		fl.setFl_title(rs.getString("fl_title"));
				fl.setFl_reply(rs.getInt("fl_reply"));	fl.setFl_ip(rs.getString("fl_ip"));				fl.setFl_date(rs.getString("fl_date"));
				freeList.add(fl);
			}
		} catch (Exception e) {
			System.out.println("FreeProcDao 클래스 의 getFreeList() 메소드 오류");
			e.printStackTrace();
		} finally {
			close(rs);	close(stmt);
		}
		
	return freeList;
	}
}
