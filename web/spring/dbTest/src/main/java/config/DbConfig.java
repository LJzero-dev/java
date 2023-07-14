package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spr.DbTestDao;

@Configuration
public class DbConfig {
	@Bean(destroyMethod="close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");	ds.setUrl("jdbc:mysql://localhost/mall?characterEncoding=utf8");	ds.setUsername("root");	ds.setPassword("1234");
		ds.setInitialSize(2);	ds.setMaxActive(10);	ds.setTestWhileIdle(true);ds.setMinEvictableIdleTimeMillis(60000 * 3);	ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
		return ds;
	}	
	@Bean
	public DbTestDao dbTestDao() {
		return new DbTestDao(dataSource());
	}
}