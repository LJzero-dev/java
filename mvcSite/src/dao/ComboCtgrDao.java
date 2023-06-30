package dao;

import static db.JdbcUtil.*;	// JdbcUtil 클래스의 모든 멤버들을 자유롭게 사용
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
	public ArrayList<ProductCtgrBig> getBigList() {	// 상품 대분류 목록을 ArrayList<ProductCtgrBig> 형으로 리턴하는 메소드
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
			System.out.println("ComboCtgrDao 클래스의 getBigList() 메소드 오류");
			e.printStackTrace();
		} finally {
			close(rs);
		}
		return bigList;
	}
	public ArrayList<ProductCtgrSmall> getSmallList() {	// 상품 대분류 목록을 ArrayList<ProductCtgrBig> 형으로 리턴하는 메소드
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
			System.out.println("ComboCtgrDao 클래스의 getSmallList() 메소드 오류");
			e.printStackTrace();
		} finally {
			close(rs);
		}
		return smallList;
	}
}
