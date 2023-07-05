package dao;

import static db.JdbcUtil.*;	// JdbcUtil 클래스의 모든 멤버들을 자유롭게 사용
import java.util.*;
import com.sun.org.apache.regexp.internal.recompile;
import java.sql.*;
import vo.*;

public class ProductProcDao {	// 상ㅍ훔 관련 작업(목록 및 상세 보기)들을 처리하는 클래스
	private static ProductProcDao productProcDao;
	private Connection conn;
	private ProductProcDao() {}
	
	public static ProductProcDao getInstance() {
		if (productProcDao == null) productProcDao = new ProductProcDao();
		return productProcDao;
	}
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	public int getProductCount(String where) {	// 검색되는 상품의 개수를 리턴하는 메소드
		int rcnt = 0;
		try {
			ResultSet rs = conn.createStatement().executeQuery(" select count(*) from t_product_info a where a.pi_isview = 'y'" + where);	if(rs.next())	rcnt = rs.getInt(1);	close(rs);
		} catch (Exception e) {
			System.out.println("ProductProcDao 클래스 의 getProductCount() 메소드 오류");			
			e.printStackTrace();
		}
		return rcnt;
	}

	public ArrayList<ProductInfo> getProductList(int cpage, int psize, String where, String orderBy) {	// 검색되는 상품들의 목록을 지정한 페이지에 맞춰 ArrayList<ProductInfo>형으로 리턴하는 메소드
		ArrayList<ProductInfo> productList = new ArrayList<ProductInfo>();
		ProductInfo pi = null;
		ResultSet rs = null;
		try {
			 rs = conn.createStatement().executeQuery("select a.pi_id, a.pi_name, a.pi_img1, a.pi_price, a.pi_dc, a.pi_special, a.pi_review, a.pi_sale, a.pi_score, sum(b.ps_stock) stock " + 
			 		" from t_product_info a, t_product_stock b " + 
			 		" where a.pi_id = b.pi_id and a.pi_isview = 'y' " + where +
			 		" group by a.pi_id " + orderBy + " limit " + ((cpage-1) * psize) + ", " + psize);
			 
			 while (rs.next()) {
				 pi = new ProductInfo();	pi.setPi_id(rs.getString("pi_id"));
				 pi.setPi_id(rs.getString("pi_id"));	 pi.setPi_name(rs.getString("pi_name"));	 pi.setPi_img1(rs.getString("pi_img1"));
				 pi.setPi_price(rs.getInt("pi_price"));	 pi.setPi_dc(rs.getDouble("pi_dc"));		 pi.setPi_special(rs.getString("pi_special"));
				 pi.setPi_review(rs.getInt("pi_review"));pi.setPi_sale(rs.getInt("pi_sale"));		 pi.setPi_score(rs.getDouble("pi_score"));
				 pi.setStock(rs.getInt("stock"));
				 productList.add(pi);				 
			 }
		} catch (Exception e) {
			System.out.println("ProductProcDao 클래스 의 getProductList() 메소드 오류");			
			e.printStackTrace();
		}
		finally {
			close(rs);
		}
		return productList;
	}

	public ArrayList<ProductCtgrSmall> getCtgrSmallList(String pcb) {
		ArrayList<ProductCtgrSmall> smallList = new ArrayList<ProductCtgrSmall>();
		ResultSet rs = null;
		try {
			rs = conn.createStatement().executeQuery("select * from t_product_ctgr_small where pcb_id = '" + pcb + "' ");
			while (rs.next()) {
				ProductCtgrSmall pcs = new ProductCtgrSmall();
				pcs.setPcs_id(rs.getString("pcs_id"));	pcs.setPcs_name(rs.getString("pcs_name"));	pcs.setPcb_id(pcb);	smallList.add(pcs);
			}
		} catch (Exception e) {
			System.out.println("ProductProcDao 클래스 의 getCtgrSmallList() 메소드 오류");			
			e.printStackTrace();
		} finally {
			close(rs);
		}
		
		return smallList;
	}

	public ArrayList<ProductBrand> getBrandList() {	// 검색 조건에서 보여줄 브랜드 목록을 ArrayList<ProductBrand>형으로 리턴하는 메소드
		ArrayList<ProductBrand> brandList = new ArrayList<ProductBrand>();
		ProductBrand br = null;
		ResultSet rs = null;
		try {
			rs = conn.createStatement().executeQuery("select * from t_product_brand order by pb_name");
			while (rs.next()) {
				br = new ProductBrand();
				br.setPb_id(rs.getString("pb_id"));	br.setPb_name(rs.getString("pb_name"));	brandList.add(br);
			}
		}catch (Exception e) {
			System.out.println("ProductProcDao 클래스 의 getBrandList() 메소드 오류");	
			e.printStackTrace();
		} finally {
			close(rs);
		}
		return brandList;
	}

	public int readUpdate(String piid) {	// 특정 상품에 조회수를 1 증가시키는 메소드
		try {
			return conn.createStatement().executeUpdate("update t_product_info set pi_read = pi_read + 1 where pi_isview = 'y' and pi_id = '" + piid + "'");
		}catch (Exception e) {
			System.out.println("ProductProcDao 클래스 의 readUpdate() 메소드 오류");	
			e.printStackTrace();
		}
		return 0;
	}

