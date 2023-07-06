package dao;

import static db.JdbcUtil.*;	// JdbcUtil Ŭ������ ��� ������� �����Ӱ� ���
import java.util.*;
import com.sun.org.apache.regexp.internal.recompile;
import java.sql.*;
import vo.*;

public class CartProcDao {	// ��ٱ��� ���� �۾�(��ٱ��Ͽ� ���, ����, ����, ����)���� ó���ϴ� Ŭ����
	private static CartProcDao cartProcDao;
	private Connection conn;
	private CartProcDao() {}
	
	public static CartProcDao getInstance() {
		if (cartProcDao == null) cartProcDao = new CartProcDao();
		return cartProcDao;
	}
	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public int cartInsert(OrderCart oc) {	// ����ڰ� ������ ��ǰ(�ɼ�, ���� ����)�� ��ٱ��Ͽ� ��� �޼ҵ�
		try {
			if (conn.createStatement().executeUpdate("update t_order_cart set oc_cnt = oc_cnt + " + oc.getOc_cnt() + " where mi_id = '" + oc.getMi_id() + "' and pi_id = '" + oc.getPi_id() + "' and ps_idx = " + oc.getPs_idx()) == 1) {
				return 1;
			} else {
				return conn.createStatement().executeUpdate("insert into t_order_cart (mi_id, pi_id, ps_idx, oc_cnt) values ('" + oc.getMi_id() + "','" + oc.getPi_id() + "','" + oc.getPs_idx() + "'," + oc.getOc_cnt() + ")");
			}		
		}catch (Exception e) {
			System.out.println("CartProcDao Ŭ������ cartInsert() �޼ҵ� ����");
			e.printStackTrace();
			}
		return 0;		
	}

	public ArrayList<OrderCart> getCartList(String miid) {	// ���� �α����� ȸ���� ��ٱ��Ͽ��� ������ ��ǰ �������� ArrayList�� �����ϴ� �޼ҵ�
		ResultSet rs = null;
		ArrayList<OrderCart> cartList = new ArrayList<OrderCart>();
		OrderCart oc = null;
		
		try {
			ProductProcDao ppd = ProductProcDao.getInstance();
			ppd.setConnection(conn);
			rs = conn.createStatement().executeQuery("select a.*,b.pi_name, b.pi_img1, if(b.pi_dc > 0, round((1 - b.pi_dc) * b.pi_price) ,b.pi_dc) price from t_order_cart a, t_product_info b where a.pi_id = b.pi_id and b.pi_isview = 'y' and a.mi_id = '" + miid + "' order by a.pi_id, a.ps_idx");
			while (rs.next()) {
				oc = new OrderCart();
	            oc.setOc_idx(rs.getInt("oc_idx"));	oc.setMi_id(rs.getString("mi_id"));	oc.setPi_id(rs.getString("pi_id"));	oc.setPs_idx(rs.getInt("ps_idx"));	oc.setOc_cnt(rs.getInt("oc_cnt"));
	            oc.setOc_date(rs.getString("oc_date"));	oc.setPi_name(rs.getString("pi_name"));	oc.setPi_img1(rs.getString("pi_img1"));	oc.setPi_price(rs.getInt("price"));
	            oc.setStockList(ppd.getStockList(oc.getPi_id()));	cartList.add(oc);	// ���� ��ǰ�� �ɼ� �� ��� ����� ProductProcDao Ŭ������ getStockList() �޼ҵ�� �۾�
			}
		} catch (Exception e) {
			System.out.println("CartProcDao Ŭ������ getCartList() �޼ҵ� ����");
			e.printStackTrace();
		} finally {
			close(rs);
		}
		return cartList;
	}

	public int cartDelete(String where) {	// ������ ��ǰ(��)�� ��ٱ��Ͽ��� �����ϴ� �޼ҵ�
		try {
			return conn.createStatement().executeUpdate("delete from t_order_cart " + where);
		} catch (Exception e) {
			System.out.println("CartProcDao Ŭ������ cartDelete() �޼ҵ� ����");
			e.printStackTrace();
		}
		return 0;
	}
}