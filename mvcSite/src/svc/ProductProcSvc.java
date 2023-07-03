package svc;

import static db.JdbcUtil.*;	// JdbcUtil 클래스의 모든 멤버들을 자유롭게 사용
import java.util.*;
import java.sql.*;
import dao.*;
import vo.*;

public class ProductProcSvc {
	public int getProductCount(String where) {
		int rcnt = 0;
		Connection conn = getConnection();
		ProductProcDao froductProcDao = ProductProcDao.getInstance();
		froductProcDao.setConnection(conn);
		
		rcnt = froductProcDao.getProductCount(where);
		close(conn);
		
		return rcnt;
	}

	public ArrayList<ProductInfo> getProductList(int cpage, int psize, String where, String orderBy) {
		ArrayList<ProductInfo> productList = new ArrayList<ProductInfo>();
		Connection conn = getConnection();
		ProductProcDao froductProcDao = ProductProcDao.getInstance();
		froductProcDao.setConnection(conn);
		
		productList = froductProcDao.getProductList(cpage, psize, where, orderBy);
		close(conn);
		
		return productList;
	}

	public ArrayList<ProductCtgrSmall> getCtgrSmallList(String pcb) {
		ArrayList<ProductCtgrSmall> smallList = new ArrayList<ProductCtgrSmall>();
		Connection conn = getConnection();
		ProductProcDao froductProcDao = ProductProcDao.getInstance();
		froductProcDao.setConnection(conn);
		
		smallList = froductProcDao.getCtgrSmallList(pcb);
		close(conn);
		
		return smallList;
	}

	public ArrayList<ProductBrand> getBrandList() {
		ArrayList<ProductBrand> brandList = new ArrayList<ProductBrand>();
		Connection conn = getConnection();
		ProductProcDao froductProcDao = ProductProcDao.getInstance();
		froductProcDao.setConnection(conn);
		
		brandList = froductProcDao.getBrandList();
		close(conn);
		
		return brandList;
	}
}
