package svc;

import static db.JdbcUtil.*;	// JdbcUtil 클래스의 모든 멤버들을 자유롭게 사용
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
}