package dao;
import static db.JdbcUtil.*;	// JdbcUtil 클래스의 모든 멤버들을 자유롭게 사용
import java.util.*;

import com.mysql.cj.xdevapi.Result;

import java.sql.*;
import vo.*;

public class OrderProcDao {	// 주문 관련 작업(폼, 등록, 변경)들을 처리하는 클래스
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

	public ArrayList<OrderCart> getBuyList(String kind, String sql) {	// 주문 폼에서 보여줄 구매할 상품목록을 ArrayList<OrderCart>형으로 리턴하는 메소드
		ArrayList<OrderCart> pdtList = new ArrayList<OrderCart>();
		OrderCart oc = null;
		ResultSet rs = null;
		
		try {
			rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				oc = new OrderCart();
				if (kind.equals("c"))	oc.setOc_idx(rs.getInt("oc_idx"));	// 장바구니를 통한 구매일 경우에만 장바구니 인덱스를 추가 저장함
				else					oc.setOc_idx(0);					// 바로 구매일 경우 기본값으로 채워줌
				oc.setPi_id(rs.getString("pi_id"));
				oc.setPi_img1(rs.getString("pi_img1"));
				oc.setPi_name(rs.getString("pi_name"));
				oc.setPi_price(rs.getInt("price"));
				oc.setOc_cnt(rs.getInt("cnt"));
				oc.setPs_size(rs.getInt("ps_size"));
				pdtList.add(oc);				
			}
		} catch (Exception e) {
			System.out.println("OrderProcDao 클래스 의 getBuyList() 메소드 오류");			
			e.printStackTrace();
		} finally {
			close(rs);
		}
		return pdtList;
	}

	public ArrayList<MemberAddr> getAddrList(String miid) {	// 주문 폼에서 보여줄 현재 로그인한 회원의 주소목록을 ArrayList<MemberAddr>으로 리턴하는 메소드
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
			System.out.println("OrderProcDao 클래스 의 getAddrList() 메소드 오류");			
			e.printStackTrace();
		} finally {
			close(rs);
		}
		return addrList;
	}
}
