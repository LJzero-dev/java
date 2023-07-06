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
		ResultSet rs = null;
		try {									// replyList에 저장할 하나의 댓글 정보를 담은 인스턴스
			rs = conn.createStatement().executeQuery("select * from t_free_reply where fr_isview = 'y' and fl_idx = " + flidx);
			while (rs.next()) {
				FreeReply freeReply = new FreeReply();
				freeReply.setFr_bad(rs.getInt("Fr_bad"));		freeReply.setFr_good(rs.getInt("Fr_good"));	freeReply.setFr_content(rs.getString("Fr_content"));
				freeReply.setFr_date(rs.getString("Fr_date"));	freeReply.setFr_idx(rs.getInt("Fr_idx"));	freeReply.setFl_idx(flidx);	freeReply.setMi_id(rs.getString("mi_id"));
				replyList.add(freeReply);
			}
		} catch (Exception e) {
			System.out.println("FreeReplyProcDao 클래스의 FreeReply() 메소드 오류");
			e.printStackTrace();
		} finally {
			close(rs);
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

	public int replyGnb(FreeReplyGnb freeReplyGnb) {	// 지정한 댓글에 좋아요/싫어요를 처리하는 메소드	// 이미 참여했던 댓글일 경우 -1을, 정상 처리 됐으면 2를, 처리가 안됐으면 0이나 1을 리턴
		ResultSet rs = null;
		try {
			rs = conn.createStatement().executeQuery("select frg_gnb from t_free_reply_gnb where fr_idx = " + freeReplyGnb.getFr_idx() + " and mi_id = '" + freeReplyGnb.getMi_id() + "'");		
			if (rs.next()) return -1;
			if (conn.createStatement().executeUpdate("update t_free_reply set fr_" + freeReplyGnb.getFrg_gnb() + " = fr_" + freeReplyGnb.getFrg_gnb() + " + 1 where fr_idx = " + freeReplyGnb.getFr_idx()) == 1) 
				if (conn.createStatement().executeUpdate("insert into t_free_reply_gnb (mi_id, fr_idx, frg_gnb) values ('" +freeReplyGnb.getMi_id() + "', " + freeReplyGnb.getFr_idx() + ", '" + freeReplyGnb.getFrg_gnb().charAt(0) + "')") == 1)
					return 2;
		}catch (Exception e) {
			System.out.println("FreeReplyProcDao 클래스의 FreeReplyGnb() 메소드 오류");
			e.printStackTrace();
		} finally {
			close(rs);
		}
		return 0;
	}

	public int replyDelete(int fridx) {
		try {
			conn.createStatement().executeUpdate("update t_free_list set fl_reply = fl_reply - 1 where fl_idx = (select fl_idx from t_free_reply where fr_idx = " + fridx + ")");	// 댓글 개수 감소
			if (conn.createStatement().executeUpdate("update t_free_reply set fr_isview = 'n' where fr_idx = " + fridx) == 1)	return 2;											// 댓글 삭제
		}catch (Exception e) {
			System.out.println("FreeReplyProcDao 클래스의 replyDelete() 메소드 오류");
			e.printStackTrace();
		}
		return 0;
	}
}