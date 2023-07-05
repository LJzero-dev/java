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

	public int cartInsert(OrderCart oc) {
		try {
			return conn.createStatement().executeUpdate("insert into t_order_cart (mi_id, pi_id, ps_idx, oc_cnt) values ('" + oc.getMi_id() + "','" + oc.getPi_id() + "','" + oc.getPs_idx() + "'," + oc.getOc_cnt() + ")");
		}catch (Exception e) {
			System.out.println("CartProcDao Ŭ������ cartInsert() �޼ҵ� ����");
			e.printStackTrace();
		}
		return 0;
	}
}