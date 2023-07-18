package svc;

import config.DbConfig;
import dao.LoginDaoMvc;
import vo.MemberInfo;

public class LoginSvcMvc {
	public MemberInfo getLoginInfo(String uid, String pwd) {
		MemberInfo mi = null;
		DbConfig dbConfig = new DbConfig();
		LoginDaoMvc loginDaoMvc = new LoginDaoMvc(dbConfig.dataSource());
		mi = loginDaoMvc.getLoginInfo(uid, pwd);
		return mi;
	}
}
