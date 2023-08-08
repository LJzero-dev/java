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
//@EnableTransactionManagement	// @Transaction 애노테이션이 붙은 메소드를 트랜잭션 범위에서 실행하는 기능으로 활성화시킴 등록한 PlatformTrasactionManager 빈을 사용하여 트랜잭션을 적용함
public class MemberConfig {	// 회원 관련 작업 설정 클래스
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