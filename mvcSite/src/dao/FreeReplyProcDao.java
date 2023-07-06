package dao;

import static db.JdbcUtil.*;	// JdbcUtil Ŭ������ ��� ������� �����Ӱ� ���
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
	public ArrayList<FreeReply> getReplyList(int flidx) {	// ������ �Խñۿ� ���ϴ� ��۵��� ����� ArrayList<FreeReply>������ �����ϴ� �޼ҵ�
		ArrayList<FreeReply> replyList = new ArrayList<FreeReply>();	// ��۵��� ����� ������ ArrayList ��ü
		ResultSet rs = null;
		try {									// replyList�� ������ �ϳ��� ��� ������ ���� �ν��Ͻ�
			rs = conn.createStatement().executeQuery("select * from t_free_reply where fr_isview = 'y' and fl_idx = " + flidx);
			while (rs.next()) {
				FreeReply freeReply = new FreeReply();
				freeReply.setFr_bad(rs.getInt("Fr_bad"));		freeReply.setFr_good(rs.getInt("Fr_good"));	freeReply.setFr_content(rs.getString("Fr_content"));
				freeReply.setFr_date(rs.getString("Fr_date"));	freeReply.setFr_idx(rs.getInt("Fr_idx"));	freeReply.setFl_idx(flidx);	freeReply.setMi_id(rs.getString("mi_id"));
				replyList.add(freeReply);
			}
		} catch (Exception e) {
			System.out.println("FreeReplyProcDao Ŭ������ FreeReply() �޼ҵ� ����");
			e.printStackTrace();
		} finally {
			close(rs);
		}
		return replyList;
	}
	public int replyInsert(FreeReply freeReply) {	// ����ڰ� �Է��� ����� ���̺� �����Ű�� �޼ҵ�
		try {
			conn.createStatement().executeUpdate("update t_free_list set fl_reply = fl_reply + 1 where fl_idx = " + freeReply.getFl_idx());	// ��� �� ���� �Ʒ��� ��� ���
			return conn.createStatement().executeUpdate("insert into t_free_reply (fl_idx, mi_id, fr_content, fr_ip) values (" + freeReply.getFl_idx() + ", '" + freeReply.getMi_id() + "', '" + freeReply.getFr_content() + "', '" + freeReply.getFr_ip() + "')");
		}catch (Exception e) {
			System.out.println("FreeReplyProcDao Ŭ������ replyInsert() �޼ҵ� ����");
			e.printStackTrace();
		}
		return 0;
	}

	public int replyGnb(FreeReplyGnb freeReplyGnb) {	// ������ ��ۿ� ���ƿ�/�Ⱦ�並 ó���ϴ� �޼ҵ�	// �̹� �����ߴ� ����� ��� -1��, ���� ó�� ������ 2��, ó���� �ȵ����� 0�̳� 1�� ����
		ResultSet rs = null;
		try {
			rs = conn.createStatement().executeQuery("select frg_gnb from t_free_reply_gnb where fr_idx = " + freeReplyGnb.getFr_idx() + " and mi_id = '" + freeReplyGnb.getMi_id() + "'");		
			if (rs.next()) return -1;
			if (conn.createStatement().executeUpdate("update t_free_reply set fr_" + freeReplyGnb.getFrg_gnb() + " = fr_" + freeReplyGnb.getFrg_gnb() + " + 1 where fr_idx = " + freeReplyGnb.getFr_idx()) == 1) 
				if (conn.createStatement().executeUpdate("insert into t_free_reply_gnb (mi_id, fr_idx, frg_gnb) values ('" +freeReplyGnb.getMi_id() + "', " + freeReplyGnb.getFr_idx() + ", '" + freeReplyGnb.getFrg_gnb().charAt(0) + "')") == 1)
					return 2;
		}catch (Exception e) {
			System.out.println("FreeReplyProcDao Ŭ������ FreeReplyGnb() �޼ҵ� ����");
			e.printStackTrace();
		} finally {
			close(rs);
		}
		return 0;
	}

	public int replyDelete(int fridx) {
		try {
			conn.createStatement().executeUpdate("update t_free_list set fl_reply = fl_reply - 1 where fl_idx = (select fl_idx from t_free_reply where fr_idx = " + fridx + ")");	// ��� ���� ����
			if (conn.createStatement().executeUpdate("update t_free_reply set fr_isview = 'n' where fr_idx = " + fridx) == 1)	return 2;											// ��� ����
		}catch (Exception e) {
			System.out.println("FreeReplyProcDao Ŭ������ replyDelete() �޼ҵ� ����");
			e.printStackTrace();
		}
		return 0;
	}
}