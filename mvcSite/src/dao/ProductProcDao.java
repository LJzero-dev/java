package dao;

import static db.JdbcUtil.*;	// JdbcUtil Ŭ������ ��� ������� �����Ӱ� ���
import java.util.*;
import com.sun.org.apache.regexp.internal.recompile;
import java.sql.*;
import vo.*;

public class ProductProcDao {	// ���� ���� �۾�(��� �� �� ����)���� ó���ϴ� Ŭ����
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
	public int getProductCount(String where) {	// �˻��Ǵ� ��ǰ�� ������ �����ϴ� �޼ҵ�
		int rcnt = 0;
		try {
			ResultSet rs = conn.createStatement().executeQuery(" select count(*) from t_product_info a where a.pi_isview = 'y'" + where);	if(rs.next())	rcnt = rs.getInt(1);	close(rs);
		} catch (Exception e) {
			System.out.println("ProductProcDao Ŭ���� �� getProductCount() �޼ҵ� ����");			
			e.printStackTrace();
		}
		return rcnt;
	}

	public ArrayList<ProductInfo> getProductList(int cpage, int psize, String where, String orderBy) {	// �˻��Ǵ� ��ǰ���� ����� ������ �������� ���� ArrayList<ProductInfo>������ �����ϴ� �޼ҵ�
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
			System.out.println("ProductProcDao Ŭ���� �� getProductList() �޼ҵ� ����");			
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
			System.out.println("ProductProcDao Ŭ���� �� getCtgrSmallList() �޼ҵ� ����");			
			e.printStackTrace();
		} finally {
			close(rs);
		}
		
		return smallList;
	}

	public ArrayList<ProductBrand> getBrandList() {	// �˻� ���ǿ��� ������ �귣�� ����� ArrayList<ProductBrand>������ �����ϴ� �޼ҵ�
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
			System.out.println("ProductProcDao Ŭ���� �� getBrandList() �޼ҵ� ����");	
			e.printStackTrace();
		} finally {
			close(rs);
		}
		return brandList;
	}

	public int readUpdate(String piid) {	// Ư�� ��ǰ�� ��ȸ���� 1 ������Ű�� �޼ҵ�
		try {
			return conn.createStatement().executeUpdate("update t_product_info set pi_read = pi_read + 1 where pi_isview = 'y' and pi_id = '" + piid + "'");
		}catch (Exception e) {
			System.out.println("ProductProcDao Ŭ���� �� readUpdate() �޼ҵ� ����");	
			e.printStackTrace();
		}
		return 0;
	}

	public ProductInfo getProductInfo(String piid) {	// ����ڰ� ������ ��ǰ�� ������ ProductInfo�� �ν��Ͻ��� �����ϴ� �޼ҵ�
		ResultSet rs = null;
		ProductInfo pi = null;
		try {
			rs = conn.createStatement().executeQuery("select a.*, b.pcb_name, c.pcs_name, d.pb_name from t_product_info a, t_product_ctgr_big b, t_product_ctgr_small c, t_product_brand d " +
					"where a.pcs_id = c.pcs_id and b.pcb_id = c.pcb_id and a.pb_id = d.pb_id and a.pi_isview = 'y' and a.pi_id = '" + piid + "'");
			if (rs.next()) {
				pi = new ProductInfo();	// ��ǰ ������ ������ �ν��Ͻ� ����
				pi.setPi_id(rs.getString("pi_id"));	pi.setPcs_id(rs.getString("pcs_id"));	pi.setPb_id(rs.getString("pb_id"));	pi.setPi_name(rs.getString("pi_name"));
	            pi.setPi_price(rs.getInt("pi_price")); pi.setPi_cost(rs.getInt("pi_cost")); pi.setPi_dc(rs.getDouble("pi_dc")); pi.setPi_com(rs.getString("pi_com"));
	            pi.setPi_img1(rs.getString("pi_img1")); pi.setPi_img2(rs.getString("pi_img2")); pi.setPi_img3(rs.getString("pi_img3")); pi.setPi_desc(rs.getString("pi_desc"));
	            pi.setPi_special(rs.getString("pi_special")); pi.setPi_read(rs.getInt("pi_read")); pi.setPi_score(rs.getDouble("pi_score")); pi.setPi_review(rs.getInt("pi_review"));
	            pi.setPi_sale(rs.getInt("pi_sale")); pi.setPi_isview(rs.getString("pi_isview")); pi.setPi_date(rs.getString("pi_date")); pi.setPi_last(rs.getString("pi_last"));
	            pi.setPcb_name(rs.getString("pcb_name")); pi.setPcs_name(rs.getString("pcs_name")); pi.setPb_name(rs.getString("pb_name"));	pi.setStockList(getStockList(piid));	// �� ��ǰ�� ������� ��� ����� ArrayList�� �޾� pi�� ����
			}
		}catch (Exception e) {
			System.out.println("ProductProcDao Ŭ���� �� getProductInfo() �޼ҵ� ����");	
			e.printStackTrace();
		}finally {
			close(rs);
		}
		return pi;
	}
	
	public ArrayList<ProductStock> getStockList(String piid) {	// ������ ��ǰ�� �ɼǺ� ��� ����� ArrayList<ProductStock>������ �����ϴ� �޼ҵ�
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
			System.out.println("ProductProcDao Ŭ���� �� getStockList() �޼ҵ� ����");	
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
			System.out.println("ProductProcDao Ŭ���� �� getReviewList() �޼ҵ� ����");	
			e.printStackTrace();
		}finally {
			close(rs);
		}
		return reviewList;
	}
}
