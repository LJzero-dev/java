package dao;

import static db.JdbcUtil.*;	// JdbcUtil 클래스의 모든 멤버들을 자유롭게 사용
import java.util.*;
import com.sun.org.apache.regexp.internal.recompile;
import java.sql.*;
import vo.*;

public class FreeReplyProcDao {
	private static FreeReplyProcDao freeReplyProcDao;
	private Connection conn;
	private FreeReplyProcDao() {}
	
	public static FreeReplyProcDao getInstance() {
		if (freeReplyProcDao == null) freeReplyProcDao = new FreeReplyProcDao();
		return freeReplyProcDao;
	}
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	public ArrayList<FreeReply> getReplyList(int flidx) {	// 지정한 게시글에 속하는 댓글들의 목록을 ArrayList<FreeReply>형으로 리턴하는 메소드
		ArrayList<FreeReply> replyList = new ArrayList<FreeReply>();	// 댓글들의 목록을 저장할 ArrayList 객체
		try {									// replyList에 저장할 하나의 댓글 정보를 담은 인스턴스
			ResultSet rs = conn.createStatement().executeQuery("select * from t_free_reply where fr_isview = 'y' and fl_idx = " + flidx);
			while (rs.next()) {
				FreeReply freeReply = new FreeReply();
				freeReply.setFr_bad(rs.getInt("Fr_bad"));		freeReply.setFr_good(rs.getInt("Fr_good"));	freeReply.setFr_content(rs.getString("Fr_content"));
				freeReply.setFr_date(rs.getString("Fr_date"));	freeReply.setFr_idx(rs.getInt("Fr_idx"));	freeReply.setFl_idx(flidx);	freeReply.setMi_id(rs.getString("mi_id"));
				replyList.add(freeReply);
			}	rs.close();
		} catch (Exception e) {
			System.out.println("FreeReplyProcDao 클래스의 FreeReply() 메소드 오류");
			e.printStackTrace();
		}		
		return replyList;
	}
	public int replyInsert(FreeReply freeReply) {	// 사용자가 입력한 댓글을 테이블에 저장시키는 메소드
		try {
			conn.createStatement().executeUpdate("update t_free_list set fl_reply = fl_reply + 1 where fl_idx = " + freeReply.getFl_idx());	// 댓글 수 증가 아래는 댓글 등록
			return conn.createStatement().executeUpdate("insert into t_free_reply (fl_idx, mi_id, fr_content, fr_ip) values (" + freeReply.getFl_idx() + ", '" + freeReply.getMi_id() + "', '" + freeReply.getFr_content() + "', '" + freeReply.getFr_ip() + "')");
		}catch (Exception e) {
			System.out.println("FreeReplyProcDao 클래스의 replyInsert() 메소드 오류");
			e.printStackTrace();
		}
		return 0;
	}	
}