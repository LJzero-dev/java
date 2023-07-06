package svc;

import static db.JdbcUtil.*;	// JdbcUtil Ŭ������ ��� ������� �����Ӱ� ���
import java.util.*;
import java.sql.*;
import dao.*;
import vo.*;

public class CartProcSvc {
	public int cartInsert(OrderCart oc) {
		int result = 0;
		Connection conn = getConnection();
		CartProcDao cartProcDao = CartProcDao.getInstance();
		cartProcDao.setConnection(conn);
		
		result = cartProcDao.cartInsert(oc);
		if (result == 1)commit(conn);
		else			rollback(conn);
		close(conn);
		return result;
	}

	public ArrayList<OrderCart> getCartList(String miid) {
		ArrayList<OrderCart> cartList = new ArrayList<OrderCart>();
		Connection conn = getConnection();
		CartProcDao cartProcDao = CartProcDao.getInstance();
		cartProcDao.setConnection(conn);
		
		cartList = cartProcDao.getCartList(miid);
		close(conn);
		return cartList;
	}

	public int cartDelete(String where) {
		Connection conn = getConnection();
		CartProcDao cartProcDao = CartProcDao.getInstance();
		cartProcDao.setConnection(conn);
		
		int result = cartProcDao.cartDelete(where);
		if (result >= 1)	commit(conn);	// ���� ��ǰ�� ������ ��� ����(����)�� ���ڵ尡 1�� ���� �� �����Ƿ� 1�̻����� ������ ��
		else				rollback(conn);
		close(conn);
		return result;
	}
}