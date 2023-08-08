package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import dao.LoginDaoSpr;
import dao.MemberDao;
import svc.LoginSvcSpr;
import svc.MemberSvc;

@Configuration
//@EnableTransactionManagement	// @Transaction �ֳ����̼��� ���� �޼ҵ带 Ʈ����� �������� �����ϴ� ������� Ȱ��ȭ��Ŵ ����� PlatformTrasactionManager ���� ����Ͽ� Ʈ������� ������
public class MemberConfig {	// ȸ�� ���� �۾� ���� Ŭ����
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
			DataSource ds = new DataSource();
			ds.setDriverClassName("com.mysql.jdbc.Driver");	ds.setUrl("jdbc:mysql://localhost/mall?characterEncoding=utf8");	ds.setUsername("root");	ds.setPassword("1234");
			ds.setInitialSize(2);	ds.setMaxActive(10);	ds.setTestWhileIdle(true);ds.setMinEvictableIdleTimeMillis(60000 * 3);	ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
			return ds;
	}
	
/*	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager tm = new DataSourceTransactionManager();
		return tm;
	}
	*/
	@Bean
	public LoginDaoSpr loginDaoSpr() {
		return new LoginDaoSpr(dataSource());
	}
	@Bean
	public LoginSvcSpr loginSvcSpr() {
		LoginSvcSpr loginSvcSpr = new LoginSvcSpr();
		loginSvcSpr.setLoginDaoSpr(loginDaoSpr());
		return loginSvcSpr;
	}
	@Bean
	public MemberDao memberDao() {
		return new MemberDao(dataSource());
	}
	@Bean
	public MemberSvc memberSvc() {
		MemberSvc memberSvc = new MemberSvc();
		memberSvc.setMemberDao(memberDao());
		return memberSvc;		
	}
}