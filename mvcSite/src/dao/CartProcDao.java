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

	public int cartInsert(OrderCart oc) {
		try {
			return conn.createStatement().executeUpdate("insert into t_order_cart (mi_id, pi_id, ps_idx, oc_cnt) values ('" + oc.getMi_id() + "','" + oc.getPi_id() + "','" + oc.getPs_idx() + "'," + oc.getOc_cnt() + ")");
		}catch (Exception e) {
			System.out.println("CartProcDao 클래스의 cartInsert() 메소드 오류");
			e.printStackTrace();
		}
		return 0;
	}
}