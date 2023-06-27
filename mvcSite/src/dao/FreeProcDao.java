package dao;

import static db.JdbcUtil.*;	// JdbcUtil Ŭ������ ��� ������� �����Ӱ� ���
import java.util.*;import com.sun.org.apache.regexp.internal.recompile;

import java.sql.*;
import vo.*;


public class FreeProcDao {	// �����Խ��� ���� ���� �۾�(���, ���, ����, ���� ��)���� ��� ó���ϴ� Ŭ����
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
	public int getFreeListCount(String where) {	// �����Խ��ǿ��� �˻��� ����� ���ڵ� ������ �����ϴ� �޼ҵ�
		Statement stmt = null;
		ResultSet rs = null;
		int rcnt = 0;		
		try {
			String sql = "select count(*) from t_free_list " + where;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) rcnt = rs.getInt(1);
			
		} catch (Exception e) {
			System.out.println("FreeProcDao Ŭ���� �� getFreeListCount() �޼ҵ� ����");
			e.printStackTrace();
		} finally {
			close(rs);	close(stmt);
		}		
		return rcnt;
	}
	
	public ArrayList<FreeList> getFreeList(String where, int cpage, int psize) {	// �����Խ��ǿ��� �˻��� ����� ���ڵ�(�Խñ�) ����� ArrayList<FreeList>�� �����ϴ� �޼ҵ�
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<FreeList> freeList = new ArrayList<FreeList>();
		FreeList fl = null;	// FreeList�� ������ �Խñ� �ϳ��� ������ ���� �ν��Ͻ�
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
			System.out.println("FreeProcDao Ŭ���� �� getFreeList() �޼ҵ� ����");
			e.printStackTrace();
		} finally {
			close(rs);	close(stmt);
		}
		
	return freeList;
	}
}
