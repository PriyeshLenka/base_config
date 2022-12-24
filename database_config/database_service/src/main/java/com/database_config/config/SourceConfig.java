package com.database_config.config;

import static org.hibernate.cfg.AvailableSettings.DIALECT;
import static org.hibernate.cfg.AvailableSettings.JAKARTA_HBM2DDL_SCRIPTS_ACTION;
import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.dialect.MySQLDialect;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.database_config.helper.Constants;

/**
 * The Class DataSourceConfig.
 */
@EnableTransactionManagement
public class SourceConfig {

	/** The data source. */
	private String dataSource;

	/** The package scan. */
	private String packageScan;

	/** The pu name. */
	private String puName;

	/** The txn name. */
	private String txnName;

	public SourceConfig(String dataSource, String packageScan, String puName, String txnName) {
		this.dataSource = dataSource;
		this.packageScan = packageScan;
		this.puName = puName;
		this.txnName = txnName;
	}

	public DataSource getDataSource() {
		String dbHostUrl = Constants.LOCAL_DB_URL;
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
		dataSourceBuilder.url(dbHostUrl + dataSource);
		dataSourceBuilder.username("root");
		dataSourceBuilder.password("priyesh143");
		return dataSourceBuilder.build();
	}

	protected BeanFactoryPostProcessor createPersistenceBeans() {
		return factory -> {
			BeanDefinitionRegistry registry = (BeanDefinitionRegistry) factory;
			registry.registerBeanDefinition(puName,
					BeanDefinitionBuilder.genericBeanDefinition(LocalContainerEntityManagerFactoryBean.class,
							this::createEntityManagerFactory).getBeanDefinition());

			registry.registerBeanDefinition(txnName,
					BeanDefinitionBuilder
							.genericBeanDefinition(PlatformTransactionManager.class, this::transactionManager)
							.addPropertyReference("entityManagerFactory", puName)
							.addPropertyValue("persistenceUnitName", puName).getBeanDefinition());
		};
	}

	private HibernateJpaVendorAdapter vendorAdaptor() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setShowSql(true);
		return vendorAdapter;
	}

	public LocalContainerEntityManagerFactoryBean createEntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setJpaVendorAdapter(vendorAdaptor());
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManagerFactoryBean.setPackagesToScan(packageScan);
		entityManagerFactoryBean.setJpaProperties(jpaHibernateProperties());
		entityManagerFactoryBean.setDataSource(getDataSource());
		return entityManagerFactoryBean;
	}

	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager();
	}

	public Properties jpaHibernateProperties() {
		Properties properties = new Properties();
		properties.put(JAKARTA_HBM2DDL_SCRIPTS_ACTION, "none");
		properties.put(DIALECT, MySQLDialect.class.getName());
		properties.put(SHOW_SQL, "true");
		return properties;
	}
}