	public ProductInfo getProductInfo(String piid) {	// 사용자가 선택한 상품의 정보를 ProductInfo형 인스턴스로 리턴하는 메소드
		ResultSet rs = null;
		ProductInfo pi = null;
		try {
			rs = conn.createStatement().executeQuery("select a.*, b.pcb_name, c.pcs_name, d.pb_name from t_product_info a, t_product_ctgr_big b, t_product_ctgr_small c, t_product_brand d " +
					"where a.pcs_id = c.pcs_id and b.pcb_id = c.pcb_id and a.pb_id = d.pb_id and a.pi_isview = 'y' and a.pi_id = '" + piid + "'");
			if (rs.next()) {
				pi = new ProductInfo();	// 상품 정보를 저장할 인스턴스 생성
				pi.setPi_id(rs.getString("pi_id"));	pi.setPcs_id(rs.getString("pcs_id"));	pi.setPb_id(rs.getString("pb_id"));	pi.setPi_name(rs.getString("pi_name"));
	            pi.setPi_price(rs.getInt("pi_price")); pi.setPi_cost(rs.getInt("pi_cost")); pi.setPi_dc(rs.getDouble("pi_dc")); pi.setPi_com(rs.getString("pi_com"));
	            pi.setPi_img1(rs.getString("pi_img1")); pi.setPi_img2(rs.getString("pi_img2")); pi.setPi_img3(rs.getString("pi_img3")); pi.setPi_desc(rs.getString("pi_desc"));
	            pi.setPi_special(rs.getString("pi_special")); pi.setPi_read(rs.getInt("pi_read")); pi.setPi_score(rs.getDouble("pi_score")); pi.setPi_review(rs.getInt("pi_review"));
	            pi.setPi_sale(rs.getInt("pi_sale")); pi.setPi_isview(rs.getString("pi_isview")); pi.setPi_date(rs.getString("pi_date")); pi.setPi_last(rs.getString("pi_last"));
	            pi.setPcb_name(rs.getString("pcb_name")); pi.setPcs_name(rs.getString("pcs_name")); pi.setPb_name(rs.getString("pb_name"));	pi.setStockList(getStockList(piid));	// 현 상품의 사이즈와 재고량 목록을 ArrayList로 받아 pi에 저장
			}
		}catch (Exception e) {
			System.out.println("ProductProcDao 클래스 의 getProductInfo() 메소드 오류");	
			e.printStackTrace();
		}finally {
			close(rs);
		}
		return pi;
	}
	
	public ArrayList<ProductStock> getStockList(String piid) {	// 지정한 상품의 옵션별 재고량 목록을 ArrayList<ProductStock>형으로 리턴하는 메소드
		ResultSet rs = null;
		ArrayList<ProductStock> stockList = new ArrayList<ProductStock>();
		ProductStock ps = null;
		try {
			ps = new ProductStock();
			rs = conn.createStatement().executeQuery("select ps_idx, ps_size, ps_stock from t_product_stock where ps_isview = 'y' and pi_id = '" + piid + "' order by ps_size");
			while (rs.next()) {
				ps = new ProductStock();
				ps.setPs_idx(rs.getInt(1)); ps.setPs_size(rs.getInt(2)); ps.setPs_stock(rs.getInt(3));	ps.setPi_id(piid);
				stockList.add(ps);
			}
		} catch (Exception e) {
			System.out.println("ProductProcDao 클래스 의 getStockList() 메소드 오류");	
			e.printStackTrace();
		}finally {
			close(rs);
		}
		return stockList;
	}

	public ArrayList<ReviewList> getReviewList(String piid) {
		ArrayList<ReviewList> reviewList = new ArrayList<ReviewList>();
		ReviewList rl = null;
		ResultSet rs = null;
		
		try {
			rs = conn.createStatement().executeQuery("select * from t_review_list where rl_isview = 'y' and pi_id = '" + piid + "' order by rl_idx desc");
			while (rs.next()) {
				rl = new ReviewList();
				rl.setRl_idx(rs.getInt("rl_idx"));	rl.setMi_id(rs.getString("mi_id"));	rl.setOi_id(rs.getString("oi_id"));	rl.setPi_id(rs.getString("pi_id"));
				rl.setPs_idx(rs.getInt("ps_idx"));	rl.setRl_name(rs.getString("rl_name"));	rl.setRl_title(rs.getString("rl_title"));	rl.setRl_content(rs.getString("rl_content"));
				rl.setRe_img(rs.getString("re_img"));	rl.setRl_score(rs.getDouble("rl_score"));	rl.setRl_read(rs.getInt("rl_read"));	rl.setRl_good(rs.getInt("rl_good"));
				rl.setRl_ip(rs.getString("rl_ip"));	rl.setRl_date(rs.getString("rl_date"));	reviewList.add(rl);
			}
		} catch (Exception e) {
			System.out.println("ProductProcDao 클래스 의 getReviewList() 메소드 오류");	
			e.printStackTrace();
		}finally {
			close(rs);
		}
		return reviewList;
	}
}
