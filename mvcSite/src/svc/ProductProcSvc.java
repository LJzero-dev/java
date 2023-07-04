package svc;

import static db.JdbcUtil.*;	// JdbcUtil Ŭ������ ��� ������� �����Ӱ� ���
import java.util.*;
import java.sql.*;
import dao.*;
import vo.*;

public class ProductProcSvc {
	public int getProductCount(String where) {
		int rcnt = 0;
		Connection conn = getConnection();
		ProductProcDao productProcDao = ProductProcDao.getInstance();
		productProcDao.setConnection(conn);
		
		rcnt = productProcDao.getProductCount(where);
		close(conn);
		
		return rcnt;
	}

	public ArrayList<ProductInfo> getProductList(int cpage, int psize, String where, String orderBy) {
		ArrayList<ProductInfo> productList = new ArrayList<ProductInfo>();
		Connection conn = getConnection();
		ProductProcDao productProcDao = ProductProcDao.getInstance();
		productProcDao.setConnection(conn);
		
		productList = productProcDao.getProductList(cpage, psize, where, orderBy);
		close(conn);
		
		return productList;
	}

	public ArrayList<ProductCtgrSmall> getCtgrSmallList(String pcb) {
		ArrayList<ProductCtgrSmall> smallList = new ArrayList<ProductCtgrSmall>();
		Connection conn = getConnection();
		ProductProcDao productProcDao = ProductProcDao.getInstance();
		productProcDao.setConnection(conn);
		
		smallList = productProcDao.getCtgrSmallList(pcb);
		close(conn);
		
		return smallList;
	}

	public ArrayList<ProductBrand> getBrandList() {
		ArrayList<ProductBrand> brandList = new ArrayList<ProductBrand>();
		Connection conn = getConnection();
		ProductProcDao productProcDao = ProductProcDao.getInstance();
		productProcDao.setConnection(conn);
		
		brandList = productProcDao.getBrandList();
		close(conn);
		
		return brandList;
	}

	public int readUpdate(String piid) {
		Connection conn = getConnection();
		ProductProcDao productProcDao = ProductProcDao.getInstance();
		productProcDao.setConnection(conn);
		
		int result = productProcDao.readUpdate(piid);
		if (result == 1) commit(conn);
		else			rollback(conn);
		
		close(conn);		
		return result;		
	}

	public ProductInfo getProductInfo(String piid) {
		ProductInfo pi = new ProductInfo();
		Connection conn = getConnection();
		ProductProcDao productProcDao = ProductProcDao.getInstance();
		productProcDao.setConnection(conn);
		
		pi = productProcDao.getProductInfo(piid);
		
		close(conn);		
		return pi;	
	}
}
