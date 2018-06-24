package com.mina.config;

import java.util.Properties;

import javax.annotation.PreDestroy;
import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;

@Configuration
@MapperScan(basePackages = "com.mina.*.dao")
public class DataSourceConfig {
		// Druid连接池
		// 连接池配置：https://github.com/alibaba/druid/wiki/DruidDataSource%E9%85%8D%E7%BD%AE%E5%B1%9E%E6%80%A7%E5%88%97%E8%A1%A8
		private DruidDataSource pool;

		@Bean(destroyMethod = "close")
		@ConfigurationProperties(prefix = "spring.datasource")
		public DataSource dataSource() {
			pool = new DruidDataSource();
			return pool;
		}

		@PreDestroy
		public void close() {
			if (this.pool != null) { 
				this.pool.close();
			}
		}

		@Bean
		public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
			SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
			sqlSessionFactoryBean.setDataSource(dataSource());

			// 注入mybatis mapper xml文件
			PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
			sqlSessionFactoryBean.setMapperLocations(resolver
					.getResources("classpath:mapper/*.xml"));
//			 Properties p=new  Properties();		 
//			 p.put("dialect", "mysql");
//			 p.put("offsetAsPageNum", "true");
//			 p.put("rowBoundsWithCount", "true");
//			 p.put("pageSizeZero", "true");
//			 p.put("reasonable", "false");
//			 p.put("params", "pageNum=start;pageSize=limit;");
//			 Interceptor[] plugins=new Interceptor[]{ph};
//			
//			sqlSessionFactoryBean.setPlugins(plugins);
			return sqlSessionFactoryBean.getObject();
		}

		@Bean
		public PlatformTransactionManager transactionManager() {
			return new DataSourceTransactionManager(dataSource());
		}
}
