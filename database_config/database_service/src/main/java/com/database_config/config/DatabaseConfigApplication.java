package com.database_config.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.database_config.helper.Constants;


/**
 * The Class SpringAppRunner.
 */
@SpringBootApplication(exclude = { HibernateJpaAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class, DataSourceAutoConfiguration.class,
		TransactionAutoConfiguration.class, JpaRepositoriesAutoConfiguration.class })
@ComponentScan(basePackages = Constants.BASE_PACKAGE)
public abstract class DatabaseConfigApplication extends JersyConfig {

	/** The app context. */
	private ConfigurableApplicationContext appContext;

	/**
	 * Run.
	 *
	 * @param className the class name
	 * @param args      the args
	 * @return the spring app runner
	 */
	public static DatabaseConfigApplication run(Class<?> className, String[] args) {
		DatabaseConfigApplication app = new DatabaseConfigApplication() {
		};
		app.appContext = SpringApplication.run(className, args);

		System.err.println("App Started...");
		return app;
	}

	/**
	 * Gets the app context.
	 *
	 * @return the app context
	 */
	public ConfigurableApplicationContext getAppContext() {
		return appContext;
	}
}