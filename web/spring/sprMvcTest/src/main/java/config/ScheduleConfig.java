package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dao.ScheduleDao;
import svc.ScheduleSvc;

@Configuration
public class ScheduleConfig {
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
			DataSource ds = new DataSource();
			ds.setDriverClassName("com.mysql.jdbc.Driver");	ds.setUrl("jdbc:mysql://localhost/mall?characterEncoding=utf8");	ds.setUsername("root");	ds.setPassword("1234");
			ds.setInitialSize(2);	ds.setMaxActive(10);	ds.setTestWhileIdle(true);ds.setMinEvictableIdleTimeMillis(60000 * 3);	ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
			return ds;
	}
	@Bean
	public ScheduleDao scheduleDao() {
		return new ScheduleDao(dataSource());
	}
	@Bean
	public ScheduleSvc scheduleSvc() {
		ScheduleSvc scheduleSvc = new ScheduleSvc();
		scheduleSvc.setMemberDao(scheduleDao());
		return scheduleSvc;
	}	
}