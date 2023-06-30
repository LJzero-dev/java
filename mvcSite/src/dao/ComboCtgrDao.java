package dao;

import static db.JdbcUtil.*;	// JdbcUtil Ŭ������ ��� ������� �����Ӱ� ���
import java.util.*;
import com.sun.org.apache.regexp.internal.recompile;
import java.sql.*;
import vo.*;

public class ComboCtgrDao {
	private static ComboCtgrDao comboCtgrDao;
	private Connection conn;
	private ComboCtgrDao() {}
	
	public static ComboCtgrDao getInstance() {
		if (comboCtgrDao == null) comboCtgrDao = new ComboCtgrDao();
		return comboCtgrDao;
	}
	public void setConnection(Connection conn) {
		this.conn = conn;
	}	
	public ArrayList<ProductCtgrBig> getBigList() {	// ��ǰ ��з� ����� ArrayList<ProductCtgrBig> ������ �����ϴ� �޼ҵ�
		ResultSet rs = null;
		ArrayList<ProductCtgrBig> bigList = new ArrayList<ProductCtgrBig>();
		try {			
			rs = conn.createStatement().executeQuery("select * from t_product_ctgr_big");			
			while (rs.next()) {
				ProductCtgrBig productCtgrBig = new ProductCtgrBig();
				productCtgrBig.setPcb_id(rs.getString("Pcb_id"));
				productCtgrBig.setPcb_name(rs.getString("pcb_name"));
				bigList.add(productCtgrBig);
			}
			
		} catch (Exception e) {
			System.out.println("ComboCtgrDao Ŭ������ getBigList() �޼ҵ� ����");
			e.printStackTrace();
		} finally {
			close(rs);
		}
		return bigList;
	}
	public ArrayList<ProductCtgrSmall> getSmallList() {	// ��ǰ ��з� ����� ArrayList<ProductCtgrBig> ������ �����ϴ� �޼ҵ�
		ResultSet rs = null;
		ArrayList<ProductCtgrSmall> smallList = new ArrayList<ProductCtgrSmall>();
		try {			
			rs = conn.createStatement().executeQuery("select * from t_product_ctgr_small");			
			while (rs.next()) {
				ProductCtgrSmall productCtgrSmall = new ProductCtgrSmall();
				productCtgrSmall.setPcb_id(rs.getString("pcb_id"));
				productCtgrSmall.setPcs_id(rs.getString("pcs_id"));
				productCtgrSmall.setPcs_name(rs.getString("pcs_name"));
				smallList.add(productCtgrSmall);
			}
			
		} catch (Exception e) {
			System.out.println("ComboCtgrDao Ŭ������ getSmallList() �޼ҵ� ����");
			e.printStackTrace();
		} finally {
			close(rs);
		}
		return smallList;
	}
}
