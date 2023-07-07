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

	public int cartUpdate(int ocidx, int opt, int cnt, String miid) {	// 지정한 상품의 옵션 또는 수량을 변경하는 메소드
		ResultSet rs = null;
		try {
			if (opt == 0)	return conn.createStatement().executeUpdate("update t_order_cart set oc_cnt = " + cnt + " where mi_id = '" + miid + "' and oc_idx = " + ocidx);
			else {				
				rs = conn.createStatement().executeQuery("select oc_idx, oc_cnt from t_order_cart where mi_id = '"+ miid +"' and ps_idx = " + opt);
				if (rs.next()) {	// 변경하려는 옵션과 동일한 옵션의 상품이 장바구니에 이미 존재하는 경우 기존 상품의 수량을 추가한 후 삭제
					conn.createStatement().executeUpdate("update t_order_cart set Ps_idx = " + opt + ",  oc_cnt = oc_cnt + " + rs.getInt("oc_cnt") + " where mi_id = '" + miid + "' and oc_idx = " + ocidx);
					return conn.createStatement().executeUpdate("delete from t_order_cart where oc_idx = " + ocidx);
				} else {	// 해당 상품의 옵션만 변경
					return conn.createStatement().executeUpdate("update t_order_cart set ps_idx = " + opt + " where mi_id = '" + miid + "' and oc_idx = " + ocidx);
				}
			}
		} catch (Exception e) {
			System.out.println("CartProcDao 클래스의 cartUpdate() 메소드 오류");
			e.printStackTrace();
		}
		return 0;
	}
}

///*
//try {
//    stmt = conn.createStatement();
//    String sql = "";
//    if (oc.getOc_cnt() == 0) { //옵션 변경일 경우
//       sql = "select oc_idx, oc_cnt from t_order_cart where mi_id = '"+ oc.getMi_id() +"' and ps_idx =" + oc.getPs_idx();
///*System.out.println(sql);   */         
//       //변경하려는 옵션과 동일한 옵견의 삼품이 장바구니에 이미 존재하는지 여부를 검사할 쿼리
//       rs = stmt.executeQuery(sql);
//       if (rs.next()) {
//       // 변경하려는 옵션과 동일한 옵션의 상품이 장바구니에 이미 존재하는 경우
//       // 기존 상품의 수량을 추가한 후 삭제
//          int idx = rs.getInt("oc_idx");
//          // stmt로 다른 쿼리를 실행하기 전(delete쿼리)에 사용할 값을 미리 rs에서 받아놓아 준다
//          
//          sql = "update t_order_cart set Ps_idx = " + oc.getPs_idx() + ",  oc_cnt = oc_cnt + " + rs.getInt("oc_cnt") + " where mi_id = '" + oc.getMi_id() + "' and oc_idx=" + oc.getOc_idx();
//          // ** 옵션변경 및 동일한 옵션의 기존 상품 수량을 현 상품에 추가하는 쿼리 **
///*System.out.println(sql);*/
//          result = stmt.executeUpdate(sql);
//          
//          sql = "delete from t_order_cart where oc_idx = " + idx;
///*System.out.println(sql);*/
//          //동일한 옵션의 기존 상품을 장바구니에서 삭제하는 쿼리
//       } else {
//       // 변경하려는 옵션과 동일한 옵션의 상품이 장바구니에 없는 경우
//       // 해당상품의 옵션만 변경
//          sql = "update t_order_cart set Ps_idx = "+ oc.getPs_idx() + " where mi_id = '"+ oc.getMi_id() +"' and oc_idx=" + oc.getOc_idx();
/////*System.out.println(sql);   */         
//       }
//       close(rs);
//    } else {   //수량 변경일 경우
//       sql = "update t_order_cart set oc_cnt = "+ oc.getOc_cnt() + " where mi_id = '"+ oc.getMi_id() +"' and oc_idx=" + oc.getOc_idx();
//    }
/////*System.out.println(sql);*/
//    result = stmt.executeUpdate(sql); 
//
//    
//
//
//*/






















