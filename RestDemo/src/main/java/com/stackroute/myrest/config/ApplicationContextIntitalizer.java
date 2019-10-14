package com.stackroute.myrest.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("com.stackroute.myrest")
@EnableTransactionManagement 

public class ApplicationContextIntitalizer {

	@Bean(name="dataSource")
	@Autowired 
	public DataSource mydataSource() {
		
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/movie");
		dataSource.setUsername("root");
		dataSource.setPassword("password");
		return dataSource;
	}
	public Properties getprop() {
		Properties properties=new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		
		return properties;
	}
	
	@Bean(name="sessionFactory")
	@Autowired
	public SessionFactory getsessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionFactory=new LocalSessionFactoryBuilder(dataSource);
 
		sessionFactory.addProperties(getprop());
		sessionFactory.scanPackages("com.stackroute.myrest.model");
		return sessionFactory.buildSessionFactory();
	}
	
	@Bean(name="transact")
	@Autowired
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) 
	{
		HibernateTransactionManager transact=new HibernateTransactionManager();
		transact.setSessionFactory(sessionFactory);
		
		return transact;
	}
}
