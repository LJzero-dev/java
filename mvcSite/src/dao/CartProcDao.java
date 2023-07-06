package dao;

import static db.JdbcUtil.*;	// JdbcUtil 클래스의 모든 멤버들을 자유롭게 사용
import java.util.*;
import com.sun.org.apache.regexp.internal.recompile;
import java.sql.*;
import vo.*;

public class CartProcDao {	// 장바구니 관련 작업(장바구니에 등록, 보기, 수정, 삭제)들을 처리하는 클래스
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

	public int cartInsert(OrderCart oc) {	// 사용자가 선택한 상품(옵션, 수량 포함)을 장바구니에 담는 메소드
		try {
			if (conn.createStatement().executeUpdate("update t_order_cart set oc_cnt = oc_cnt + " + oc.getOc_cnt() + " where mi_id = '" + oc.getMi_id() + "' and pi_id = '" + oc.getPi_id() + "' and ps_idx = " + oc.getPs_idx()) == 1) {
				return 1;
			} else {
				return conn.createStatement().executeUpdate("insert into t_order_cart (mi_id, pi_id, ps_idx, oc_cnt) values ('" + oc.getMi_id() + "','" + oc.getPi_id() + "','" + oc.getPs_idx() + "'," + oc.getOc_cnt() + ")");
			}		
		}catch (Exception e) {
			System.out.println("CartProcDao 클래스의 cartInsert() 메소드 오류");
			e.printStackTrace();
			}
		return 0;		
	}

	public ArrayList<OrderCart> getCartList(String miid) {	// 현재 로그인한 회원의 장바구니에서 보여줄 상품 정보들을 ArrayList로 리턴하는 메소드
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
	            oc.setStockList(ppd.getStockList(oc.getPi_id()));	cartList.add(oc);	// 현재 상품의 옵션 및 재고량 목록을 ProductProcDao 클래스의 getStockList() 메소드로 작업
			}
		} catch (Exception e) {
			System.out.println("CartProcDao 클래스의 getCartList() 메소드 오류");
			e.printStackTrace();
		} finally {
			close(rs);
		}
		return cartList;
	}

	public int cartDelete(String where) {	// 지정한 상품(들)을 장바구니에서 삭제하는 메소드
		try {
			return conn.createStatement().executeUpdate("delete from t_order_cart " + where);
		} catch (Exception e) {
			System.out.println("CartProcDao 클래스의 cartDelete() 메소드 오류");
			e.printStackTrace();
		}
		return 0;
	}
}