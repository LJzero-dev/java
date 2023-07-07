package dao;
import static db.JdbcUtil.*;	// JdbcUtil Ŭ������ ��� ������� �����Ӱ� ���
import java.util.*;

import com.mysql.cj.xdevapi.Result;

import java.sql.*;
import vo.*;

public class OrderProcDao {	// �ֹ� ���� �۾�(��, ���, ����)���� ó���ϴ� Ŭ����
	private static OrderProcDao orderProcDao;
	private Connection conn;
	private OrderProcDao() {}
	
	public static OrderProcDao getInstance() {
		if (orderProcDao == null) orderProcDao = new OrderProcDao();
		return orderProcDao;
	}
	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public ArrayList<OrderCart> getBuyList(String kind, String sql) {	// �ֹ� ������ ������ ������ ��ǰ����� ArrayList<OrderCart>������ �����ϴ� �޼ҵ�
		ArrayList<OrderCart> pdtList = new ArrayList<OrderCart>();
		OrderCart oc = null;
		ResultSet rs = null;
		
		try {
			rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				oc = new OrderCart();
				if (kind.equals("c"))	oc.setOc_idx(rs.getInt("oc_idx"));	// ��ٱ��ϸ� ���� ������ ��쿡�� ��ٱ��� �ε����� �߰� ������
				else					oc.setOc_idx(0);					// �ٷ� ������ ��� �⺻������ ä����
				oc.setPi_id(rs.getString("pi_id"));
				oc.setPi_img1(rs.getString("pi_img1"));
				oc.setPi_name(rs.getString("pi_name"));
				oc.setPi_price(rs.getInt("price"));
				oc.setOc_cnt(rs.getInt("cnt"));
				oc.setPs_size(rs.getInt("ps_size"));
				pdtList.add(oc);				
			}
		} catch (Exception e) {
			System.out.println("OrderProcDao Ŭ���� �� getBuyList() �޼ҵ� ����");			
			e.printStackTrace();
		} finally {
			close(rs);
		}
		return pdtList;
	}

	public ArrayList<MemberAddr> getAddrList(String miid) {	// �ֹ� ������ ������ ���� �α����� ȸ���� �ּҸ���� ArrayList<MemberAddr>���� �����ϴ� �޼ҵ�
		ArrayList<MemberAddr> addrList = new ArrayList<MemberAddr>();
		MemberAddr ma = null;
		ResultSet rs = null;
		try {
			rs = conn.createStatement().executeQuery("select * from t_member_addr where mi_id = '" + miid + "' order by ma_basic desc");
			while (rs.next()) {
				ma = new MemberAddr();
				ma.setMa_idx(rs.getInt("ma_idx"));		ma.setMa_name(rs.getString("ma_name"));		ma.setMa_rname(rs.getString("ma_rname"));	ma.setMa_phone(rs.getString("ma_phone"));
				ma.setMa_zip(rs.getString("ma_zip"));	ma.setMa_addr1(rs.getString("ma_addr1"));	ma.setMa_addr2(rs.getString("ma_addr2"));	ma.setMa_basic(rs.getString("ma_basic"));
				addrList.add(ma);
			}
		} catch (Exception e) {
			System.out.println("OrderProcDao Ŭ���� �� getAddrList() �޼ҵ� ����");			
			e.printStackTrace();
		} finally {
			close(rs);
		}
		return addrList;
	}
}
