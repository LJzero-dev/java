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

}
