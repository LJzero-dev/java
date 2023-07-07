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

	public int cartUpdate(int ocidx, int opt, int cnt, String miid) {	// ������ ��ǰ�� �ɼ� �Ǵ� ������ �����ϴ� �޼ҵ�
		ResultSet rs = null;
		try {
			if (opt == 0)	return conn.createStatement().executeUpdate("update t_order_cart set oc_cnt = " + cnt + " where mi_id = '" + miid + "' and oc_idx = " + ocidx);
			else {				
				rs = conn.createStatement().executeQuery("select oc_idx, oc_cnt from t_order_cart where mi_id = '"+ miid +"' and ps_idx = " + opt);
				if (rs.next()) {	// �����Ϸ��� �ɼǰ� ������ �ɼ��� ��ǰ�� ��ٱ��Ͽ� �̹� �����ϴ� ��� ���� ��ǰ�� ������ �߰��� �� ����
					conn.createStatement().executeUpdate("update t_order_cart set Ps_idx = " + opt + ",  oc_cnt = oc_cnt + " + rs.getInt("oc_cnt") + " where mi_id = '" + miid + "' and oc_idx = " + ocidx);
					return conn.createStatement().executeUpdate("delete from t_order_cart where oc_idx = " + ocidx);
				} else {	// �ش� ��ǰ�� �ɼǸ� ����
					return conn.createStatement().executeUpdate("update t_order_cart set ps_idx = " + opt + " where mi_id = '" + miid + "' and oc_idx = " + ocidx);
				}
			}
		} catch (Exception e) {
			System.out.println("CartProcDao Ŭ������ cartUpdate() �޼ҵ� ����");
			e.printStackTrace();
		}
		return 0;
	}
}

///*
//try {
//    stmt = conn.createStatement();
//    String sql = "";
//    if (oc.getOc_cnt() == 0) { //�ɼ� ������ ���
//       sql = "select oc_idx, oc_cnt from t_order_cart where mi_id = '"+ oc.getMi_id() +"' and ps_idx =" + oc.getPs_idx();
///*System.out.println(sql);   */         
//       //�����Ϸ��� �ɼǰ� ������ �ɰ��� ��ǰ�� ��ٱ��Ͽ� �̹� �����ϴ��� ���θ� �˻��� ����
//       rs = stmt.executeQuery(sql);
//       if (rs.next()) {
//       // �����Ϸ��� �ɼǰ� ������ �ɼ��� ��ǰ�� ��ٱ��Ͽ� �̹� �����ϴ� ���
//       // ���� ��ǰ�� ������ �߰��� �� ����
//          int idx = rs.getInt("oc_idx");
//          // stmt�� �ٸ� ������ �����ϱ� ��(delete����)�� ����� ���� �̸� rs���� �޾Ƴ��� �ش�
//          
//          sql = "update t_order_cart set Ps_idx = " + oc.getPs_idx() + ",  oc_cnt = oc_cnt + " + rs.getInt("oc_cnt") + " where mi_id = '" + oc.getMi_id() + "' and oc_idx=" + oc.getOc_idx();
//          // ** �ɼǺ��� �� ������ �ɼ��� ���� ��ǰ ������ �� ��ǰ�� �߰��ϴ� ���� **
///*System.out.println(sql);*/
//          result = stmt.executeUpdate(sql);
//          
//          sql = "delete from t_order_cart where oc_idx = " + idx;
///*System.out.println(sql);*/
//          //������ �ɼ��� ���� ��ǰ�� ��ٱ��Ͽ��� �����ϴ� ����
//       } else {
//       // �����Ϸ��� �ɼǰ� ������ �ɼ��� ��ǰ�� ��ٱ��Ͽ� ���� ���
//       // �ش��ǰ�� �ɼǸ� ����
//          sql = "update t_order_cart set Ps_idx = "+ oc.getPs_idx() + " where mi_id = '"+ oc.getMi_id() +"' and oc_idx=" + oc.getOc_idx();
/////*System.out.println(sql);   */         
//       }
//       close(rs);
//    } else {   //���� ������ ���
//       sql = "update t_order_cart set oc_cnt = "+ oc.getOc_cnt() + " where mi_id = '"+ oc.getMi_id() +"' and oc_idx=" + oc.getOc_idx();
//    }
/////*System.out.println(sql);*/
//    result = stmt.executeUpdate(sql); 
//
//    
//
//
//*/






















