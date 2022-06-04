package dwaki.convertcurrency.config;

import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import dwaki.convertcurrency.entity.Currency;

@Configuration
@EnableTransactionManagement
public class ConvertCurrencyDatabaseConfig {

	@Bean
	public BasicDataSource getDataSource() {

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/currency");
		dataSource.setUsername("root");
		dataSource.setPassword("root");

		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean getLocalSessionFactoryBean() {

		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(getDataSource());
		factoryBean.setAnnotatedClasses(Currency.class);

		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");

		factoryBean.setHibernateProperties(properties);

		return factoryBean;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {

		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getLocalSessionFactoryBean().getObject());

		return transactionManager;

	}

}
