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
		try {									// replyList�� ������ �ϳ��� ��� ������ ���� �ν��Ͻ�
			ResultSet rs = conn.createStatement().executeQuery("select * from t_free_reply where fr_isview = 'y' and fl_idx = " + flidx);	rs.next();
			while (rs.next()) {
				FreeReply freeReply = new FreeReply();	
				freeReply.setFr_bad(rs.getInt("Fr_bad"));		freeReply.setFr_good(rs.getInt("Fr_good"));	freeReply.setFr_content(rs.getString("Fr_content"));
				freeReply.setFr_date(rs.getString("Fr_date"));	freeReply.setFr_idx(rs.getInt("Fr_idx"));	freeReply.setFl_idx(flidx);	freeReply.setMi_id(rs.getString("mi_id"));
				replyList.add(freeReply);
			}	rs.close();			
		} catch (Exception e) {
			System.out.println("FreeReplyProcDao Ŭ������ FreeReply() �޼ҵ� ����");
			e.printStackTrace();
		}		
		return replyList;
	}	
}