package dao;

import static db.JdbcUtil.*;	// JdbcUtil Ŭ������ ��� ������� �����Ӱ� ���
import java.util.*;
import com.sun.org.apache.regexp.internal.recompile;
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
				fl.setFl_reply(rs.getInt("fl_reply"));	fl.setFl_ip(rs.getString("fl_ip"));				fl.setFl_date(rs.getString("wdate"));			fl.setFl_read(rs.getInt("fl_read"));
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

	public int freeInsert(FreeList freeList) {	// �����Խ��� �Խñ� ��� ó�� �޼ҵ�(�۹�ȣ�� ����)
		int flidx = 1, result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			rs = conn.createStatement().executeQuery("select max(fl_idx) + 1 from t_free_list");	rs.next();	flidx = rs.getInt(1);	// ���Ӱ� ����� �Խñ��� �۹�ȣ�� �����Ͽ� flidx�� ����
			pstmt = conn.prepareStatement("insert into t_free_list (fl_idx, fl_ismem, fl_writer, fl_pw, fl_title, fl_content, fl_ip) values (?, ?, ?, ?, ?, ?, ?)");
			pstmt.setInt(1, flidx);							pstmt.setString(2,freeList.getFl_ismem());			pstmt.setString(3,freeList.getFl_writer());
			pstmt.setString(4,freeList.getFl_pw());			pstmt.setString(5,freeList.getFl_title());			pstmt.setString(6,freeList.getFl_content());
			pstmt.setString(7,freeList.getFl_ip());
			result = pstmt.executeUpdate();
			return result == 1 ? flidx : 0;	// ���� �߻� �� �۹�ȣ�� �ƴ� 0�� �����Ͽ� svc���� �ѹ��� ��Ŵ
		} catch (Exception e) {
			System.out.println("FreeProcDao Ŭ������ freeInsert() �޼ҵ� ����");
			e.printStackTrace();
		} finally {
			close(rs);	close(pstmt);
		}
		return 0;
	}

	public int readUpdate(int flidx) {
		try {
			return conn.createStatement().executeUpdate("update t_free_list set fl_read = fl_read + 1 where fl_idx = " + flidx);
		} catch (Exception e) {
			System.out.println("FreeProcDao Ŭ������ readUpdate() �޼ҵ� ����");
			e.printStackTrace();
		}
		return 0;
	}

	public FreeList getFreeInfo(int flidx) {	// ������ �Խñ��� �������� FreeList�� �ν��Ͻ��� �����ϴ� �޼ҵ�
		try {			
			ResultSet rs = conn.createStatement().executeQuery("select * from t_free_list where fl_isview = 'y' and fl_idx = " + flidx);
			if (rs.next()) {
				FreeList freeList = new FreeList();
				freeList.setFl_idx(flidx);	freeList.setFl_ismem(rs.getString("fl_ismem"));	freeList.setFl_writer(rs.getString("fl_writer"));
				freeList.setFl_pw(rs.getString("fl_pw"));	freeList.setFl_title(rs.getString("fl_title"));	freeList.setFl_content(rs.getString("fl_content"));
				freeList.setFl_date(rs.getString("fl_date"));	freeList.setFl_read(rs.getInt("fl_read"));	freeList.setFl_ip(rs.getString("fl_ip"));
				close(rs);
				return freeList;
			}
		} catch (Exception e) {
			System.out.println("FreeProcDao Ŭ������ getFreeInfo() �޼ҵ� ����");
			e.printStackTrace();
		}
		return null;
	}

	public String getIsMem(int flidx) {	// ������ ���� ��ȸ�� ������ ���θ� �����ϴ� �޼ҵ�
		try {
			String result = null;
			ResultSet rs = conn.createStatement().executeQuery("select fl_ismem from t_free_list where fl_isview = 'y' and fl_idx = " + flidx);			
			if (rs.next()) {
				result = rs.getString(1);
				close(rs);
				return result;		
			}
			else{
				close(rs);
				return result;
			}
		} catch (Exception e) {
			System.out.println("FreeProcDao Ŭ������ getIsMem() �޼ҵ� ����");
			e.printStackTrace();
		}
		return null;
	}
	public FreeList getFreeListInfoUp(String where) {	// ������ Ư�� �Խñ��� �������� FreeList�� �ν��Ͻ��� �����ϴ� �޼ҵ�
		try {			
			ResultSet rs = conn.createStatement().executeQuery("select * from t_free_list where fl_isview = 'y' " + where);
			if (rs.next()) {
				FreeList freeList = new FreeList();
				freeList.setFl_idx(rs.getInt("fl_idx"));		freeList.setFl_ismem(rs.getString("fl_ismem"));		freeList.setFl_writer(rs.getString("fl_writer"));
				freeList.setFl_title(rs.getString("fl_title"));	freeList.setFl_content(rs.getString("fl_content"));	freeList.setFl_date(rs.getString("fl_date"));	
				close(rs);
				return freeList;
			}
		} catch (Exception e) {
			System.out.println("FreeProcDao Ŭ������ getFreeListInfoUp() �޼ҵ� ����");
			e.printStackTrace();
		}
		return null;
	}



	public int freeUpdate(FreeList freeList) {	// ����
		try {
			return conn.createStatement().executeUpdate("update t_free_list set fl_title = '" + freeList.getFl_title() + "', fl_content = '" + freeList.getFl_content() + "' where fl_idx = " + freeList.getFl_idx());
		} catch (Exception e) {
			System.out.println("FreeProcDao Ŭ������ freeUpdate() �޼ҵ� ����");
			e.printStackTrace();
		}
		return 0;
	}

	public int freeDelete(String where) {	// ����
		try {
			return conn.createStatement().executeUpdate("update t_free_list set fl_isview = 'n' where fl_isview = 'y' " + where);
		} catch (Exception e) {
			System.out.println("FreeProcDao Ŭ������ freeDelete() �޼ҵ� ����");
			e.printStackTrace();
		}
		return 0;
	}
}
